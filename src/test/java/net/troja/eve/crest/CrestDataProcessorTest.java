package net.troja.eve.crest;

/*
 * ========================================================================
 * Library for the Eve Online CREST API
 * ------------------------------------------------------------------------
 * Copyright (C) 2014 - 2015 Jens Oberender <j.obi@troja.net>
 * ------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================================
 */

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.troja.eve.crest.beans.ItemType;
import net.troja.eve.crest.beans.Status;
import net.troja.eve.crest.processors.ItemTypeProcessor;
import net.troja.eve.crest.processors.StatusProcessor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.databind.JsonNode;

public class CrestDataProcessorTest {
    private static final String EXAMPLE_FILE = "/CompleteItemTypes.json";
    private final CrestDataProcessor objectToTest = new CrestDataProcessor();

    @Mock
    private CrestAccessor accessor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        objectToTest.setAccessor(accessor);
    }

    @Test
    public void testContainerParsing() throws IOException, URISyntaxException {
        final ItemTypeProcessor processor = mock(ItemTypeProcessor.class);

        when(accessor.getData(anyString())).thenReturn(getExampleData());
        when(processor.parseEntry((JsonNode) any())).thenReturn(new ItemType());

        final CrestContainer<ItemType> container = objectToTest.downloadAndProcessContainerData(processor);

        assertThat(container.getPageCount(), equalTo(23));
        assertThat(container.getTotalCount(), equalTo(22406));
        assertThat(container.getEntries().size(), equalTo(5));
    }

    private String getExampleData() throws URISyntaxException, IOException {
        final URL resource = getClass().getResource(EXAMPLE_FILE);
        final Path file = Paths.get(resource.toURI());
        final String answer = new String(Files.readAllBytes(file));
        return answer;
    }

    @Test
    public void testEmptyAnswerInContainerParsing() throws IOException {
        final ItemTypeProcessor processor = mock(ItemTypeProcessor.class);
        when(accessor.getData(anyString())).thenReturn("  ");
        final CrestContainer<ItemType> container = objectToTest.downloadAndProcessContainerData(processor);
        assertThat(container, nullValue());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testExceptionWhenReadingDataInContainerParsing() throws IOException {
        when(accessor.getData(anyString())).thenThrow(IOException.class);
        final CrestContainer<ItemType> container = objectToTest.downloadAndProcessContainerData(new ItemTypeProcessor());
        assertThat(container, nullValue());
    }

    @Test
    public void testEmptyAnswerInParsing() throws IOException {
        final StatusProcessor processor = mock(StatusProcessor.class);
        when(accessor.getData(anyString())).thenReturn("  ");
        final Status status = objectToTest.downloadAndProcessData(processor);
        assertThat(status, nullValue());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testExceptionWhenReadingDataInParsing() throws IOException {
        when(accessor.getData(anyString())).thenThrow(IOException.class);
        final Status status = objectToTest.downloadAndProcessData(new StatusProcessor());
        assertThat(status, nullValue());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testExceptionWhenParsingEntry() throws IOException, URISyntaxException {
        final ItemTypeProcessor processor = mock(ItemTypeProcessor.class);

        when(accessor.getData(anyString())).thenReturn(getExampleData());
        when(processor.parseEntry((JsonNode) any())).thenThrow(IOException.class);

        final CrestContainer<ItemType> container = objectToTest.downloadAndProcessContainerData(processor);
        assertThat(container, notNullValue());
    }
}

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

import net.troja.eve.crest.itemtypes.ItemType;
import net.troja.eve.crest.itemtypes.ItemTypeProcessor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.databind.JsonNode;

public class CrestHandlerTest {
    private static final String EXAMPLE_FILE = "/ItemTypes.json";
    private final CrestHandler objectToTest = new CrestHandler();

    @Mock
    private CrestAccessor accessor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        objectToTest.setAccessor(accessor);
    }

    @Test
    public void testContainerParsing() throws IOException, URISyntaxException {
        final ItemTypeProcessor processor = mock(ItemTypeProcessor.class);

        final URL resource = getClass().getResource(EXAMPLE_FILE);
        final Path file = Paths.get(resource.toURI());
        final String answer = new String(Files.readAllBytes(file));
        when(accessor.getData(anyString())).thenReturn(answer);
        when(processor.parseEntry((JsonNode) any())).thenReturn(new ItemType());

        final CrestContainer<ItemType> container = objectToTest.downloadAndProcessData(processor);

        assertThat(container.getPageCount(), equalTo(23));
        assertThat(container.getTotalCount(), equalTo(22406));
        assertThat(container.getEntries().size(), equalTo(5));
    }
}

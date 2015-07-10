package net.troja.eve.crest.processors;

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
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import net.troja.eve.crest.CrestApiProcessorTest;
import net.troja.eve.crest.beans.Status;
import net.troja.eve.crest.beans.Status.State;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class StatusProcessorTest extends CrestApiProcessorTest {
    @Test
    public void testParsing() throws JsonProcessingException, IOException {
        final StatusProcessor processor = new StatusProcessor();

        final JsonNode node = loadAndParseData("Status.json");
        final Status status = processor.parseEntry(node);

        assertThat(status.getServerName(), equalTo("TRANQUILITY"));
        assertThat(status.getServerVersion(), startsWith("EVE-TRANQUILITY "));
        assertThat(status.getServiceStatusDust(), equalTo(State.ONLINE));
        assertThat(status.getServiceStatusEve(), equalTo(State.ONLINE));
        assertThat(status.getServiceStatusServer(), equalTo(State.ONLINE));
        assertThat(status.getUserCountsDust(), greaterThan(1));
        assertThat(status.getUserCountsEve(), greaterThan(1));
    }
}

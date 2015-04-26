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
import static org.junit.Assert.assertThat;

import java.io.IOException;

import net.troja.eve.crest.CrestApiProcessorTest;
import net.troja.eve.crest.beans.IndustryFacility;
import net.troja.eve.crest.processors.IndustryFacilityProcessor;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class IndustrySystemProcessorTest extends CrestApiProcessorTest {
    @Test
    public void testParsing() throws JsonProcessingException, IOException {
        final IndustryFacilityProcessor processor = new IndustryFacilityProcessor();

        final JsonNode node = loadAndParseData("IndustryFacility.json");
        final IndustryFacility industryFacility = processor.parseEntry(node);

        assertThat(industryFacility.getFacilityId(), equalTo(60012544));
        assertThat(industryFacility.getName(), equalTo("Hasiari VIII - Moon 4 - Ammatar Consulate Bureau"));
        assertThat(industryFacility.getSolarSystemId(), equalTo(30000032));
        assertThat(industryFacility.getOwnerId(), equalTo(1000126l));
        assertThat(industryFacility.getRegionId(), equalTo(10000001));
        assertThat(industryFacility.getTax(), equalTo(0.1f));
        assertThat(industryFacility.getTypeId(), equalTo(2502));
    }
}

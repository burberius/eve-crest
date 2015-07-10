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
import net.troja.eve.crest.beans.IndustrySystem;
import net.troja.eve.crest.processors.IndustrySystemProcessor;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class IndustryFacilityProcessorTest extends CrestApiProcessorTest {
    @Test
    public void testParsing() throws JsonProcessingException, IOException {
        final IndustrySystemProcessor processor = new IndustrySystemProcessor();

        final JsonNode node = loadAndParseData("IndustrySystem.json");
        final IndustrySystem industrySystem = processor.parseEntry(node);

        assertThat(industrySystem.getSolarSystemId(), equalTo(30011392));
        assertThat(industrySystem.getSolarSystemName(), equalTo("Jouvulen"));
        assertThat(industrySystem.getCopyingCostIndex(), equalTo(0.002126825019385529d));
        assertThat(industrySystem.getInventionCostIndex(), equalTo(0.002651119668210213d));
        assertThat(industrySystem.getManufacturingCostIndex(), equalTo(0.029556772662022016d));
        assertThat(industrySystem.getResearchingMaterialEfficiencyCostIndex(), equalTo(0.00098d));
        assertThat(industrySystem.getResearchingTimeEfficiencyCostIndex(), equalTo(0.00098d));
    }
}

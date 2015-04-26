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

import java.util.Iterator;

import net.troja.eve.crest.beans.IndustrySystem;
import net.troja.eve.crest.utils.IndustryActivities;
import net.troja.eve.crest.utils.JsonPaths;

import com.fasterxml.jackson.databind.JsonNode;

public class IndustrySystemProcessor implements CrestApiProcessor<IndustrySystem> {
    @Override
    public String getPath() {
        return "/industry/systems/";
    }

    @Override
    public IndustrySystem parseEntry(final JsonNode node) {
        final JsonNode solarSystem = node.path(JsonPaths.SOLARSYSTEM);
        final int id = solarSystem.path(JsonPaths.ID).asInt();
        final String name = solarSystem.path(JsonPaths.NAME).asText();
        final IndustrySystem industrySystem = new IndustrySystem(id, name);
        final Iterator<JsonNode> elements = node.path(JsonPaths.SYSTEMCOSTINDICES).elements();
        while (elements.hasNext()) {
            final JsonNode next = elements.next();
            final double value = next.path(JsonPaths.COSTINDEX).asDouble();
            switch (next.path(JsonPaths.ACTIVITYID).asInt()) {
                case IndustryActivities.Manufacturing:
                    industrySystem.setManufacturingCostIndex(value);
                    break;
                case IndustryActivities.Copying:
                    industrySystem.setCopyingCostIndex(value);
                    break;
                case IndustryActivities.Invention:
                    industrySystem.setInventionCostIndex(value);
                    break;
                case IndustryActivities.ResearchingMaterialEfficiency:
                    industrySystem.setResearchingMaterialEfficiencyCostIndex(value);
                    break;
                case IndustryActivities.ResearchingTimeEfficiency:
                    industrySystem.setResearchingTimeEfficiencyCostIndex(value);
                    break;
                default:
                    break;
            }
        }
        return industrySystem;
    }

}

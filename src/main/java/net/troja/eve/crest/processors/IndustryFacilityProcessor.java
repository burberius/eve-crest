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

import net.troja.eve.crest.beans.IndustryFacility;
import net.troja.eve.crest.utils.JsonPaths;

import com.fasterxml.jackson.databind.JsonNode;

public class IndustryFacilityProcessor implements CrestApiProcessor<IndustryFacility> {
    @Override
    public String getPath() {
        return "/industry/facilities/";
    }

    @Override
    public IndustryFacility parseEntry(final JsonNode node) {
        final int facilityId = node.path(JsonPaths.FACILITYID).asInt();
        final String name = node.path(JsonPaths.NAME).asText();
        final int regionId = node.path(JsonPaths.REGION).path(JsonPaths.ID).asInt();
        final long ownerId = node.path(JsonPaths.OWNER).path(JsonPaths.ID).asLong();
        final int solarSystemId = node.path(JsonPaths.SOLARSYSTEM).path(JsonPaths.ID).asInt();
        final int typeId = node.path(JsonPaths.TYPE).path(JsonPaths.ID).asInt();
        final float tax = (float) node.path(JsonPaths.TAX).asDouble();
        return new IndustryFacility(facilityId, name, tax, solarSystemId, regionId, ownerId, typeId);
    }
}

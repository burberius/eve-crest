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

import net.troja.eve.crest.beans.ItemType;
import net.troja.eve.crest.utils.JsonPaths;

import com.fasterxml.jackson.databind.JsonNode;

public class ItemTypeProcessor implements CrestApiProcessor<ItemType> {
    /**
     * 24 hours
     */
    private static final int REFRESH_INTERVAL = 1000 * 60 * 60 * 24;

    @Override
    public String getPath() {
        return "/types/";
    }

    @Override
    public int getRefreshInterval() {
        return REFRESH_INTERVAL;
    }

    @Override
    public ItemType parseEntry(final JsonNode node) {
        final String href = node.path(JsonPaths.HREF).asText();
        final int id = Integer.parseInt(href.replaceAll(".*/([0-9]+)/$", "$1"));
        return new ItemType(id, node.path(JsonPaths.NAME).asText());
    }
}

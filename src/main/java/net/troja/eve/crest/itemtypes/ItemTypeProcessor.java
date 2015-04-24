package net.troja.eve.crest.itemtypes;

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

import net.troja.eve.crest.CrestApiProcessor;

import com.fasterxml.jackson.databind.JsonNode;

public class ItemTypeProcessor implements CrestApiProcessor<ItemType> {
    @Override
    public String getPath() {
        return "/types/";
    }

    @Override
    public ItemType parseEntry(final JsonNode node) {
        final String href = node.path(PATH_HREF).asText();
        final int id = Integer.parseInt(href.replaceAll(".*/([0-9]+)/$", "$1"));
        return new ItemType(id, node.path(PATH_NAME).asText());
    }
}

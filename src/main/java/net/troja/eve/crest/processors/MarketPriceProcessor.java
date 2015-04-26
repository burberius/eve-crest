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

import net.troja.eve.crest.CrestApiProcessor;
import net.troja.eve.crest.Utils.JsonPaths;
import net.troja.eve.crest.beans.MarketPrice;

import com.fasterxml.jackson.databind.JsonNode;

public class MarketPriceProcessor implements CrestApiProcessor<MarketPrice> {
    @Override
    public String getPath() {
        return "/market/prices/";
    }

    @Override
    public MarketPrice parseEntry(final JsonNode node) {
        final double adjustedPrice = node.path(JsonPaths.ADJUSTEDPRICE).asDouble();
        final double averagePrice = node.path(JsonPaths.AVERAGEPRICE).asDouble();
        final int typeId = node.path(JsonPaths.TYPE).path(JsonPaths.ID).asInt();
        return new MarketPrice(typeId, adjustedPrice, averagePrice);
    }
}

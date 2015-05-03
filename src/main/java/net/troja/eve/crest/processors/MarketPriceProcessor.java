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

import net.troja.eve.crest.beans.MarketPrice;
import net.troja.eve.crest.utils.JsonPaths;

import com.fasterxml.jackson.databind.JsonNode;

public class MarketPriceProcessor implements CrestApiProcessor<MarketPrice> {
    /**
     * Refresh interval: 24 hours.
     */
    private static final int REFRESH_INTERVAL = 1000 * 60 * 60 * 24;

    @Override
    public String getPath() {
        return "/market/prices/";
    }

    @Override
    public int getRefreshInterval() {
        return REFRESH_INTERVAL;
    }

    @Override
    public MarketPrice parseEntry(final JsonNode node) {
        final double adjustedPrice = node.path(JsonPaths.ADJUSTED_PRICE).asDouble();
        final double averagePrice = node.path(JsonPaths.AVERAGE_PRICE).asDouble();
        final int typeId = node.path(JsonPaths.TYPE).path(JsonPaths.ID).asInt();
        return new MarketPrice(typeId, adjustedPrice, averagePrice);
    }
}

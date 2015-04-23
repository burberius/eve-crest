package net.troja.eve.crest.market.prices;

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

import java.util.HashMap;
import java.util.Map;

import net.troja.eve.crest.PublicContainerParser;

public class MarketPricesParser extends PublicContainerParser<MarketPrices, MarketPrice> {
    public MarketPricesParser() {
        cacheDuration = 24;
    }

    @Override
    protected String getPath() {
        return "/market/prices/";
    }

    public Map<Integer, Double> getDataAsMap() {
        final MarketPrices data = getData();
        final Map<Integer, Double> map = new HashMap<>();
        if (data == null) {
            return map;
        }
        for (final MarketPrice price : data.getItems()) {
            map.put(price.getType().getId(), price.getAdjustedPrice());
        }
        return map;
    }
}

package net.troja.eve.crest;

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

import net.troja.eve.crest.itemtypes.ItemType;
import net.troja.eve.crest.itemtypes.ItemTypeProcessor;
import net.troja.eve.crest.market.prices.MarketPrice;
import net.troja.eve.crest.market.prices.MarketPriceProcessor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrestHandler {
    private static final Logger LOGGER = LogManager.getLogger(CrestHandler.class);
    private final CrestDataProcessor processor = new CrestDataProcessor();

    private static final CrestHandler instance = new CrestHandler();

    private final Map<Integer, String> itemTypes = new HashMap<>();

    private CrestHandler() {
        // Static data
        final CrestContainer<ItemType> itemTypeContainer = processor.downloadAndProcessData(new ItemTypeProcessor());
        for (final ItemType itemType : itemTypeContainer.getEntries()) {
            itemTypes.put(itemType.getId(), itemType.getName());
        }
        updateData();
    }

    public static CrestHandler getInstance() {
        return instance;
    }

    private void updateData() {
        final CrestContainer<MarketPrice> marketPriceContainer = processor.downloadAndProcessData(new MarketPriceProcessor());
    }

    public String getItemName(final int id) {
        return itemTypes.get(id);
    }
}

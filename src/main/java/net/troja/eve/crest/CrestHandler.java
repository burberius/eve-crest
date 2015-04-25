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
import java.util.List;
import java.util.Map;

import net.troja.eve.crest.industry.facilities.IndustryFacility;
import net.troja.eve.crest.industry.facilities.IndustryFacilityProcessor;
import net.troja.eve.crest.industry.systems.IndustrySystem;
import net.troja.eve.crest.industry.systems.IndustrySystemProcessor;
import net.troja.eve.crest.itemtypes.ItemType;
import net.troja.eve.crest.itemtypes.ItemTypeProcessor;
import net.troja.eve.crest.market.prices.MarketPrice;
import net.troja.eve.crest.market.prices.MarketPriceProcessor;

public class CrestHandler {
    private final CrestDataProcessor processor = new CrestDataProcessor();

    private static final CrestHandler instance = new CrestHandler();

    private final MarketPriceProcessor marketPriceProcessor = new MarketPriceProcessor();
    private final IndustrySystemProcessor industrySystemProcessor = new IndustrySystemProcessor();
    private final IndustryFacilityProcessor industryFacilityProcessor = new IndustryFacilityProcessor();

    private final Map<Integer, String> itemTypes = new HashMap<>();
    private final Map<Integer, MarketPrice> marketPrices = new HashMap<>();
    private List<IndustryFacility> industryFacilities;
    private final Map<String, IndustrySystem> industrySystems = new HashMap<>();

    private CrestHandler() {
        // Static data
        final CrestContainer<ItemType> itemTypeContainer = processor.downloadAndProcessData(new ItemTypeProcessor());
        for (final ItemType itemType : itemTypeContainer.getEntries()) {
            itemTypes.put(itemType.getId(), itemType.getName());
        }
        // Temporary data
        updateData();
    }

    public static CrestHandler getInstance() {
        return instance;
    }

    private void updateData() {
        final CrestContainer<MarketPrice> marketPriceContainer = processor.downloadAndProcessData(marketPriceProcessor);
        marketPrices.clear();
        for (final MarketPrice price : marketPriceContainer.getEntries()) {
            marketPrices.put(price.getTypeId(), price);
        }
        final CrestContainer<IndustryFacility> industryFacilityContainer = processor.downloadAndProcessData(industryFacilityProcessor);
        industryFacilities = industryFacilityContainer.getEntries();
        final CrestContainer<IndustrySystem> industrySystemContainer = processor.downloadAndProcessData(industrySystemProcessor);
        for (final IndustrySystem system : industrySystemContainer.getEntries()) {
            industrySystems.put(system.getSolarSystemName(), system);
        }
    }

    public String getItemName(final int id) {
        return itemTypes.get(id);
    }

    public MarketPrice getMarketPrice(final int id) {
        return marketPrices.get(id);
    }

    public List<IndustryFacility> getIndustryFacilities() {
        return industryFacilities;
    }

    public IndustrySystem getIndustrySystem(final String solarSystemName) {
        return industrySystems.get(solarSystemName);
    }
}

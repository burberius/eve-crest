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

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import net.troja.eve.crest.beans.IndustryFacility;
import net.troja.eve.crest.beans.IndustrySystem;
import net.troja.eve.crest.beans.ItemType;
import net.troja.eve.crest.beans.MarketPrice;
import net.troja.eve.crest.processors.IndustryFacilityProcessor;
import net.troja.eve.crest.processors.IndustrySystemProcessor;
import net.troja.eve.crest.processors.ItemTypeProcessor;
import net.troja.eve.crest.processors.MarketPriceProcessor;
import net.troja.eve.crest.utils.ProcessorConfiguration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Handles the complete crest communication, including caching of the data.
 */
public class CrestHandler extends CrestDataHandler {
    private static final Logger LOGGER = LogManager.getLogger(CrestHandler.class);
    private static final int MINUTES_30 = 30;

    private final Map<Integer, String> itemTypes = new ConcurrentHashMap<>();
    private final Map<Integer, MarketPrice> marketPrices = new ConcurrentHashMap<>();
    private List<IndustryFacility> industryFacilities;
    private final Map<String, IndustrySystem> industrySystems = new ConcurrentHashMap<>();

    private ScheduledExecutorService scheduleService;

    public CrestHandler() {
        super();
        addProcessorConfiguration(DataType.ITEM_TYPE, new ProcessorConfiguration<ItemType>(new ItemTypeProcessor(), getItemTypeConsumer()));
        addProcessorConfiguration(DataType.MARKET_PRICE,
                new ProcessorConfiguration<MarketPrice>(new MarketPriceProcessor(), getMarketPriceConsumer()));
        addProcessorConfiguration(DataType.INDUSTRY_SYSTEM, new ProcessorConfiguration<IndustrySystem>(new IndustrySystemProcessor(),
                getIndustrySystemConsumer()));
        addProcessorConfiguration(DataType.INDUSTRY_FACILITY, new ProcessorConfiguration<IndustryFacility>(new IndustryFacilityProcessor(),
                getIndustryFacilityConsumer()));
    }

    /**
     * Start background timer thread and fetch the data for the first time.
     */
    public void init() {
        if ((scheduleService == null) || scheduleService.isShutdown()) {
            scheduleService = Executors.newScheduledThreadPool(1);
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Scheduling data updates");
        }
        scheduleService.scheduleAtFixedRate(() -> updateData(), MINUTES_30, MINUTES_30, TimeUnit.MINUTES);
        updateData();
    }

    /**
     * Shutdown background execution.
     */
    public void shutdown() {
        if (scheduleService != null) {
            scheduleService.shutdownNow();
        }
    }

    private Consumer<List<ItemType>> getItemTypeConsumer() {
        return t -> {
            for (final ItemType itemType : t) {
                itemTypes.put(itemType.getTypeId(), itemType.getName());
            }
        };
    }

    private Consumer<List<MarketPrice>> getMarketPriceConsumer() {
        return t -> {
            marketPrices.clear();
            for (final MarketPrice price : t) {
                marketPrices.put(price.getTypeId(), price);
            }
        };
    }

    private Consumer<List<IndustrySystem>> getIndustrySystemConsumer() {
        return t -> {
            for (final IndustrySystem system : t) {
                industrySystems.put(system.getSolarSystemName(), system);
            }
        };
    }

    private Consumer<List<IndustryFacility>> getIndustryFacilityConsumer() {
        return t -> industryFacilities = t;
    }

    public String getItemName(final int itemTypeId) {
        return itemTypes.get(itemTypeId);
    }

    public MarketPrice getMarketPrice(final int itemTypeId) {
        return marketPrices.get(itemTypeId);
    }

    public List<IndustryFacility> getIndustryFacilities() {
        return industryFacilities;
    }

    public IndustrySystem getIndustrySystem(final String solarSystemName) {
        return industrySystems.get(solarSystemName);
    }
}

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

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import net.troja.eve.crest.beans.IndustryFacility;
import net.troja.eve.crest.beans.IndustrySystem;
import net.troja.eve.crest.beans.ItemType;
import net.troja.eve.crest.beans.MarketPrice;
import net.troja.eve.crest.beans.Status;
import net.troja.eve.crest.processors.CrestApiProcessor;
import net.troja.eve.crest.processors.IndustryFacilityProcessor;
import net.troja.eve.crest.processors.IndustrySystemProcessor;
import net.troja.eve.crest.processors.ItemTypeProcessor;
import net.troja.eve.crest.processors.MarketPriceProcessor;
import net.troja.eve.crest.processors.StatusProcessor;
import net.troja.eve.crest.utils.ProcessorConfiguration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Handles the complete crest communication, including caching of the data.
 */
/**
 * @author didge
 *
 */
public final class CrestHandler {
    private static final Logger LOGGER = LogManager.getLogger(CrestHandler.class);
    private static final int MINUTES_30 = 30;

    private CrestDataProcessor processor = new CrestDataProcessor();
    private final Map<DataType, ProcessorConfiguration<?>> dataProcessors = new EnumMap<>(DataType.class);
    private final Map<DataType, Long> lastUpdates = new EnumMap<>(DataType.class);
    private final StatusProcessor statusProcessor = new StatusProcessor();

    private final Map<Integer, String> itemTypes = new ConcurrentHashMap<>();
    private final Map<Integer, MarketPrice> marketPrices = new ConcurrentHashMap<>();
    private List<IndustryFacility> industryFacilities;
    private final Map<String, IndustrySystem> industrySystems = new ConcurrentHashMap<>();

    private ScheduledExecutorService scheduleService;

    public enum DataType {
        ITEM_TYPE, MARKET_PRICE, INDUSTRY_SYSTEM, INDUSTRY_FACILITY
    }

    public CrestHandler() {
        dataProcessors.put(DataType.ITEM_TYPE, new ProcessorConfiguration<ItemType>(new ItemTypeProcessor(), getItemTypeConsumer()));
        dataProcessors.put(DataType.MARKET_PRICE, new ProcessorConfiguration<MarketPrice>(new MarketPriceProcessor(), getMarketPriceConsumer()));
        dataProcessors.put(DataType.INDUSTRY_SYSTEM, new ProcessorConfiguration<IndustrySystem>(new IndustrySystemProcessor(),
                getIndustrySystemConsumer()));
        dataProcessors.put(DataType.INDUSTRY_FACILITY, new ProcessorConfiguration<IndustryFacility>(new IndustryFacilityProcessor(),
                getIndustryFacilityConsumer()));
    }

    /**
     * Enable fetching of the data in the background for the given types.
     *
     * @param types
     *            DataType(s) to enable
     */
    public void enableDataPrefetching(final DataType... types) {
        for (final DataType type : types) {
            dataProcessors.get(type).setEnabled(true);
        }
    }

    /**
     * Enable fetching of the data in the background for the given types.
     *
     * @param types
     *            DataType(s) to enable
     */
    public void disableDataPrefetching(final DataType... types) {
        for (final DataType type : types) {
            dataProcessors.get(type).setEnabled(false);
        }
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

    /**
     * Update the cached data manually. Use this function of you don't want it fetched regularly! Otherwise use {@link #init() init()}
     */
    public void updateData() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Updating data");
        }
        for (final Entry<DataType, ProcessorConfiguration<?>> entry : dataProcessors.entrySet()) {
            final ProcessorConfiguration<?> procConfig = entry.getValue();
            Long lastUpdate = lastUpdates.get(entry.getKey());
            if (lastUpdate == null) {
                lastUpdate = 0L;
            }
            final int refreshInterval = procConfig.getProcessor().getRefreshInterval();
            if (procConfig.isEnabled() && (lastUpdate < (System.currentTimeMillis() - refreshInterval))) {
                lastUpdates.put(entry.getKey(), updateData(procConfig));
            }
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Finished updating data");
        }
    }

    private <T> long updateData(final ProcessorConfiguration<T> config) {
        final CrestApiProcessor<T> typeProcessor = config.getProcessor();
        final CrestContainer<T> result = processor.downloadAndProcessContainerData(typeProcessor);
        config.getConsumer().accept(result.getEntries());
        return result.getTimestamp();
    }

    private Consumer<List<ItemType>> getItemTypeConsumer() {
        return t -> {
            for (final ItemType itemType : t) {
                itemTypes.put(itemType.getId(), itemType.getName());
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

    public void setProcessor(final CrestDataProcessor processor) {
        this.processor = processor;
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

    public Status getServerStatus() {
        return processor.downloadAndProcessData(statusProcessor);
    }
}

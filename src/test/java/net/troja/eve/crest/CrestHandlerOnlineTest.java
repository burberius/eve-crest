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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import net.troja.eve.crest.CrestDataHandler.DataType;
import net.troja.eve.crest.beans.IndustryFacility;
import net.troja.eve.crest.beans.IndustrySystem;
import net.troja.eve.crest.beans.MarketPrice;
import net.troja.eve.crest.beans.Status;
import net.troja.eve.crest.beans.Status.State;

import org.junit.Test;

public class CrestHandlerOnlineTest {
    private static final String JITA = "Jita";
    private static final String TRITANIUM = "Tritanium";
    private static final String TRANQUILITY = "TRANQUILITY";

    private final CrestHandler objectToTest = new CrestHandler();

    @Test
    public void testDownloadOfItemTypes() {
        objectToTest.enableDataPrefetching(DataType.ITEM_TYPE);
        objectToTest.updateData();
        assertThat(objectToTest.getItemName(34), equalTo(TRITANIUM));
    }

    @Test
    public void testDownloadOfMarketPrices() {
        objectToTest.enableDataPrefetching(DataType.MARKET_PRICE);
        objectToTest.updateData();
        final MarketPrice marketPrice = objectToTest.getMarketPrice(34);
        assertThat(marketPrice, notNullValue());
        assertThat(marketPrice.getAdjustedPrice(), greaterThan(0d));
        assertThat(marketPrice.getAveragePrice(), greaterThan(0d));
    }

    @Test
    public void testDownloadOfIndustryFacilities() {
        objectToTest.enableDataPrefetching(DataType.INDUSTRY_FACILITY);
        objectToTest.updateData();
        final List<IndustryFacility> industryFacilities = objectToTest.getIndustryFacilities();
        assertThat(industryFacilities, notNullValue());
        assertThat(industryFacilities.size(), greaterThan(1));
    }

    @Test
    public void testDownloadOfIndustrySystems() {
        objectToTest.enableDataPrefetching(DataType.INDUSTRY_SYSTEM);
        objectToTest.updateData();
        final IndustrySystem industrySystem = objectToTest.getIndustrySystem(JITA);
        assertThat(industrySystem, notNullValue());
        assertThat(industrySystem.getSolarSystemName(), equalTo(JITA));
    }

    @Test
    public void testServerStatus() {
        final Status serverStatus = objectToTest.getServerStatus();
        assertThat(serverStatus.getServerName(), equalTo(TRANQUILITY));
        assertThat(serverStatus.getUserCountsEve(), greaterThan(1));
        assertThat(serverStatus.getServiceStatusEve(), equalTo(State.ONLINE));
    }
}

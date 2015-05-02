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

import net.troja.eve.crest.CrestHandler.DataType;
import net.troja.eve.crest.beans.IndustryFacility;
import net.troja.eve.crest.beans.IndustrySystem;
import net.troja.eve.crest.beans.MarketPrice;

import org.junit.Test;

public class CrestHandlerOnlineTest {
    private static final String JITA = "Jita";
    private static final String TRITANIUM = "Tritanium";

    @Test
    public void testDownloadOfData() {
        final CrestHandler handler = CrestHandler.getInstance();
        handler.enableDataPrefetching(DataType.ITEM_TYPE, DataType.INDUSTRY_FACILITY, DataType.INDUSTRY_SYSTEM, DataType.MARKET_PRICE);
        handler.init();

        assertThat(handler.getItemName(34), equalTo(TRITANIUM));

        final MarketPrice marketPrice = handler.getMarketPrice(34);
        assertThat(marketPrice, notNullValue());
        assertThat(marketPrice.getAdjustedPrice(), greaterThan(0d));
        assertThat(marketPrice.getAveragePrice(), greaterThan(0d));

        final List<IndustryFacility> industryFacilities = handler.getIndustryFacilities();
        assertThat(industryFacilities, notNullValue());
        assertThat(industryFacilities.size(), greaterThan(1));

        final IndustrySystem industrySystem = handler.getIndustrySystem(JITA);
        assertThat(industrySystem, notNullValue());
        assertThat(industrySystem.getSolarSystemName(), equalTo(JITA));

        handler.shutdown();
    }
}

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class MarketPricesParserOnlineTest {
    @Test
    public void testGetData() {
        final MarketPricesParser parser = new MarketPricesParser();
        final MarketPrices data = parser.getData();
        assertTrue(data.getTotalCount() > 1000);
        assertEquals(data.getTotalCount(), data.getItems().size());

        try {
            parser.writeRawData(MarketPricesParserTest.LIVE_DATA);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}

package net.troja.eve.crest.industry.systems;

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

import java.io.IOException;

import org.junit.Test;

public class IndustrySystemsParseOnlineTest {
    @Test
    public void testGetData() {
        final IndustrySystemsParser parser = new IndustrySystemsParser();
        final IndustrySystems data = parser.getData();
        assertEquals(5431, data.getTotalCount());
        assertEquals(data.getTotalCount(), data.getItems().size());

        try {
            parser.writeRawData(IndustrySystemsParseTest.LIVE_DATA);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}

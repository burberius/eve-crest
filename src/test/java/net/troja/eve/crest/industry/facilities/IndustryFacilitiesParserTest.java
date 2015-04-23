package net.troja.eve.crest.industry.facilities;

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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndustryFacilitiesParserTest {
    public static final String LIVE_DATA = "src/test/resources/IndustryFacilities.json";

    @Test
    public void testGetData() {
        final IndustryFacilitiesParser parser = new IndustryFacilitiesParser();
        parser.setDummyDataFile(LIVE_DATA);
        final IndustryFacilities data = parser.getData();
        assertEquals(6207, data.getTotalCount());
        assertEquals(data.getTotalCount(), data.getItems().size());
        final IndustryFacility facility = data.getItems().get(0);
        assertThat(facility.getName(), notNullValue());
        assertThat(facility.getSolarSystem(), notNullValue());
        assertThat(facility.getSolarSystem().getId(), greaterThan(0l));
        assertThat(facility.getFacilityID(), greaterThan(0l));
    }
}

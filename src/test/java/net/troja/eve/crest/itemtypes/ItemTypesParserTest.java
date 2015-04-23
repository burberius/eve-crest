package net.troja.eve.crest.itemtypes;

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

import org.junit.Test;

public class ItemTypesParserTest {
    public static final String LIVE_DATA = "src/test/resources/ItemTypes.json";

    @Test
    public void testGetData() {
        final ItemTypesParser parser = new ItemTypesParser();
        parser.setDummyDataFile(LIVE_DATA);
        final ItemTypes data = parser.getData();
        assertEquals(22406, data.getTotalCount());
        assertEquals(23, data.getPageCount());
        final ItemType item = data.getItems().get(1);
        assertEquals(2, item.getId());
        assertEquals("Corporation", item.getName());
    }
}

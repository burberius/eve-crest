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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import net.troja.eve.crest.CrestApiProcessor;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ItemTypeProcessorTest {
    private static final String REGION = "Region";

    @Test
    public void testParsing() {
        final ItemTypeProcessor processor = new ItemTypeProcessor();

        final ObjectMapper mapper = new ObjectMapper();
        final ObjectNode object = mapper.createObjectNode();
        object.put(CrestApiProcessor.PATH_HREF, "http://public-crest.eveonline.com/types/3/");
        object.put(CrestApiProcessor.PATH_NAME, REGION);
        final ItemType type = processor.parseEntry(object);

        assertThat(type.getId(), is(equalTo(3)));
        assertThat(type.getName(), is(equalTo(REGION)));
    }
}

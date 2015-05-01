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

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CrestAccessorOnlineTest {
    private final CrestAccessor accessor = new CrestAccessor();

    @Before
    public void setUp() {
        accessor.setUserAgent("Test");
    }

    @Test
    public void testDownloadOfApiData() throws IOException {
        final String data = accessor.getData("");
        assertThat(data, containsString("crestEndpoint"));
        assertThat(data, containsString("TRANQUILITY"));
    }

    @Test
    public void testWrongAddress() throws IOException {
        final String data = accessor.getData("/wrong");
        assertThat(data, nullValue());
    }
}

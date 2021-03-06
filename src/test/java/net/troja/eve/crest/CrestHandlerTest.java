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

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import net.troja.eve.crest.CrestDataHandler.DataType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CrestHandlerTest {
    private static final int REFRESH_INTERVAL = 1000 * 60 * 60 * 24;

    private CrestHandler handler;

    @Mock
    private CrestDataProcessor processor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        handler = new CrestHandler();
        handler.setProcessor(processor);
    }

    @Test
    public void testTimeoutsHit() {
        final CrestContainer<Object> crestContainer = new CrestContainer<Object>();
        crestContainer.setTimestamp(System.currentTimeMillis() - 100);
        when(processor.downloadAndProcessContainerData(any())).thenReturn(crestContainer);

        handler.enableDataPrefetching(DataType.ITEM_TYPE);
        handler.updateData();
        handler.updateData();

        verify(processor, times(1)).downloadAndProcessContainerData(any());
    }

    @Test
    public void testTimeoutsMiss() {
        final CrestContainer<Object> crestContainer = new CrestContainer<Object>();
        crestContainer.setTimestamp(System.currentTimeMillis() - REFRESH_INTERVAL - 100);
        when(processor.downloadAndProcessContainerData(any())).thenReturn(crestContainer);

        handler.enableDataPrefetching(DataType.ITEM_TYPE);
        handler.updateData();
        handler.updateData();

        verify(processor, times(2)).downloadAndProcessContainerData(any());
    }

    @Test
    public void testNothingEnabled() {
        handler.disableDataPrefetching(DataType.ITEM_TYPE, DataType.INDUSTRY_FACILITY, DataType.INDUSTRY_SYSTEM, DataType.MARKET_PRICE);
        handler.updateData();

        verify(processor, never()).downloadAndProcessContainerData(any());
    }

    @Test
    public void testInit() {
        final CrestContainer<Object> crestContainer = new CrestContainer<Object>();
        when(processor.downloadAndProcessContainerData(any())).thenReturn(crestContainer);

        handler.enableDataPrefetching(DataType.ITEM_TYPE);
        handler.init();

        verify(processor, times(1)).downloadAndProcessContainerData(any());

        handler.shutdown();
    }

    @Test
    public void testSchedulerInitizialisation() {
        final CrestContainer<Object> crestContainer = new CrestContainer<Object>();
        when(processor.downloadAndProcessContainerData(any())).thenReturn(crestContainer);

        handler.enableDataPrefetching(DataType.ITEM_TYPE);
        handler.shutdown();
        handler.init();
        handler.init();
        handler.shutdown();
        handler.init();

        verify(processor, times(2)).downloadAndProcessContainerData(any());
        handler.shutdown();
    }
}

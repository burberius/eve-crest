package net.troja.eve.crest.utils;

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

import java.util.List;
import java.util.function.Consumer;

import net.troja.eve.crest.processors.CrestApiProcessor;

public class ProcessorConfiguration<T> {
    private CrestApiProcessor<T> processor;
    private boolean enabled;
    private Consumer<List<T>> consumer;

    public ProcessorConfiguration(final CrestApiProcessor<T> processor, final Consumer<List<T>> consumer) {
        super();
        this.processor = processor;
        this.consumer = consumer;
    }

    public CrestApiProcessor<T> getProcessor() {
        return processor;
    }

    public void setProcessor(final CrestApiProcessor<T> processor) {
        this.processor = processor;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public Consumer<List<T>> getConsumer() {
        return consumer;
    }

    public void setConsumer(final Consumer<List<T>> consumer) {
        this.consumer = consumer;
    }

}

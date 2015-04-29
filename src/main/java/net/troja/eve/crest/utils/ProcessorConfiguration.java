package net.troja.eve.crest.utils;

import java.util.List;
import java.util.function.Consumer;

import net.troja.eve.crest.processors.CrestApiProcessor;

public class ProcessorConfiguration<T> {
    private CrestApiProcessor<T> processor;
    private long updateTime;
    private boolean enabled = false;
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

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(final long updateTime) {
        this.updateTime = updateTime;
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

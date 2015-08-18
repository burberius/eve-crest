package net.troja.eve.crest;

import static org.mockito.Mockito.when;
import net.troja.eve.crest.CrestDataHandler.DataType;
import net.troja.eve.crest.beans.ItemType;
import net.troja.eve.crest.processors.ItemTypeProcessor;
import net.troja.eve.crest.utils.ProcessorConfiguration;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CrestDataHandlerTest {
    private final ItemTypeProcessor proc = new ItemTypeProcessor();
    private final CrestDataHandler objectToTest = new CrestDataHandler() {
    };

    @Mock
    private CrestDataProcessor processor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        objectToTest.setProcessor(processor);
    }

    @Test
    public void testDownloadError() {
        when(processor.downloadAndProcessData(proc)).thenReturn(null);

        objectToTest.addProcessorConfiguration(DataType.ITEM_TYPE, new ProcessorConfiguration<ItemType>(new ItemTypeProcessor(), null));
        objectToTest.enableDataPrefetching(DataType.ITEM_TYPE);

        objectToTest.updateData();
    }
}

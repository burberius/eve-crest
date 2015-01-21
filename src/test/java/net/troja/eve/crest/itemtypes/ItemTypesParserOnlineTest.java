package net.troja.eve.crest.itemtypes;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class ItemTypesParserOnlineTest {
    @Test
    public void testGetDataOnlineAndStoreThem() {
	final ItemTypesParser parser = new ItemTypesParser();
	final ItemTypes data = parser.getData();
	assertEquals(22406, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());

	try {
	    parser.writeRawData(ItemTypesParserTest.LIVE_DATA);
	} catch (final IOException e) {
	    e.printStackTrace();
	}
    }
}

package net.troja.eve.crest.itemtypes;

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

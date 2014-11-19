package net.troja.eve.crest.industry.facilities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndustryFacilitiesParserTest {
    public static final String LIVE_DATA = "src/test/resources/IndustryFacilities.json";

    @Test
    public void testGetData() {
	final IndustryFacilitiesParser parser = new IndustryFacilitiesParser();
	parser.setDummyDataFile(LIVE_DATA);
	final IndustryFacilities data = parser.getData();
	assertEquals(142, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());
    }
}

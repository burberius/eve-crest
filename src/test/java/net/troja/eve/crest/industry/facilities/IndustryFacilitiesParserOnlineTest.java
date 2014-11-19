package net.troja.eve.crest.industry.facilities;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class IndustryFacilitiesParserOnlineTest {
    @Test
    public void testGetDataOnlineAndStoreThem() {
	final IndustryFacilitiesParser parser = new IndustryFacilitiesParser();
	final IndustryFacilities data = parser.getData();
	assertEquals(6187, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());

	try {
	    parser.writeRawData(IndustryFacilitiesParserTest.LIVE_DATA);
	} catch (final IOException e) {
	    e.printStackTrace();
	}
    }
}

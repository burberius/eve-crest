package net.troja.eve.crest.industry.specialities;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class IndustrySpecialitiesParserOnlineTest {
    @Test
    public void testGetDataOnlineAndStoreThem() {
	final IndustrySpecialitiesParser parser = new IndustrySpecialitiesParser();
	final IndustrySpecialities data = parser.getData();
	assertEquals(142, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());

	try {
	    parser.writeRawData(IndustrySpecialitiesParserTest.LIVE_DATA);
	} catch (final IOException e) {
	    e.printStackTrace();
	}
    }
}

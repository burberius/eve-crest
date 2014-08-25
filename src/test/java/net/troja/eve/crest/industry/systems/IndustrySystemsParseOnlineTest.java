package net.troja.eve.crest.industry.systems;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class IndustrySystemsParseOnlineTest {
    @Test
    public void testGetData() {
	final IndustrySystemsParser parser = new IndustrySystemsParser();
	final IndustrySystems data = parser.getData();
	assertEquals(5431, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());

	try {
	    parser.writeRawData(IndustrySystemsParseTest.LIVE_DATA);
	} catch (final IOException e) {
	    e.printStackTrace();
	}
    }
}

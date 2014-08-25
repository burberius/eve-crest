package net.troja.eve.crest.industry.teams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class IndustryTeamsParserOnlineTest {
    @Test
    public void testGetData() {
	final IndustryTeamsParser parser = new IndustryTeamsParser();
	final IndustryTeams data = parser.getData();
	assertTrue(data.getTotalCount() > 0);
	assertEquals(data.getTotalCount(), data.getItems().size());

	try {
	    parser.writeRawData(IndustryTeamsParserTest.LIVE_DATA);
	} catch (final IOException e) {
	    e.printStackTrace();
	}
    }
}

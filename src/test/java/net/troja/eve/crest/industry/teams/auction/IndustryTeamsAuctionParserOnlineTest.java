package net.troja.eve.crest.industry.teams.auction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class IndustryTeamsAuctionParserOnlineTest {
    @Test
    public void testGetData() {
	final IndustryTeamsAuctionParser parser = new IndustryTeamsAuctionParser();
	final IndustryTeamsAuctions data = parser.getData();
	assertTrue(data.getTotalCount() > 0);
	assertEquals(data.getTotalCount(), data.getItems().size());

	try {
	    parser.writeRawData(IndustryTeamsAuctionParserTest.LIVE_DATA);
	} catch (final IOException e) {
	    e.printStackTrace();
	}
    }
}

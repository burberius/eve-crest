package net.troja.eve.crest.industry.teams.auction;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IndustryTeamsAuctionParserTest {
    public static final String LIVE_DATA = "src/test/resources/IndustryTeamsAuction.json";

    @Test
    public void testGetData() {
	final IndustryTeamsAuctionParser parser = new IndustryTeamsAuctionParser();
	parser.setDummyDataFile(LIVE_DATA);
	final IndustryTeamsAuctions data = parser.getData();
	assertEquals(1004, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());
    }
}

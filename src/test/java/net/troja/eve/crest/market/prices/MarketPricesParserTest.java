package net.troja.eve.crest.market.prices;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MarketPricesParserTest {
    public static final String LIVE_DATA = "src/test/resources/MarketPrices.json";

    @Test
    public void testGetData() {
	final MarketPricesParser parser = new MarketPricesParser();
	parser.setDummyDataFile(LIVE_DATA);
	final MarketPrices data = parser.getData();
	assertEquals(9454, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());
    }
}

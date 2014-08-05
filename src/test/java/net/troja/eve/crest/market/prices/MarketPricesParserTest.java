package net.troja.eve.crest.market.prices;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MarketPricesParserTest {
    @Test
    public void testGetData() {
	final MarketPricesParser parser = new MarketPricesParser();
	final MarketPrices data = parser.getData();
	assertEquals(6565, data.getTotalCount());
	assertEquals(data.getTotalCount(), data.getItems().size());
    }
}

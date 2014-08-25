package net.troja.eve.crest.market.prices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class MarketPricesParserOnlineTest {
    @Test
    public void testGetData() {
	final MarketPricesParser parser = new MarketPricesParser();
	final MarketPrices data = parser.getData();
	assertTrue(data.getTotalCount() > 1000);
	assertEquals(data.getTotalCount(), data.getItems().size());

	try {
	    parser.writeRawData(MarketPricesParserTest.LIVE_DATA);
	} catch (final IOException e) {
	    e.printStackTrace();
	}
    }
}

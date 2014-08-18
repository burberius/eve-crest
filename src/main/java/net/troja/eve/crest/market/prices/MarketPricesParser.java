package net.troja.eve.crest.market.prices;

import net.troja.eve.crest.PublicParser;

public class MarketPricesParser extends PublicParser<MarketPrices> {
    public MarketPricesParser() {
	cacheDuration = 24;
    }

    @Override
    protected String getPath() {
	return "/market/prices/";
    }
}

package net.troja.eve.crest.market.prices;

import net.troja.eve.crest.PublicContainerParser;

public class MarketPricesParser extends PublicContainerParser<MarketPrices, MarketPrice> {
    public MarketPricesParser() {
	cacheDuration = 24;
    }

    @Override
    protected String getPath() {
	return "/market/prices/";
    }
}

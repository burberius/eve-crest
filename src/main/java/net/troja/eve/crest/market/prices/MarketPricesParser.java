package net.troja.eve.crest.market.prices;

import java.util.HashMap;
import java.util.Map;

import net.troja.eve.crest.PublicContainerParser;

public class MarketPricesParser extends PublicContainerParser<MarketPrices, MarketPrice> {
    public MarketPricesParser() {
	cacheDuration = 24;
    }

    @Override
    protected String getPath() {
	return "/market/prices/";
    }
    
    public Map<Integer, Double> getDataAsMap() {
	final MarketPrices data = getData();
	final Map<Integer, Double> map = new HashMap<>();
	if (data == null)
	    return map;
	for(final MarketPrice price : data.getItems()) {
	    map.put(price.getType().getId(), price.getAdjustedPrice());
	}
	return map;
    }
}

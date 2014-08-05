package net.troja.eve.crest.market.prices;

import java.io.IOException;

import net.troja.eve.crest.PublicParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class MarketPricesParser extends PublicParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarketPricesParser.class);
    private static final String PATH = "/market/prices/";

    private MarketPrices cachedPrices = null;

    public MarketPricesParser() {
	cacheDuration = 24;
    }

    public MarketPrices getData() {
	if (isOutdated()) {
	    LOGGER.info("Updating data");
	    String data = null;
	    try {
		data = getData(PATH);
		cachedPrices = mapper.readValue(data, MarketPrices.class);
		updateCachedAt();
	    } catch (final IOException e) {
		LOGGER.error("Could not download market prices", e);
		if (data != null) {
		    try {
			System.out.println(getPrettyString(data));
		    } catch (final JsonParseException e1) {
		    } catch (final JsonMappingException e1) {
		    } catch (final IOException e1) {
		    }
		}
		return null;
	    }
	    LOGGER.info("Done");
	}
	return cachedPrices;
    }
}

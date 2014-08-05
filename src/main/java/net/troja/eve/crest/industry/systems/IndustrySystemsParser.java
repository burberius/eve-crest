package net.troja.eve.crest.industry.systems;

import java.io.IOException;

import net.troja.eve.crest.PublicParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class IndustrySystemsParser extends PublicParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndustrySystemsParser.class);
    private static final String PATH = "/industry/systems/";

    private IndustrySystems cachedSystems;

    public IndustrySystems getData() {
	if (isOutdated()) {
	    LOGGER.info("Updating data");
	    String data = null;
	    try {
		data = getData(PATH);
		cachedSystems = mapper.readValue(data, IndustrySystems.class);
		updateCachedAt();
	    } catch (final IOException e) {
		LOGGER.error("Could not download market prices", e);
		if (data != null) {
		    try {
			System.out.println(getPrettyString(data).substring(0, 5000));
		    } catch (final JsonParseException e1) {
		    } catch (final JsonMappingException e1) {
		    } catch (final IOException e1) {
		    }
		}
		return null;
	    }
	    LOGGER.info("Done");
	}
	return cachedSystems;
    }
}

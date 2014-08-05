package net.troja.eve.crest;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class PublicParser {
    private final static String API_URL = "http://public-crest.eveonline.com";

    protected int cacheDuration = 1;
    protected long cachedAt = 0;
    protected ObjectMapper mapper;

    public PublicParser() {
	super();
	mapper = new ObjectMapper();
	mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    protected String getData(final String path) throws IOException {
	final URL url = new URL(API_URL + path);
	final StringWriter writer = new StringWriter();
	final String encoding = "UTF-8";
	IOUtils.copy(url.openConnection().getInputStream(), writer, encoding);
	return writer.toString();
    }

    protected String getPrettyString(final String data) throws JsonParseException, JsonMappingException, IOException {
	final Object json = mapper.readValue(data, Object.class);
	return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
    }

    protected void updateCachedAt() {
	cachedAt = System.currentTimeMillis();
    }

    protected boolean isOutdated() {
	if ((System.currentTimeMillis() - cachedAt) > (cacheDuration * 60 * 60 * 1000))
	    return true;
	return false;
    }
}

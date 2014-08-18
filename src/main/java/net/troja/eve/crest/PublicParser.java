package net.troja.eve.crest;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;
import java.net.URL;

import net.troja.eve.crest.industry.teams.IndustryTeamsParser;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class PublicParser<T extends ContainerType> {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndustryTeamsParser.class);
    private final static String API_URL = "http://public-crest.eveonline.com";

    protected int cacheDuration = 1;
    protected long cachedAt = 0;
    protected ObjectMapper mapper;
    private T cachedData = null;

    public PublicParser() {
	super();
	mapper = new ObjectMapper();
	mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @SuppressWarnings("unchecked")
    public T getData() {
	if (isOutdated()) {
	    LOGGER.info("Updating data");
	    String data = null;
	    try {
		data = getData(getPath());
		cachedData = mapper.readValue(data, (Class<T>) ((ParameterizedType) getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0]);
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
	    LOGGER.info("Done (" + cachedData.getTotalCount() + " entries)");
	}
	return cachedData;
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
	return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json).substring(0, 5000);
    }

    protected void updateCachedAt() {
	cachedAt = System.currentTimeMillis();
    }

    protected boolean isOutdated() {
	if ((System.currentTimeMillis() - cachedAt) > (cacheDuration * 60 * 60 * 1000))
	    return true;
	return false;
    }

    protected abstract String getPath();
}

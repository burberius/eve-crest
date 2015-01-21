package net.troja.eve.crest;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class PublicContainerParser<T extends ContainerType<S>, S> extends PublicParser<S> {
    private T cachedData = null;
    private String dataString = null;

    public PublicContainerParser() {
	super();
	mapper = new ObjectMapper();
	mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	userAgent = USER_AGENT + getClass().getPackage().getImplementationVersion();
    }

    public T getData() {
	final String name = this.getClass().getSimpleName().replace("Parser", "");
	if (isOutdated()) {
	    LOGGER.info("Updating " + name + " data");
	    try {
		cachedData = getDataPage(null);
		if (isPaged()) {
		    for (int page = 2; page <= cachedData.getPageCount(); page++) {
			final T dataPage = getDataPage(page);
			cachedData.getItems().addAll(dataPage.getItems());
		    }
		}
	    } catch (final IOException e) {
		LOGGER.error("Could not download " + name, e);
		if (dataString != null) {
		    try {
			System.out.println(getPrettyString(dataString));
		    } catch (final JsonParseException e1) {
		    } catch (final JsonMappingException e1) {
		    } catch (final IOException e1) {
		    }
		}
	    }
	    LOGGER.info("Done (" + cachedData.getTotalCount() + " " + name + " entries)");
	}
	return cachedData;
    }

    protected boolean isPaged() {
	return false;
    }

    @SuppressWarnings("unchecked")
    private T getDataPage(final Integer page) throws IOException {
	final String pathExtension = page != null ? "?page=" + page : "";
	dataString = getData(getPath() + pathExtension);
	return mapper.readValue(dataString,
		(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}

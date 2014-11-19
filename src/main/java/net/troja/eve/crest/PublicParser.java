package net.troja.eve.crest;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class PublicParser<T extends ContainerType<?>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PublicParser.class);
    private final static String API_URL = "http://public-crest.eveonline.com";
    private final static String USER_AGENT = "eve-crest Java library - https://github.com/burberius/eve-crest - ";

    protected int cacheDuration = 1;
    protected long cachedAt = 0;
    protected ObjectMapper mapper;
    private T cachedData = null;
    private String fileName = null;
    private String userAgent;

    public PublicParser() {
	super();
	mapper = new ObjectMapper();
	mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	userAgent = USER_AGENT + getClass().getPackage().getImplementationVersion();
    }

    @SuppressWarnings("unchecked")
    public T getData() {
	final String name = this.getClass().getSimpleName().replace("Parser", "");
	if (isOutdated()) {
	    LOGGER.info("Updating " + name + " data");
	    String data = null;
	    try {
		data = getData(getPath());
		cachedData = mapper.readValue(data,
			(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		updateCachedAt();
	    } catch (final IOException e) {
		LOGGER.error("Could not download " + name, e);
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
	    LOGGER.info("Done (" + cachedData.getTotalCount() + " " + name + " entries)");
	}
	return cachedData;
    }

    protected String getData(final String path) throws IOException {
	if (fileName == null) {
	    CloseableHttpClient httpclient = HttpClients.createDefault();
	    try {
		HttpGet request = new HttpGet(API_URL + path);
		request.setHeader("User-Agent", userAgent);
		HttpResponse response = httpclient.execute(request);
		int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    return null;
                }
	    } finally {
		httpclient.close();
	    }
	} else
	    return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void writeRawData(final String fileName) throws IOException {
	final Path target = Paths.get(fileName);
	Files.write(target, getData(getPath()).getBytes());
    }

    public void setDummyDataFile(final String fileName) {
	this.fileName = fileName;
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

    protected abstract String getPath();
}

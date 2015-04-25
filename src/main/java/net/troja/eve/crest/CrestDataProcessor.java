package net.troja.eve.crest;

/*
 * ========================================================================
 * Library for the Eve Online CREST API
 * ------------------------------------------------------------------------
 * Copyright (C) 2014 - 2015 Jens Oberender <j.obi@troja.net>
 * ------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================================
 */

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CrestDataProcessor {
    private static final Logger LOGGER = LogManager.getLogger(CrestHandler.class);

    private CrestAccessor accessor = new CrestAccessor();
    private final ObjectMapper mapper;

    public CrestDataProcessor() {
        mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public void setAccessor(final CrestAccessor accessor) {
        this.accessor = accessor;
    }

    public <T> CrestContainer<T> downloadAndProcessData(final CrestApiProcessor<T> processor) {
        final CrestContainer<T> container = new CrestContainer<T>();
        try {
            String data = accessor.getData(processor.getPath());
            String next = processData(processor, container, data);
            while (next != null) {
                data = accessor.getDataPage(next);
                next = processData(processor, container, data);
            }
        } catch (final DataProcessingException e) {
            LOGGER.error("Could not process data", e);
            return null;
        } catch (final IOException e) {
            LOGGER.error("Could not download data", e);
            return null;
        }
        return container;
    }

    private <T> String processData(final CrestApiProcessor<T> processor, final CrestContainer<T> container, final String data)
            throws DataProcessingException {
        if ((data == null) || (data.trim().length() == 0)) {
            throw new DataProcessingException("No data to parse");
        }
        String next = null;
        try {
            final JsonFactory parserFactory = new JsonFactory();
            final JsonParser jsonParser = parserFactory.createParser(data);
            jsonParser.nextToken();
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                final String fieldname = jsonParser.getCurrentName();
                jsonParser.nextToken();
                switch (fieldname) {
                    case "totalCount":
                        container.setTotalCount(jsonParser.getIntValue());
                        break;
                    case "pageCount":
                        container.setPageCount(jsonParser.getIntValue());
                        break;
                    case "items":
                        if (jsonParser.isExpectedStartArrayToken()) {
                            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                                container.addEntry(processor.parseEntry((JsonNode) mapper.readTree(jsonParser)));
                            }
                        }
                        break;
                    case "next":
                        jsonParser.nextToken();
                        if (!JsonPaths.HREF.equals(jsonParser.getCurrentName())) {
                            break;
                        }
                        jsonParser.nextToken();
                        next = jsonParser.getText();
                        jsonParser.nextToken();
                    default:
                        break;
                }
            }
        } catch (final IOException e) {
            throw new DataProcessingException("Problems while parsing json data", e);
        }
        return next;
    }
}

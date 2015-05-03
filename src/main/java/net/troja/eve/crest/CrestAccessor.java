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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrestAccessor {
    private static final Logger LOGGER = LogManager.getLogger(CrestAccessor.class);
    private static final String API_URL = "http://public-crest.eveonline.com";
    private static final String USER_AGENT = "eve-crest Java library - https://github.com/burberius/eve-crest - ";

    private String userAgent = USER_AGENT + getClass().getPackage().getImplementationVersion();

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(final String userAgent) {
        this.userAgent = userAgent;
    }

    public String getDataPage(final String address) throws IOException {
        final HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        final CloseableHttpClient httpclient = clientBuilder.build();
        final HttpGet request = new HttpGet(address);
        String result = null;
        try {
            request.setHeader("User-Agent", userAgent);
            final HttpResponse response = httpclient.execute(request);
            final StatusLine statusLine = response.getStatusLine();
            final int status = statusLine.getStatusCode();
            if ((status >= HttpStatus.SC_OK) && (status < HttpStatus.SC_MULTIPLE_CHOICES)) {
                final HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                }
            } else {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn("Got " + status + " for the query " + address);
                }
            }
        } finally {
            request.reset();
            httpclient.close();
        }
        return result;
    }

    public String getData(final String path) throws IOException {
        return getDataPage(API_URL + path);
    }
}

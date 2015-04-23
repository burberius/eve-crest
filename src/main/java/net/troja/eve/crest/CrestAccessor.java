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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrestAccessor {
    protected static final Logger LOGGER = LogManager.getLogger(CrestAccessor.class);
    protected static final String API_URL = "http://public-crest.eveonline.com";
    protected static final String USER_AGENT = "eve-crest Java library - https://github.com/burberius/eve-crest - ";

    protected String userAgent = USER_AGENT + getClass().getPackage().getImplementationVersion();

    public String getData(final String path) throws IOException {
        final CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            final HttpGet request = new HttpGet(API_URL + path);
            request.setHeader("User-Agent", userAgent);
            final HttpResponse response = httpclient.execute(request);
            final int status = response.getStatusLine().getStatusCode();
            if ((status >= 200) && (status < 300)) {
                final HttpEntity entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                return null;
            }
        } finally {
            httpclient.close();
        }
    }

    public String getDataPage(final String path, final Integer page) throws IOException {
        final String pathExtension = page != null ? "?page=" + page : "";
        return getData(path + pathExtension);
    }
}

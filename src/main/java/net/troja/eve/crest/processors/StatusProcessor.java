package net.troja.eve.crest.processors;

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

import net.troja.eve.crest.beans.Status;
import net.troja.eve.crest.beans.Status.State;
import net.troja.eve.crest.utils.JsonPaths;

import com.fasterxml.jackson.databind.JsonNode;

public class StatusProcessor implements CrestApiProcessor<Status> {
    /**
     * Refresh interval: 5 seconds.
     */
    private static final int REFRESH_INTERVAL = 1000 * 5;

    @Override
    public String getPath() {
        return "/";
    }

    @Override
    public int getRefreshInterval() {
        return REFRESH_INTERVAL;
    }

    @Override
    public Status parseEntry(final JsonNode node) {
        final Status status = new Status();
        status.setServerName(node.path(JsonPaths.SERVER_NAME).asText());
        status.setServerVersion(node.path(JsonPaths.SERVER_VERSION).asText());
        final JsonNode serviceStatus = node.path(JsonPaths.SERVICE_STATUS);
        status.setServiceStatusDust(State.parse(serviceStatus.path(JsonPaths.DUST).asText()));
        status.setServiceStatusEve(State.parse(serviceStatus.path(JsonPaths.EVE).asText()));
        status.setServiceStatusServer(State.parse(serviceStatus.path(JsonPaths.SERVER).asText()));
        final JsonNode userCount = node.path(JsonPaths.USER_COUNTS);
        status.setUserCountsDust(userCount.path(JsonPaths.DUST).asInt());
        status.setUserCountsEve(userCount.path(JsonPaths.EVE).asInt());
        return status;
    }

}

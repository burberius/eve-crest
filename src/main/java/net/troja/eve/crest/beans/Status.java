package net.troja.eve.crest.beans;

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

public class Status {
    public enum State {
        OFFLINE, ONLINE;

        public static State parse(final String text) {
            if (ONLINE.name().equalsIgnoreCase(text)) {
                return ONLINE;
            } else {
                return OFFLINE;
            }
        }
    }

    private String serverName;
    private String serverVersion;
    private State serviceStatusEve;
    private State serviceStatusDust;
    private State serviceStatusServer;
    private int userCountsEve;
    private int userCountsDust;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(final String serverName) {
        this.serverName = serverName;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(final String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public State getServiceStatusEve() {
        return serviceStatusEve;
    }

    public void setServiceStatusEve(final State serviceStatusEve) {
        this.serviceStatusEve = serviceStatusEve;
    }

    public State getServiceStatusDust() {
        return serviceStatusDust;
    }

    public void setServiceStatusDust(final State serviceStatusDust) {
        this.serviceStatusDust = serviceStatusDust;
    }

    public State getServiceStatusServer() {
        return serviceStatusServer;
    }

    public void setServiceStatusServer(final State serviceStatusServer) {
        this.serviceStatusServer = serviceStatusServer;
    }

    public int getUserCountsEve() {
        return userCountsEve;
    }

    public void setUserCountsEve(final int userCountsEve) {
        this.userCountsEve = userCountsEve;
    }

    public int getUserCountsDust() {
        return userCountsDust;
    }

    public void setUserCountsDust(final int userCountsDust) {
        this.userCountsDust = userCountsDust;
    }

    @Override
    public String toString() {
        return "Status [serverName=" + serverName + ", serverVersion=" + serverVersion + ", serviceStatusEve=" + serviceStatusEve
                + ", serviceStatusDust=" + serviceStatusDust + ", serviceStatusServer=" + serviceStatusServer + ", userCountsEve=" + userCountsEve
                + ", userCountsDust=" + userCountsDust + "]";
    }
}

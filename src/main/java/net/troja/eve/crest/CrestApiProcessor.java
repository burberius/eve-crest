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

import com.fasterxml.jackson.databind.JsonNode;

public interface CrestApiProcessor<T> {
    static String PATH_HREF = "href";
    static String PATH_NAME = "name";
    static String PATH_TYPE = "type";
    static String PATH_ID = "id";
    static String PATH_ADJUSTEDPRICE = "adjustedPrice";
    static String PATH_AVERAGEPRICE = "averagePrice";
    static String PATH_SOLARSYSTEM = "solarSystem";
    static String PATH_SYSTEMCOSTINDICES = "systemCostIndices";
    static String PATH_COSTINDEX = "costIndex";
    static String PATH_ACTIVITYID = "activityID";
    static String PATH_FACILITYID = "facilityID";
    static String PATH_REGION = "region";
    static String PATH_TAX = "tax";
    static String PATH_OWNER = "owner";

    String getPath();

    T parseEntry(JsonNode node);
}

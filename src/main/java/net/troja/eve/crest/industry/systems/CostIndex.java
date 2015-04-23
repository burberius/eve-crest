package net.troja.eve.crest.industry.systems;

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

import java.io.Serializable;

public class CostIndex implements Serializable {
    private static final long serialVersionUID = 4359370790615315807L;

    private double costIndex;
    private int activityID;
    private String activityName;

    public double getCostIndex() {
        return costIndex;
    }

    public void setCostIndex(final double costIndex) {
        this.costIndex = costIndex;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(final int activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(final String activityName) {
        this.activityName = activityName;
    }

    @Override
    public String toString() {
        return "CostIndex [costIndex=" + costIndex + ", activityID=" + activityID + ", activityName=" + activityName + "]";
    }
}

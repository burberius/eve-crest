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
import java.util.List;

import net.troja.eve.crest.GeneralType;

public class IndustrySystem implements Serializable {
    private static final long serialVersionUID = 5467636267727502281L;

    private List<CostIndex> systemCostIndices;
    private GeneralType solarSystem;

    public List<CostIndex> getSystemCostIndices() {
        return systemCostIndices;
    }

    public void setSystemCostIndices(final List<CostIndex> systemCostIndices) {
        this.systemCostIndices = systemCostIndices;
    }

    public GeneralType getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(final GeneralType solarSystem) {
        this.solarSystem = solarSystem;
    }

    @Override
    public String toString() {
        return "System [systemCostIndices=" + systemCostIndices + ", solarSystem=" + solarSystem + "]";
    }
}

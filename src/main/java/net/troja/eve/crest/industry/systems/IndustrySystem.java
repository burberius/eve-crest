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


public class IndustrySystem {
    private int solarSystemId;
    private String solarSystemName;
    private double manufacturingCostIndex;
    private double researchingTimeEfficiencyCostIndex;
    private double researchingMaterialEfficiencyCostIndex;
    private double copyingCostIndex;
    private double inventionCostIndex;

    public IndustrySystem(final int solarSystemId, final String solarSystemName) {
        this.solarSystemId = solarSystemId;
        this.solarSystemName = solarSystemName;
    }

    public int getSolarSystemId() {
        return solarSystemId;
    }

    public void setSolarSystemId(final int solarSystemId) {
        this.solarSystemId = solarSystemId;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(final String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }

    public double getManufacturingCostIndex() {
        return manufacturingCostIndex;
    }

    public void setManufacturingCostIndex(final double manufacturingCostIndex) {
        this.manufacturingCostIndex = manufacturingCostIndex;
    }

    public double getResearchingTimeEfficiencyCostIndex() {
        return researchingTimeEfficiencyCostIndex;
    }

    public void setResearchingTimeEfficiencyCostIndex(final double researchingTimeEfficiencyCostIndex) {
        this.researchingTimeEfficiencyCostIndex = researchingTimeEfficiencyCostIndex;
    }

    public double getResearchingMaterialEfficiencyCostIndex() {
        return researchingMaterialEfficiencyCostIndex;
    }

    public void setResearchingMaterialEfficiencyCostIndex(final double researchingMaterialEfficiencyCostIndex) {
        this.researchingMaterialEfficiencyCostIndex = researchingMaterialEfficiencyCostIndex;
    }

    public double getCopyingCostIndex() {
        return copyingCostIndex;
    }

    public void setCopyingCostIndex(final double copyingCostIndex) {
        this.copyingCostIndex = copyingCostIndex;
    }

    public double getInventionCostIndex() {
        return inventionCostIndex;
    }

    public void setInventionCostIndex(final double inventionCostIndex) {
        this.inventionCostIndex = inventionCostIndex;
    }

    @Override
    public String toString() {
        return "IndustrySystem [solarSystemId=" + solarSystemId + ", solarSystemName=" + solarSystemName + ", manufacturingCostIndex="
                + manufacturingCostIndex + ", researchingTimeEfficiencyCostIndex=" + researchingTimeEfficiencyCostIndex
                + ", researchingMaterialEfficiencyCostIndex=" + researchingMaterialEfficiencyCostIndex + ", copyingCostIndex=" + copyingCostIndex
                + ", inventionCostIndex=" + inventionCostIndex + "]";
    }
}

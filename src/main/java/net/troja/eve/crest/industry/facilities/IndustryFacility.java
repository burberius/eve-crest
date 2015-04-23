package net.troja.eve.crest.industry.facilities;

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

import net.troja.eve.crest.IdType;

public class IndustryFacility implements Serializable {
    private static final long serialVersionUID = -1817751027149221431L;

    private long facilityID;
    private String name;
    private double tax;
    private IdType solarSystem;
    private IdType region;
    private IdType owner;
    private IdType type;

    public long getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(final long facilityID) {
        this.facilityID = facilityID;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(final double tax) {
        this.tax = tax;
    }

    public IdType getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(final IdType solarSystem) {
        this.solarSystem = solarSystem;
    }

    public IdType getRegion() {
        return region;
    }

    public void setRegion(final IdType region) {
        this.region = region;
    }

    public IdType getOwner() {
        return owner;
    }

    public void setOwner(final IdType owner) {
        this.owner = owner;
    }

    public IdType getType() {
        return type;
    }

    public void setType(final IdType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "IndustryFacility [facilityID=" + facilityID + ", name=" + name + ", tax=" + tax + ", solarSystem=" + solarSystem + ", region="
                + region + ", owner=" + owner + ", type=" + type + "]";
    }
}

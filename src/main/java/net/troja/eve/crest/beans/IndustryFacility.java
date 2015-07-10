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

public class IndustryFacility {
    private int facilityId;
    private String name;
    private float tax;
    private int solarSystemId;
    private int regionId;
    private long ownerId;
    private int typeId;

    public IndustryFacility(final int facilityId, final String name, final float tax, final int solarSystemId, final int regionId,
            final long ownerId, final int typeId) {
        super();
        this.facilityId = facilityId;
        this.name = name;
        this.tax = tax;
        this.solarSystemId = solarSystemId;
        this.regionId = regionId;
        this.ownerId = ownerId;
        this.typeId = typeId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(final int facilityId) {
        this.facilityId = facilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(final float tax) {
        this.tax = tax;
    }

    public int getSolarSystemId() {
        return solarSystemId;
    }

    public void setSolarSystemId(final int solarSystemId) {
        this.solarSystemId = solarSystemId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(final int regionId) {
        this.regionId = regionId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(final long ownerId) {
        this.ownerId = ownerId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(final int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "IndustryFacility [facilityId=" + facilityId + ", name=" + name + ", tax=" + tax + ", solarSystemId=" + solarSystemId + ", regionId="
                + regionId + ", ownerId=" + ownerId + ", typeId=" + typeId + "]";
    }
}

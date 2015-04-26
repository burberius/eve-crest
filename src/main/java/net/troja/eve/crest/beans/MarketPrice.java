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


public class MarketPrice {
    private int typeId;
    private double adjustedPrice;
    private double averagePrice;

    public MarketPrice(final int typeId, final double adjustedPrice, final double averagePrice) {
        super();
        this.typeId = typeId;
        this.adjustedPrice = adjustedPrice;
        this.averagePrice = averagePrice;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(final int typeId) {
        this.typeId = typeId;
    }

    public double getAdjustedPrice() {
        return adjustedPrice;
    }

    public void setAdjustedPrice(final double adjustedPrice) {
        this.adjustedPrice = adjustedPrice;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(final double averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Override
    public String toString() {
        return "MarketPrice [adjustedPrice=" + adjustedPrice + ", averagePrice=" + averagePrice + ", typeId=" + typeId + "]";
    }
}

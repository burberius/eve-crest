package net.troja.eve.crest.market.prices;

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

import net.troja.eve.crest.GeneralType;

public class MarketPrice implements Serializable {
    private static final long serialVersionUID = -5607805124318708430L;

    private double adjustedPrice;
    private double averagePrice;
    private GeneralType type;

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

    public GeneralType getType() {
        return type;
    }

    public void setType(final GeneralType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Price [adjustedPrice=" + adjustedPrice + ", averagePrice=" + averagePrice + ", type=" + type + "]";
    }
}

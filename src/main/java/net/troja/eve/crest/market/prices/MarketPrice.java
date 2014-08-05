package net.troja.eve.crest.market.prices;

import net.troja.eve.crest.GeneralType;

public class MarketPrice {
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

package net.troja.eve.crest.market.prices;

import java.util.List;

import net.troja.eve.crest.ContainerType;

public class MarketPrices extends ContainerType {
    private List<MarketPrice> items;

    public List<MarketPrice> getItems() {
	return items;
    }

    public void setItems(final List<MarketPrice> items) {
	this.items = items;
    }

    @Override
    public String toString() {
	return "MarketPrices [items=" + items + ", getTotalCount()=" + getTotalCount() + ", getPageCount()="
		+ getPageCount() + "]";
    }
}

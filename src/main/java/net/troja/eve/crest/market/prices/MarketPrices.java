package net.troja.eve.crest.market.prices;

import java.util.List;

public class MarketPrices {
    private int totalCount;
    private String totalCount_str;
    private int pageCount;
    private String pageCount_str;
    private List<MarketPrice> items;

    public String getTotalCount_str() {
	return totalCount_str;
    }

    public void setTotalCount_str(final String totalCount_str) {
	this.totalCount_str = totalCount_str;
    }

    public List<MarketPrice> getItems() {
	return items;
    }

    public void setItems(final List<MarketPrice> items) {
	this.items = items;
    }

    public int getTotalCount() {
	return totalCount;
    }

    public void setTotalCount(final int totalCount) {
	this.totalCount = totalCount;
    }

    public int getPageCount() {
	return pageCount;
    }

    public void setPageCount(final int pageCount) {
	this.pageCount = pageCount;
    }

    public String getPageCount_str() {
	return pageCount_str;
    }

    public void setPageCount_str(final String pageCount_str) {
	this.pageCount_str = pageCount_str;
    }

    @Override
    public String toString() {
	return "Prices [totalCount=" + totalCount + ", pageCount=" + pageCount + ", items=" + items + "]";
    }
}

package net.troja.eve.crest.industry.systems;

import java.util.List;

public class IndustrySystems {
    private int totalCount;
    private String totalCount_str;
    private int pageCount;
    private String pageCount_str;
    private List<IndustrySystem> items;

    public int getTotalCount() {
	return totalCount;
    }

    public void setTotalCount(final int totalCount) {
	this.totalCount = totalCount;
    }

    public String getTotalCount_str() {
	return totalCount_str;
    }

    public void setTotalCount_str(final String totalCount_str) {
	this.totalCount_str = totalCount_str;
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

    public List<IndustrySystem> getItems() {
	return items;
    }

    public void setItems(final List<IndustrySystem> items) {
	this.items = items;
    }

    @Override
    public String toString() {
	return "IndustrySystems [totalCount=" + totalCount + ", totalCount_str=" + totalCount_str + ", pageCount="
		+ pageCount + ", pageCount_str=" + pageCount_str + ", items=" + items + "]";
    }

}

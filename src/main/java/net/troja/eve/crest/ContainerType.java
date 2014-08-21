package net.troja.eve.crest;

import java.util.List;

public class ContainerType<T> {
    private int totalCount;
    private int pageCount;
    private List<T> items;

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

    public List<T> getItems() {
	return items;
    }

    public void setItems(final List<T> items) {
	this.items = items;
    }

    @Override
    public String toString() {
	return "ContainerType [totalCount=" + totalCount + ", pageCount=" + pageCount + ", items=" + items + "]";
    }
}

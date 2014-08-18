package net.troja.eve.crest;

public class ContainerType {
    private int totalCount;
    private int pageCount;

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

    @Override
    public String toString() {
	return "ContainerType [totalCount=" + totalCount + ", pageCount=" + pageCount + "]";
    }
}

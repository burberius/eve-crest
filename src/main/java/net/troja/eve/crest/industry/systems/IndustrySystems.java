package net.troja.eve.crest.industry.systems;

import java.util.List;

import net.troja.eve.crest.ContainerType;

public class IndustrySystems extends ContainerType {
    private List<IndustrySystem> items;

    public List<IndustrySystem> getItems() {
	return items;
    }

    public void setItems(final List<IndustrySystem> items) {
	this.items = items;
    }

    @Override
    public String toString() {
	return "IndustrySystems [items=" + items + ", getTotalCount()=" + getTotalCount() + ", getPageCount()="
		+ getPageCount() + "]";
    }

}

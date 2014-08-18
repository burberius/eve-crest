package net.troja.eve.crest.industry.specialities;

import java.util.List;

import net.troja.eve.crest.ContainerType;

public class IndustrySpecialities extends ContainerType {
    private List<IndustrySpeciality> items;

    public List<IndustrySpeciality> getItems() {
	return items;
    }

    public void setItems(final List<IndustrySpeciality> items) {
	this.items = items;
    }

    @Override
    public String toString() {
	return "IndustrySpecialities [items=" + items + ", getTotalCount()=" + getTotalCount() + ", getPageCount()="
		+ getPageCount() + "]";
    }
}

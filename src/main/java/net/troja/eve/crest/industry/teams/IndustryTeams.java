package net.troja.eve.crest.industry.teams;

import java.util.List;

import net.troja.eve.crest.ContainerType;

public class IndustryTeams extends ContainerType {
    private List<IndustryTeam> items;

    public List<IndustryTeam> getItems() {
	return items;
    }

    public void setItems(final List<IndustryTeam> items) {
	this.items = items;
    }

    @Override
    public String toString() {
	return "IndustryTeams [items=" + items + ", getTotalCount()=" + getTotalCount() + ", getPageCount()="
		+ getPageCount() + "]";
    }

}

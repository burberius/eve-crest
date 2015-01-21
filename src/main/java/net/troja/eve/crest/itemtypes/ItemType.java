package net.troja.eve.crest.itemtypes;

import net.troja.eve.crest.GeneralType;

public class ItemType extends GeneralType {
    private static final long serialVersionUID = -1534877729073186918L;

    @Override
    public int getId() {
	return Integer.parseInt(getHref().replaceAll(".*/([0-9]+)/$", "$1"));
    }
}

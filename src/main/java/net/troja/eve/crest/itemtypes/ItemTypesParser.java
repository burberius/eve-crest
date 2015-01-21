package net.troja.eve.crest.itemtypes;

import net.troja.eve.crest.PublicContainerParser;

public class ItemTypesParser extends PublicContainerParser<ItemTypes, ItemType> {
    @Override
    protected String getPath() {
	return "/types/";
    }

    @Override
    protected boolean isPaged() {
	return true;
    }
}

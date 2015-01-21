package net.troja.eve.crest.industry.facilities;

import net.troja.eve.crest.PublicContainerParser;

public class IndustryFacilitiesParser extends PublicContainerParser<IndustryFacilities, IndustryFacility> {
    @Override
    protected String getPath() {
	return "/industry/facilities/";
    }

}

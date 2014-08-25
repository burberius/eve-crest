package net.troja.eve.crest.industry.specialities;

import java.util.HashMap;
import java.util.Map;

import net.troja.eve.crest.PublicParser;

public class IndustrySpecialitiesParser extends PublicParser<IndustrySpecialities> {
    @Override
    protected String getPath() {
	return "/industry/specialities/";
    }

    public Map<Integer, IndustrySpeciality> getDataAsMap() {
	final IndustrySpecialities data = getData();
	final Map<Integer, IndustrySpeciality> map = new HashMap<>();
	if (data == null)
	    return map;
	for (final IndustrySpeciality spec : data.getItems()) {
	    map.put(spec.getId(), spec);
	}
	return map;
    }
}

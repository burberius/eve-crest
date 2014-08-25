package net.troja.eve.crest.industry.systems;

import java.util.HashMap;
import java.util.Map;

import net.troja.eve.crest.PublicParser;

public class IndustrySystemsParser extends PublicParser<IndustrySystems> {
    @Override
    protected String getPath() {
	return "/industry/systems/";
    }

    public Map<String, Map<Integer, Double>> getDataAsMap() {
	final IndustrySystems data = getData();
	final Map<String, Map<Integer, Double>> map = new HashMap<>();
	if (data == null)
	    return map;
	for(final IndustrySystem team : data.getItems()) {
	    final String solarSystem = team.getSolarSystem().getName();
	    Map<Integer, Double> teams = map.get(solarSystem);
	    if(teams == null) {
		teams = new HashMap<>();
		map.put(solarSystem, teams);
	    }
	    for(final CostIndex index : team.getSystemCostIndices()) {
		teams.put(index.getActivityID(), index.getCostIndex());
	    }
	}
	return map;
    }
}

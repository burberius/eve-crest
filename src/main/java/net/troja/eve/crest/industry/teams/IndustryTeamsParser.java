package net.troja.eve.crest.industry.teams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.troja.eve.crest.PublicParser;

public class IndustryTeamsParser extends PublicParser<IndustryTeams> {
    @Override
    protected String getPath() {
	return "/industry/teams/";
    }

    public Map<String, List<IndustryTeam>> getDataAsMap() {
	final IndustryTeams data = getData();
	final Map<String, List<IndustryTeam>> map = new HashMap<>();
	for(final IndustryTeam team : data.getItems()) {
	    final String solarSystem = team.getSolarSystem().getName();
	    List<IndustryTeam> teams = map.get(solarSystem);
	    if(teams == null) {
		teams = new ArrayList<>();
		map.put(solarSystem, teams);
	    }
	    teams.add(team);
	}
	return map;
    }
}

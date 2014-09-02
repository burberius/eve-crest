package net.troja.eve.crest.industry.teams.auction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.troja.eve.crest.PublicParser;

public class IndustryTeamsAuctionParser extends PublicParser<IndustryTeamsAuctions> {
    @Override
    protected String getPath() {
	return "/industry/teams/auction/";
    }

    public Map<String, List<IndustryTeamsAuction>> getDataAsMap() {
	final IndustryTeamsAuctions data = super.getData();

	final Map<String, List<IndustryTeamsAuction>> map = new HashMap<>();
	if (data == null)
	    return map;

	for (final IndustryTeamsAuction auction : data.getItems()) {
	    if ((auction.getSolarSystemBids() == null) || (auction.getSolarSystemBids().size() == 0)) {
		continue;
	    }
	    System.out.println(auction.getName() + " - " + auction.getSolarSystem().getName());
	    Collections.sort(auction.getSolarSystemBids(), new Comparator<SolarSystemBid>() {
		@Override
		public int compare(final SolarSystemBid o1, final SolarSystemBid o2) {
		    return Double.compare(o2.getBidAmount(), o1.getBidAmount());
		}
	    });

	    for (final SolarSystemBid bid : auction.getSolarSystemBids()) {
		final String solarSystem = bid.getSolarSystem().getName();
		List<IndustryTeamsAuction> auctions = map.get(solarSystem);
		if (auctions == null) {
		    auctions = new ArrayList<>();
		    map.put(solarSystem, auctions);
		}
		auctions.add(auction);
	    }
	}
	return map;
    }
}

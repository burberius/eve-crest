package net.troja.eve.crest.industry.teams.auction;

import java.util.Collections;
import java.util.Comparator;

import net.troja.eve.crest.PublicParser;

public class IndustryTeamsAuctionParser extends PublicParser<IndustryTeamsAuctions> {
    @Override
    protected String getPath() {
	return "/industry/teams/auction/";
    }

    @Override
    public IndustryTeamsAuctions getData() {
	final IndustryTeamsAuctions data = super.getData();
	for(final IndustryTeamsAuction auction : data.getItems()) {
	    System.out.println(auction.getName() + " - " + auction.getSolarSystem().getName());
	    Collections.sort(auction.getSolarSystemBids(), new Comparator<SolarSystemBid>() {
		@Override
		public int compare(final SolarSystemBid o1, final SolarSystemBid o2) {
		    return Double.compare(o2.getBidAmount(), o1.getBidAmount());
		}
	    });
	    for(final SolarSystemBid bid : auction.getSolarSystemBids()) {
		System.out.println(bid.toString());
	    }
	}
	return data;
    }
}

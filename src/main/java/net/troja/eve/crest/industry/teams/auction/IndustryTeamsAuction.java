package net.troja.eve.crest.industry.teams.auction;

import java.util.Date;
import java.util.List;

import net.troja.eve.crest.industry.teams.IndustryTeam;

public class IndustryTeamsAuction extends IndustryTeam {
    private static final long serialVersionUID = -5765717871501694994L;

    private Date auctionExpiryTime;
    private List<SolarSystemBid> solarSystemBids;

    public Date getAuctionExpiryTime() {
	return auctionExpiryTime;
    }

    public void setAuctionExpiryTime(final Date auctionExpiryTime) {
	this.auctionExpiryTime = auctionExpiryTime;
    }

    public List<SolarSystemBid> getSolarSystemBids() {
	return solarSystemBids;
    }

    public void setSolarSystemBids(final List<SolarSystemBid> solarSystemBids) {
	this.solarSystemBids = solarSystemBids;
    }

    @Override
    public String toString() {
	return "IndustryTeamAuction [auctionExpiryTime=" + auctionExpiryTime + ", solarSystemBids=" + solarSystemBids
		+ ", getSolarSystem()=" + getSolarSystem() + ", getName()=" + getName() + ", getCreationTime()="
		+ getCreationTime() + ", getWorkers()=" + getWorkers() + ", getExpiryTime()=" + getExpiryTime()
		+ ", getCostModifier()=" + getCostModifier() + ", getId()=" + getId() + ", getActivity()="
		+ getActivity() + ", getSpecialization()=" + getSpecialization() + "]";
    }
}

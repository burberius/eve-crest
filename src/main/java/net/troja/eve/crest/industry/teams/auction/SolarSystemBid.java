package net.troja.eve.crest.industry.teams.auction;

import java.io.Serializable;
import java.util.List;

import net.troja.eve.crest.GeneralType;

public class SolarSystemBid implements Serializable {
    private static final long serialVersionUID = -8777873858021117890L;

    private GeneralType solarSystem;
    private List<CharacterBid> characterBids;
    private double bidAmount;

    public GeneralType getSolarSystem() {
	return solarSystem;
    }

    public void setSolarSystem(final GeneralType solarSystem) {
	this.solarSystem = solarSystem;
    }

    public List<CharacterBid> getCharacterBids() {
	return characterBids;
    }

    public void setCharacterBids(final List<CharacterBid> characterBids) {
	this.characterBids = characterBids;
    }

    public double getBidAmount() {
	return bidAmount;
    }

    public void setBidAmount(final double bidAmount) {
	this.bidAmount = bidAmount;
    }

    @Override
    public String toString() {
	return "SolarSystemBid [solarSystem=" + solarSystem + ", characterBids=" + characterBids + ", bidAmount="
		+ bidAmount + "]";
    }
}

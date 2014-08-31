package net.troja.eve.crest.industry.teams.auction;

import java.io.Serializable;

public class CharacterBid implements Serializable {
    private static final long serialVersionUID = 1993863205641388670L;

    private EveCharacter character;
    private double bidAmount;

    public EveCharacter getCharacter() {
	return character;
    }

    public void setCharacter(final EveCharacter character) {
	this.character = character;
    }

    public double getBidAmount() {
	return bidAmount;
    }

    public void setBidAmount(final double bidAmount) {
	this.bidAmount = bidAmount;
    }

    @Override
    public String toString() {
	return "CharacterBid [character=" + character + ", bidAmount=" + bidAmount + "]";
    }
}

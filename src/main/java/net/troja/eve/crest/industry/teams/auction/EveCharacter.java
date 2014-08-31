package net.troja.eve.crest.industry.teams.auction;

import net.troja.eve.crest.GeneralType;
import net.troja.eve.crest.Reference;

public class EveCharacter extends GeneralType {
    private static final long serialVersionUID = -2137649072537280406L;

    private boolean isNPC;
    private Reference capsuleer;

    public boolean isNPC() {
	return isNPC;
    }

    public void setNPC(final boolean isNPC) {
	this.isNPC = isNPC;
    }

    public Reference getCapsuleer() {
	return capsuleer;
    }

    public void setCapsuleer(final Reference capsuleer) {
	this.capsuleer = capsuleer;
    }

    @Override
    public String toString() {
	return "EveCharacter [isNPC=" + isNPC + ", capsuleer=" + capsuleer + ", getHref()=" + getHref() + ", getId()="
		+ getId() + ", getName()=" + getName() + "]";
    }
}

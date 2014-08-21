package net.troja.eve.crest.industry.teams;

import java.io.Serializable;

import net.troja.eve.crest.GeneralType;

public class Worker implements Serializable {
    private static final long serialVersionUID = 5903099919929929247L;

    private Bonus bonus;
    private GeneralType specialization;

    public Bonus getBonus() {
	return bonus;
    }

    public void setBonus(final Bonus bonus) {
	this.bonus = bonus;
    }

    public GeneralType getSpecialization() {
	return specialization;
    }

    public void setSpecialization(final GeneralType specialization) {
	this.specialization = specialization;
    }

    @Override
    public String toString() {
	return "Worker [bonus=" + bonus + ", specialization=" + specialization + "]";
    }
}

package net.troja.eve.crest.industry.teams;

import java.io.Serializable;

public class Bonus implements Serializable {
    private static final long serialVersionUID = 3857919232874247825L;

    private int id;
    private String bonusType;
    private double value;

    public int getId() {
	return id;
    }

    public void setId(final int id) {
	this.id = id;
    }

    public String getBonusType() {
	return bonusType;
    }

    public void setBonusType(final String bonusType) {
	this.bonusType = bonusType;
    }

    public double getValue() {
	return value;
    }

    public void setValue(final double value) {
	this.value = value;
    }

    @Override
    public String toString() {
	return "Bonus [id=" + id + ", bonusType=" + bonusType + ", value=" + value + "]";
    }
}

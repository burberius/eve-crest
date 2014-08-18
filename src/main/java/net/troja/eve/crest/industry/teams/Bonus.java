package net.troja.eve.crest.industry.teams;

public class Bonus {
    private int id;
    private String bonusType;
    private int value;

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

    public int getValue() {
	return value;
    }

    public void setValue(final int value) {
	this.value = value;
    }

    @Override
    public String toString() {
	return "Bonus [id=" + id + ", bonusType=" + bonusType + ", value=" + value + "]";
    }
}

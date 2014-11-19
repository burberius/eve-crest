package net.troja.eve.crest.industry.facilities;

import java.io.Serializable;

import net.troja.eve.crest.IdType;

public class IndustryFacility implements Serializable {
    private static final long serialVersionUID = -1817751027149221431L;

    private long facilityID;
    private String name;
    private double tax;
    private IdType solarSystem;
    private IdType region;
    private IdType owner;
    private IdType type;

    public long getFacilityID() {
	return facilityID;
    }

    public void setFacilityID(long facilityID) {
	this.facilityID = facilityID;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public double getTax() {
	return tax;
    }

    public void setTax(double tax) {
	this.tax = tax;
    }

    public IdType getSolarSystem() {
	return solarSystem;
    }

    public void setSolarSystem(IdType solarSystem) {
	this.solarSystem = solarSystem;
    }

    public IdType getRegion() {
	return region;
    }

    public void setRegion(IdType region) {
	this.region = region;
    }

    public IdType getOwner() {
	return owner;
    }

    public void setOwner(IdType owner) {
	this.owner = owner;
    }

    public IdType getType() {
	return type;
    }

    public void setType(IdType type) {
	this.type = type;
    }

    @Override
    public String toString() {
	return "IndustryFacility [facilityID=" + facilityID + ", name=" + name + ", tax=" + tax + ", solarSystem="
		+ solarSystem + ", region=" + region + ", owner=" + owner + ", type=" + type + "]";
    }
}

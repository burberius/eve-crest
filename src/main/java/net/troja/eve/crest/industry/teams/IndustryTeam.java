package net.troja.eve.crest.industry.teams;

import java.util.Date;
import java.util.List;

import net.troja.eve.crest.GeneralType;

public class IndustryTeam {
    private GeneralType solarSystem;
    private String name;
    private Date creationTime;
    private List<Worker> workers;
    private Date expiryTime;
    private int costModifier;
    private int id;
    private int activity;
    private GeneralType specialization;

    public GeneralType getSolarSystem() {
	return solarSystem;
    }

    public void setSolarSystem(final GeneralType solarSystem) {
	this.solarSystem = solarSystem;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public Date getCreationTime() {
	return creationTime;
    }

    public void setCreationTime(final Date creationTime) {
	this.creationTime = creationTime;
    }

    public List<Worker> getWorkers() {
	return workers;
    }

    public void setWorkers(final List<Worker> workers) {
	this.workers = workers;
    }

    public Date getExpiryTime() {
	return expiryTime;
    }

    public void setExpiryTime(final Date expiryTime) {
	this.expiryTime = expiryTime;
    }

    public int getCostModifier() {
	return costModifier;
    }

    public void setCostModifier(final int costModifier) {
	this.costModifier = costModifier;
    }

    public int getId() {
	return id;
    }

    public void setId(final int id) {
	this.id = id;
    }

    public int getActivity() {
	return activity;
    }

    public void setActivity(final int activity) {
	this.activity = activity;
    }

    public GeneralType getSpecialization() {
	return specialization;
    }

    public void setSpecialization(final GeneralType specialization) {
	this.specialization = specialization;
    }

    @Override
    public String toString() {
	return "IndustryTeam [solarSystem=" + solarSystem + ", name=" + name + ", creationTime=" + creationTime
		+ ", workers=" + workers + ", expiryTime=" + expiryTime + ", costModifier=" + costModifier + ", id="
		+ id + ", activity=" + activity + ", specialization=" + specialization + "]";
    }
}

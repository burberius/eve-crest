package net.troja.eve.crest.industry.systems;

import java.io.Serializable;

public class CostIndex implements Serializable {
    private static final long serialVersionUID = 4359370790615315807L;

    private double costIndex;
    private int activityID;
    private String activityName;

    public double getCostIndex() {
	return costIndex;
    }

    public void setCostIndex(final double costIndex) {
	this.costIndex = costIndex;
    }

    public int getActivityID() {
	return activityID;
    }

    public void setActivityID(final int activityID) {
	this.activityID = activityID;
    }

    public String getActivityName() {
	return activityName;
    }

    public void setActivityName(final String activityName) {
	this.activityName = activityName;
    }

    @Override
    public String toString() {
	return "CostIndex [costIndex=" + costIndex + ", activityID=" + activityID + ", activityName=" + activityName
		+ "]";
    }
}

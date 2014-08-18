package net.troja.eve.crest.industry.systems;

public class CostIndex {
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

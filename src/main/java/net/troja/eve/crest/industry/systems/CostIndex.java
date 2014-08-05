package net.troja.eve.crest.industry.systems;

public class CostIndex {
    private double costIndex;
    private int activityID;
    private String activityID_str;
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

    public String getActivityID_str() {
	return activityID_str;
    }

    public void setActivityID_str(final String activityID_str) {
	this.activityID_str = activityID_str;
    }

    public String getActivityName() {
	return activityName;
    }

    public void setActivityName(final String activityName) {
	this.activityName = activityName;
    }

    @Override
    public String toString() {
	return "SystemCostIndex [costIndex=" + costIndex + ", activityID=" + activityID + ", activityID_str="
		+ activityID_str + ", activityName=" + activityName + "]";
    }
}

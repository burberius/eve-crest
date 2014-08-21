package net.troja.eve.crest.industry.systems;

import java.io.Serializable;
import java.util.List;

import net.troja.eve.crest.GeneralType;

public class IndustrySystem implements Serializable {
    private static final long serialVersionUID = 5467636267727502281L;

    private List<CostIndex> systemCostIndices;
    private GeneralType solarSystem;

    public List<CostIndex> getSystemCostIndices() {
	return systemCostIndices;
    }

    public void setSystemCostIndices(final List<CostIndex> systemCostIndices) {
	this.systemCostIndices = systemCostIndices;
    }

    public GeneralType getSolarSystem() {
	return solarSystem;
    }

    public void setSolarSystem(final GeneralType solarSystem) {
	this.solarSystem = solarSystem;
    }

    @Override
    public String toString() {
	return "System [systemCostIndices=" + systemCostIndices + ", solarSystem=" + solarSystem + "]";
    }
}

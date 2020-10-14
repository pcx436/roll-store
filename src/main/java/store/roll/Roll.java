package store.roll;

import store.roll.CostStrategy.CostStrategy;

public abstract class Roll {
    protected String description;
    protected double baseCost;
    protected CostStrategy costStrategy;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public CostStrategy getCostStrategy() {
        return costStrategy;
    }

    public void setCostStrategy(CostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

    //TODO: change descriptions of rolls
}

package store.roll.RollDecorator;

import store.roll.CostStrategy.CostStrategy;
import store.roll.Roll;

//1 of 3 Distinct Design Patterns for this Project
public abstract class RollDecorator extends Roll {
    protected Roll roll;

    //constructor
    public RollDecorator(Roll roll) {
        this.roll = roll;
    }

    //description getter
    public String getDescription(){
        return this.roll.getDescription();
    }

    @Override
    public double getBaseCost(){
    //cost getter
        return this.roll.getBaseCost();
    }

    //type getter
    public int getType() {
        return this.roll.getType();
    }

    public CostStrategy getCostStrategy() {
        return this.roll.getCostStrategy();
    }
}

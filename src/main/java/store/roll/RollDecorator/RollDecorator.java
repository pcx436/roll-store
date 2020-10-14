package store.roll.RollDecorator;

import store.roll.Roll;

public abstract class RollDecorator extends Roll {
    protected Roll roll;

    public RollDecorator(Roll roll) {
        this.roll = roll;
    }

    public String getDescription(){
        return this.roll.getDescription();
    }

    public double getCost(){
        return this.roll.getBaseCost();
    }
}

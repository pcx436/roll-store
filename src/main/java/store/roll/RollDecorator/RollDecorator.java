package store.roll.RollDecorator;

import store.roll.Roll;

public abstract class RollDecorator extends Roll {
    protected Roll roll;

    public RollDecorator(Roll roll) {
        this.roll = roll;
    }

    public String getDescription(){
        return this.roll.getDesciption();
    }

    public double getCost(){
        return this.roll.getCost();
    }
}

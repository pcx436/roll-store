package store.roll.RollDecorator;

import store.roll.Roll;

public class ExtraTopping extends RollDecorator {
    public ExtraTopping(Roll roll){
        super(roll);
    }

    public String getDescription(){
        return this.roll.getDescription() + ", with extra topping";
    }

    public double getCost(){
        return this.roll.getBaseCost() + this.roll.getCostStrategy().getToppingCost();
    }
}

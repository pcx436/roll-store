package store.roll.RollDecorator;

import store.roll.Roll;

public class ExtraTopping extends RollDecorator {
    //constructor
    public ExtraTopping(Roll roll){
        super(roll);
    }

    @Override
    public String getDescription(){
        return this.roll.getDescription() + ", with extra topping";
    }

    @Override
    public double getBaseCost(){
        return this.roll.getBaseCost() + this.roll.getCostStrategy().getToppingCost();
    }
}

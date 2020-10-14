package store.roll.RollDecorator;

import store.roll.Roll;

public class ExtraTopping extends RollDecorator {
    public ExtraTopping(Roll roll){
        super(roll);
        System.out.println(", with extra topping");
    }

    public String getDescription(){
        return this.roll.getDescription() + ", topping";
    }

    public double getCost(){
        return this.roll.getBaseCost() + this.roll.getCostStrategy().getToppingCost();
    }
}

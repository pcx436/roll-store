package store.roll.RollDecorator;

import store.roll.Roll;

public class ExtraFilling extends RollDecorator {
    public ExtraFilling(Roll roll){
        super(roll);
        System.out.println(", with extra feeling");
    }

    public String getDescription(){
        return this.roll.getDescription() + ", filling";
    }

    public double getCost(){
        return this.roll.getBaseCost() + this.roll.getCostStrategy().getFillingCost();
    }
}

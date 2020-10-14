package store.roll.RollDecorator;

import store.roll.Roll;

public class ExtraFilling extends RollDecorator {
    public ExtraFilling(Roll roll){
        super(roll);
    }

    public String getDescription(){
        return this.roll.getDescription() + ", with extra filling";
    }

    public double getCost(){
        return this.roll.getBaseCost() + this.roll.getCostStrategy().getFillingCost();
    }
}

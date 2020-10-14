package store.roll.RollDecorator;

import store.roll.Roll;

public class ExtraSauce extends RollDecorator {
    //constructor
    public ExtraSauce(Roll roll){
        super(roll);
    }

    public String getDescription(){
        return this.roll.getDescription() + ", with extra sauce";
    }

    public double getCost(){
        return this.roll.getBaseCost() + this.roll.getCostStrategy().getSauceCost();
    }
}

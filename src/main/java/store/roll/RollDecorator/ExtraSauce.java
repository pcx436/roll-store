package store.roll.RollDecorator;

import store.roll.Roll;

public class ExtraSauce extends RollDecorator {
    public ExtraSauce(Roll roll){
        super(roll);
        System.out.println(", with extra sauce");
    }

    public String getDescription(){
        return this.roll.getDescription() + ", sauce";
    }

    public double getCost(){
        return this.roll.getBaseCost() + this.roll.getCostStrategy().getSauceCost();
    }
}

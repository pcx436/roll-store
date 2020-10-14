package store.roll.RollDecorator;

import store.roll.Roll;

public class ExtraSauce extends RollDecorator {
    public ExtraSauce(Roll roll){
        super(roll);
    }

    @Override
    public String getDescription(){
        return this.roll.getDescription() + ", with extra sauce";
    }

    @Override
    public double getBaseCost(){
        return this.roll.getBaseCost() + this.roll.getCostStrategy().getSauceCost();
    }
}

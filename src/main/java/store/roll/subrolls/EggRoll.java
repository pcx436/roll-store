package store.roll.subrolls;

import store.roll.CostStrategy.EggRollStrategy;
import store.roll.Roll;

public class EggRoll extends Roll {
    //constructor
    public EggRoll() {
        this.baseCost = 2.99;
        this.description = "Vincent's left";
        this.costStrategy = new EggRollStrategy();
        this.type = 2;
    }
}

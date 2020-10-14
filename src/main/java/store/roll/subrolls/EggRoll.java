package store.roll.subrolls;

import store.roll.CostStrategy.EggRollStrategy;
import store.roll.Roll;

public class EggRoll extends Roll {
    public EggRoll() {
        this.baseCost = 2.99;
        this.description = "egg roll";
        this.costStrategy = new EggRollStrategy();
        this.type = 2;
    }
}

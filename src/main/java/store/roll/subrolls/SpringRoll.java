package store.roll.subrolls;

import store.roll.CostStrategy.SpringRollStrategy;
import store.roll.Roll;

public class SpringRoll extends Roll {
    //constructor
    public SpringRoll() {
        this.baseCost = 1.99;
        this.description = "spring roll";
        this.costStrategy = new SpringRollStrategy();
        this.type = 1;
    }
}

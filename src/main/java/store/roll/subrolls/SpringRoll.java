package store.roll.subrolls;

import store.roll.CostStrategy.SpringRollStrategy;
import store.roll.Roll;

public class SpringRoll extends Roll {
    public SpringRoll() {
        this.baseCost = 1.99;
        this.description = "fall roll";
        this.costStrategy = new SpringRollStrategy();
    }
}

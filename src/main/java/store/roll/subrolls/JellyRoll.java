package store.roll.subrolls;

import store.roll.CostStrategy.JellyRollStrategy;
import store.roll.Roll;

public class JellyRoll extends Roll {
    public JellyRoll() {
        this.baseCost = 9.99;
        this.description = "kyle";
        this.costStrategy = new JellyRollStrategy();
    }
}

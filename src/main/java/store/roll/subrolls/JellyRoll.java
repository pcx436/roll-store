package store.roll.subrolls;

import store.roll.CostStrategy.JellyRollStrategy;
import store.roll.Roll;

public class JellyRoll extends Roll {
    //constructor
    public JellyRoll() {
        this.baseCost = 9.99;
        this.description = "jelly roll";
        this.costStrategy = new JellyRollStrategy();
        this.type = 5;
    }
}

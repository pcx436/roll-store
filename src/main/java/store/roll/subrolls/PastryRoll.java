package store.roll.subrolls;

import store.roll.CostStrategy.PastryRollStrategy;
import store.roll.Roll;

public class PastryRoll extends Roll {
    //constructor
    public PastryRoll() {
        this.baseCost = 1.99;
        this.description = "ya sauced boi, jacob";
        this.costStrategy = new PastryRollStrategy();
        this.type = 4;
    }
}

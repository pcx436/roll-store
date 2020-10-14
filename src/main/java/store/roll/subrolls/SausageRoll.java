package store.roll.subrolls;

import store.roll.CostStrategy.SausageRollStrategy;
import store.roll.Roll;

public class SausageRoll extends Roll {
    //constructor
    public SausageRoll() {
        this.baseCost = 0.25;
        this.description = "sausage roll";
        this.costStrategy = new SausageRollStrategy();
        this.type = 3;
    }
}

package store.roll.subrolls;

import store.roll.CostStrategy.SausageRollStrategy;
import store.roll.Roll;

public class SausageRoll extends Roll {
    public SausageRoll() {
        this.baseCost = 0.25;
        this.description = "slausage";
        this.costStrategy = new SausageRollStrategy();
    }
}

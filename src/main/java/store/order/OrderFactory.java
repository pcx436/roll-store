package store.order;

import store.roll.RollFactory;

public class OrderFactory {
    private final RollFactory rollFactory;

    public OrderFactory() {
        rollFactory = new RollFactory();
    }
}

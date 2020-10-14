package store.order;

import store.Inventory;
import store.roll.Roll;

import java.util.List;

public class CasualOrder extends Order {
    public CasualOrder(List<Roll> rolls) {
        super(rolls);
    }

    @Override
    public Boolean placeOrder(Inventory invent) {
        //TODO
        return true;
    }
}

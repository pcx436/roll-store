package store.order;

import store.Inventory;
import store.roll.Roll;

import java.util.List;

public class CateringOrder extends Order {
    public CateringOrder(List<Roll> rolls) {
        super(rolls);
    }

    @Override
    public Boolean placeOrder(Inventory invent) {
        //TODO
        return true;
    }
}

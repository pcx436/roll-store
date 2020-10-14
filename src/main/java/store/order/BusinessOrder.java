package store.order;

import store.Inventory;
import store.roll.Roll;

import java.util.List;

public class BusinessOrder extends Order {

    public BusinessOrder(List<Roll> rolls) {
        super(rolls);
    }

    @Override
    public Boolean placeOrder(Inventory invent) {
        if (canFillOrder(invent)) {
            for (int i = 1; i <= 5; i++) {
                invent.buyRolls(i, 2);
            }
            return true;
        }
        else {
            return false;
        }
    }

}

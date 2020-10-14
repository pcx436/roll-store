package store.order;

import store.Inventory;
import store.roll.Roll;

import java.util.List;

public class BusinessOrder extends Order {

    public BusinessOrder(List<Roll> rolls) {
        super(rolls);
    }

    @Override
    //logic for business order
    public Boolean placeOrder(Inventory invent) {
        //if order is able to be filled, then buy rolls 2 of each of the 5 types of rolls
        if (canFillOrder(invent)) {
            for (int i = 1; i <= 5; i++) {
                invent.buyRolls(i, 2);
            }
            return true;
        }
        else {
            //else, the business customer doesn't buy any rolls if they can't get the order perfect
            return false;
        }
    }

}

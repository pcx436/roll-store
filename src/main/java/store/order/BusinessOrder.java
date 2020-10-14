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
    public double placeOrder(Inventory invent) {
        //if order is able to be filled, then buy rolls 2 of each of the 5 types of rolls
        if (canFillOrder(invent)) {
            System.out.println("A business customer was able to place an order with total $" + df.format(this.getTotal()) + " with the following rolls:");
            submitOrder(invent);
            return getTotal();
        }
        else {
            System.out.println("A business customer was unable to fill their order.");
            return -1.0;
        }
    }

}

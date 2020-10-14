package store.order;

import store.Inventory;
import store.roll.Roll;

import java.util.List;

public class BusinessOrder extends Order {

    public BusinessOrder(List<Roll> rolls) {
        super(rolls);
    }

    @Override
    public double placeOrder(Inventory invent) {
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

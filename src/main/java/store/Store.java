package store;

import store.order.BusinessOrder;
import store.order.CasualOrder;
import store.order.Order;
import store.order.OrderFactory;
import java.util.List;

public class Store {

    private static void printInventory(Inventory inventory) {
        System.out.println("The current inventory is as follows:");
        for(int i = 1; i <= 5; i++) {
            System.out.println("\t" + inventory.typeToString(i) + ": " + inventory.getRollAmount(i));
        }
    }

    private static int orderToInt(Order order) {
        if (CasualOrder.class.isInstance(order))
            return 0;
        else if (BusinessOrder.class.isInstance(order))
            return 1;
        else
            return 2;
    }

    public static void main(String[] args){
        OrderFactory orderFactory = new OrderFactory();
        Inventory inventory = new Inventory();
        List<Order> orderList;

        for(int day = 1; day <= 30; day++) {
            orderList = orderFactory.createOrders();

            System.out.println("It is day #" + day);
            printInventory(inventory);

            for (Order order: orderList) {
                double orderTotal = order.placeOrder(inventory);

                if (orderTotal < 0.0) {  // order failed
                    // TODO:
                }
            }

            printInventory(inventory);
            inventory.refillRoll();
        }
    }
}

package store;

import store.order.BusinessOrder;
import store.order.CasualOrder;
import store.order.Order;
import store.order.OrderFactory;
import store.roll.Roll;

import java.text.DecimalFormat;
import java.util.ArrayList;
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
        DecimalFormat df = new DecimalFormat("#.##");

        double simulationProfit = 0.0;
        int impacts = 0;
        int[] rollCount = {0, 0, 0, 0, 0};

        for(int day = 1; day <= 30; day++) {
            orderList = orderFactory.createOrders();

            double profit = 0.0;
            List<Double> orderTotals = new ArrayList<>();
            List<Integer> numFailed = new ArrayList<>();
            List<Integer> outageVictims = new ArrayList<>();

            for(int i = 0; i < 3; i++) {
                orderTotals.add(0.0);
                numFailed.add(0);
                outageVictims.add(0);
            }

            System.out.println("It is day #" + day);
            printInventory(inventory);

            for (Order order: orderList) {
                int typeInt = orderToInt(order);
                double orderTotal = order.placeOrder(inventory);

                // increase roll type counter
                for(Roll roll: order.getRolls())
                    rollCount[roll.getType() - 1]++;

                if (orderTotal < 0.0) {  // order failed
                    numFailed.set(typeInt, numFailed.get(typeInt) + 1);
                    impacts++;
                } else {
                    orderTotals.set(typeInt, orderTotals.get(typeInt) + orderTotal);
                    profit += orderTotal;
                }

                if (order.isEffectedByOutage())
                    outageVictims.set(typeInt, outageVictims.get(typeInt) + 1);

                if (inventory.isClosed())
                    break;
            }

            printInventory(inventory);

            // end of day printing
            System.out.println("The net profit for today was $" + df.format(profit));

            System.out.println("The net profit for each type of customer was:");
            System.out.println("\t$" + df.format(orderTotals.get(0)) + " from casual customers.");
            System.out.println("\t$" + df.format(orderTotals.get(1)) + " from business customers.");
            System.out.println("\t$" + df.format(orderTotals.get(2)) + " from catering customers.");

            System.out.println("The customers affected by any roll outages are:");
            System.out.println("\t" + df.format(numFailed.get(0)) + " from casual customers.");
            System.out.println("\t" + df.format(numFailed.get(1)) + " from business customers.");
            System.out.println("\t" + df.format(numFailed.get(2)) + " from catering customers.");

            if (inventory.isClosed())
                System.out.println("The store closed early today due to running out of inventory.");

            // roll orders by type
            for(int i = 1; i <= 5; i++){
                System.out.println(30 - inventory.getRollAmount(i) + " " + inventory.typeToString(i) + "s were sold today");
            }

            inventory.refillRoll();

            simulationProfit += profit;
        }
    }
}

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

    /**
     * Prety-printing function for an Inventory object.
     * @param inventory  The inventory to pretty print
     */
    private static void printInventory(Inventory inventory) {
        System.out.println("The current inventory is as follows:");
        for(int i = 1; i <= 5; i++) {
            System.out.println("\t" + inventory.typeToString(i) + ": " + inventory.getRollAmount(i));
        }
    }

    /**
     * Order to type integer for tracking order success/failure
     * @param order  Order to type convert
     * @return  Integer representing the order. 0 if CasualOrder, 1 if BusinessOrder, and 2 if CateringOrder
     */
    private static int orderToInt(Order order) {
        if (order instanceof CasualOrder)
            return 0;
        else if (order instanceof BusinessOrder)
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

        // run simulation for 30 days
        for(int day = 1; day <= 30; day++) {
            orderList = orderFactory.createOrders();

            double profit = 0.0;  // profit for entire day
            List<Double> orderTotals = new ArrayList<>();  // sort profity by order type
            List<Integer> numFailed = new ArrayList<>();  // sort order failure by order type
            List<Integer> outageVictims = new ArrayList<>();  // sort victims of outage by order type

            // initialize tracking lists
            for(int i = 0; i < 3; i++) {
                orderTotals.add(0.0);
                numFailed.add(0);
                outageVictims.add(0);
            }

            System.out.println("It is day #" + day);
            printInventory(inventory);

            // Loop through all orders that have been generated for the day
            for (Order order: orderList) {
                int typeInt = orderToInt(order);
                double orderTotal = order.placeOrder(inventory);

                // increase counter for each roll in order
                for(Roll roll: order.getRolls())
                    rollCount[roll.getType() - 1]++;

                if (orderTotal < 0.0) {  // order failed
                    numFailed.set(typeInt, numFailed.get(typeInt) + 1);
                    impacts++;
                } else {  // order succeeded, track profit by type and globally
                    orderTotals.set(typeInt, orderTotals.get(typeInt) + orderTotal);
                    profit += orderTotal;
                }

                // increase outage victim tracking
                if (order.isEffectedByOutage())
                    outageVictims.set(typeInt, outageVictims.get(typeInt) + 1);

                // If the store is closed for the day, stop the loop
                if (inventory.isClosed())
                    break;
            }

            // end of day inventory printing
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

        int totalRolls = 0;

        System.out.println("Simulation completed!");
        System.out.println("Completion stats:");

        // Print out number of rolls sold per roll type
        for(int i = 0; i < 5; i++) {
            System.out.println("\t" + rollCount[i] + " " + inventory.typeToString(i + 1) + "s were sold.");
            totalRolls += rollCount[i];
        }

        // Print number of rolls total, total profit over entire simulation, and number of store outage impacts
        System.out.println("\t" + totalRolls + " rolls were sold in total.");
        System.out.println("\tThe total profit margin was $" + df.format(simulationProfit));
        System.out.println("\t" + impacts + " customers were impacted by one or more roll outages.");
    }
}

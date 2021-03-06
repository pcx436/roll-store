package store.order;

import store.Inventory;
import store.roll.Roll;

import java.text.DecimalFormat;
import java.util.List;

public abstract class Order {
    protected List<Roll> rolls;
    protected int[] rollCount = {0, 0, 0, 0, 0};
    protected boolean effectedByOutage;
    protected final DecimalFormat df = new DecimalFormat("#.##");

    //constructor
    public Order(List<Roll> rolls) {
        this.setRolls(rolls);
        effectedByOutage = false;
    }


    //getter for list of rolls
    public List<Roll> getRolls() {
        return rolls;
    }

    //setter for list of rolls
    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;

        // wipe current counts
        for (int i = 0; i < 5; i++)
            rollCount[i] = 0;

        // create array that has count of rolls by type
        for (Roll r: this.rolls) {
            rollCount[r.getType() - 1]++;
        }
    }

    //abstract method to handle different placeOrder functionality per customer type (business, cater, casual)
    public abstract double placeOrder(Inventory invent);

    protected void submitOrder(Inventory invent){
        for (Roll roll: this.rolls) {
            System.out.println("\t" + roll.getDescription());
            invent.buyRolls(roll.getType(), 1);
        }
    }

    //returns a boolean on whether or not the inventory has the stock for a given order to be completed
    public boolean canFillOrder(Inventory invent) {

        // see if the count of a given roll type is too much for what's in stock
        for (int i = 0; i < 5; i++){
            if (rollCount[i] != 0 && invent.getRollAmount(i + 1) < rollCount[i]) {
                effectedByOutage = true;
                return false;
            }
        }

        return true;
    }

    public double getTotal(){
        double total = 0.0;
        for(Roll roll: this.rolls) {
            total += roll.getBaseCost();
        }

        return total;
    }

    public boolean isEffectedByOutage(){ return effectedByOutage; }
}

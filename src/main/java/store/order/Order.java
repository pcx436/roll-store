package store.order;

import store.Inventory;
import store.roll.Roll;

import java.util.List;

public abstract class Order {
    protected List<Roll> rolls;
    protected int[] rollCount = {0, 0, 0, 0, 0};

    public Order(List<Roll> rolls) {
        this.setRolls(rolls);
    }


    public List<Roll> getRolls() {
        return rolls;
    }

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

    public abstract Boolean placeOrder(Inventory invent);

    public boolean canFillOrder(Inventory invent) {

        // see if the count of a given roll type is too much for what's in stock
        for (int i = 0; i < 5; i++){
            if (rollCount[i] != 0 && invent.getRollAmount(i + 1) < rollCount[i])
                return false;
        }

        return true;
    }
}

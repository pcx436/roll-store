package store.order;

import store.Inventory;
import store.roll.Roll;

import java.util.List;

public abstract class Order {
    protected List<Roll> rolls;

    public Order(List<Roll> rolls) {
        this.rolls = rolls;
    }


    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

    public Boolean placeOrder(Inventory invent) {
        //TODO
        return true;
    }
}

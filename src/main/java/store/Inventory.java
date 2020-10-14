package store;

import store.roll.Roll;
import store.roll.subrolls.*;

import java.util.HashMap;

public class Inventory {
    HashMap<Integer, Integer> dict;

    public Inventory(){
        dict = new HashMap<>();

        // initializing all rolls to 30
        for (int i = 0; i < 5; i++){
            dict.put(i + 1, 30);
        }
    }

    public int getRollAmount(int key){ return dict.get(key); }

    /**
     * Called at the end of each day to refill missing rolls to 30
     */
    public void refillRoll() {
        for (int i = 1; i <= 5; i++) {
            if (dict.get(i) == 0)
                dict.put(i, 30);
        }
    }

    public Boolean buyRolls(int type, int num) {
        if (dict.get(type) >= num){
            dict.put(type, dict.get(type) - num);

            if (dict.get(type) == 0) {
                System.out.println("NOTICE: The store has run out of " + typeToString(type) + "s!");
            }

            return true;
        } else {
            return false;
        }
    }

    private String typeToString(int type) {
        if (type == 1) {
            return "spring roll";
        }
        else if (type == 2) {
            return "egg roll";
        }
        else if (type == 3) {
            return "sausage roll";
        }
        else if (type == 4) {
            return "pastry roll";
        }
        else {
            return "jelly roll";
        }
    }
}

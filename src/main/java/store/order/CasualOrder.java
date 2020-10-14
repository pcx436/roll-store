package store.order;

import store.Inventory;
import store.roll.Roll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CasualOrder extends Order {
    public CasualOrder(List<Roll> rolls) {
        super(rolls);
    }

    @Override
    public Boolean placeOrder(Inventory invent) {

        if (canFillOrder(invent)){
            for (int i = 0; i < 5; i++) {
                if (this.rollCount[i] > 0)  // only buy rolls we want
                    invent.buyRolls(i + 1, this.rollCount[i]);
            }
            return true;
        } else {  // cannot fill order, figure it out
            List<Integer> rollKeys = new ArrayList<>();
            int originalRollCount = 0;
            for(int i = 0; i < 5; i++) {
                originalRollCount += this.rollCount[i];
                rollKeys.add(i + 1);
            }


            for (int i = 0; i < 5; i++){
                int numDesired = this.rollCount[i];
                int currentRollType = i + 1;

                if (numDesired > 0){
                    int amountInStock = invent.getRollAmount(currentRollType);

                    // take [1, numDesired] of rolls in stock
                    if (numDesired > amountInStock && amountInStock >= 0) {
                        int numToRemove = numDesired - amountInStock;  // num to remove from out list of rolls
                        rollKeys.remove(i);

                        while (numToRemove > 0) {
                            for(int j = 0; j < this.rolls.size(); j++) {
                                if (this.rolls.get(j).getType() == currentRollType) {
                                    this.rolls.remove(j);
                                    numToRemove--;
                                    break;
                                }
                            }
                        }

                        this.setRolls(this.rolls);  // update rollCount
                    }
                }
            }

            // repopulate with roll types
            Collections.shuffle(rollKeys);

            for(int i = 0; i < rollKeys.size(); i++) {
                Integer type = rollKeys.get(i);

                int inStock = invent.getRollAmount(type);
                if (inStock > 0 && inStock >= originalRollCount - this.rolls.size()) {

                } else if (inStock > 0 )
            }

        }

        return true;
    }
}

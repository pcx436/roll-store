package store.order;

import store.Inventory;
import store.roll.Roll;
import store.roll.RollFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            RollFactory rollFactory = new RollFactory();
            List<Integer> rollKeys = new ArrayList<>();
            int originalRollCount = 0;  // keep track of original desire for number of rolls
            for(int i = 0; i < 5; i++) {
                originalRollCount += this.rollCount[i];
                rollKeys.add(i + 1);
            }


            // for each type of roll,
            for (int i = 0; i < 5; i++){
                int numDesired = this.rollCount[i];
                int currentRollType = i + 1;

                if (numDesired > 0){
                    int amountInStock = invent.getRollAmount(currentRollType);  // check stock of current roll type

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

            // keep adding rolls until we meet the original count or we cant add more
            for(int i = 0; i < rollKeys.size() && this.rolls.size() < originalRollCount; i++) {
                Integer type = rollKeys.get(i);

                int inStock = invent.getRollAmount(type);
                if (inStock >= originalRollCount - this.rolls.size()) {  // can use current roll type to fill to total
                    this.rolls.addAll(rollFactory.generateNRolls(type, originalRollCount - this.rolls.size()));
                } else if (inStock > 0 && inStock < originalRollCount - this.rolls.size()){  // cannot fill to total
                    this.rolls.addAll(rollFactory.generateNRolls(type, inStock));
                }

                this.setRolls(this.rolls);
            }

            if (this.rolls.size() > 0 && canFillOrder(invent)) {
                for (int i = 0; i < 5; i++) {
                    if (this.rollCount[i] > 0)  // only buy rolls we want
                        invent.buyRolls(i + 1, this.rollCount[i]);
                }
                return true;
            } else {
                return false;
            }
        }

    }
}

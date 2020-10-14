package store.roll;

import store.roll.RollDecorator.ExtraFilling;
import store.roll.RollDecorator.ExtraSauce;
import store.roll.RollDecorator.ExtraTopping;
import store.roll.subrolls.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//1 of the 3 Design Patterns for this Project
public class RollFactory {

    //creating new roll object based on type passed in
    private Roll generateRoll(int type) {
        Roll ret;
        if (type == 1) {
            ret = new SpringRoll();
        }
        else if (type == 2) {
            ret =  new EggRoll();
        }
        else if (type == 3) {
            ret = new SausageRoll();
        }
        else if (type == 4) {
            ret = new PastryRoll();
        }
        else {
            ret = new JellyRoll();
        }
        return extras(ret);
    }

    //handles the random chances of adding extras to each roll upon creation
    private Roll extras(Roll roll) {
        Random r = new Random();
        int sauce = r.nextInt(4) ;
        int filling  = r.nextInt(2);
        int toppings = r.nextInt(3);

        for (int i = 0; i < sauce; i++) {
            roll = new ExtraSauce(roll);
        }
        for (int i = 0; i < filling; i++) {
            roll = new ExtraFilling(roll);
        }
        for (int i = 0; i < toppings; i++) {
            roll = new ExtraTopping(roll);
        }
        return roll;
    }

    //prepares 1-3 rolls of randomly determined types
    public List<Roll> casualOrder() {
        Random r = new Random();
        int total = r.nextInt(3) + 1; //random number of rolls 1-3
        List<Roll> ret = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            int type = r.nextInt(5) + 1; //random type
            ret.add(generateRoll(type));
        }
        return ret;
    }

    //10 rolls total, 2 of each type
    public List<Roll>  businessOrder() {
        List<Roll> ret = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ret.add(generateRoll(i+1));
            ret.add(generateRoll(i+1));
        }
        return ret;
    }

    //5 rolls of 3 different types
    public List<Roll> caterOrder() {
        Random r = new Random();
        List<Integer> types = new ArrayList<>();
        List<Roll> ret = new ArrayList<>();
        while (types.size() < 3) {
            int type = r.nextInt(5) + 1; //random pick types
            if (types.contains(Integer.valueOf(type)) == false) {
                types.add(type);
                //this if condition is checking to see if the type has already been selected for this order
            }
        }

        //now that types are picked, we generate 5 of each of the 3 types
        for (Integer num: types) {
            ret.add(generateRoll(num.intValue()));
            ret.add(generateRoll(num.intValue()));
            ret.add(generateRoll(num.intValue()));
            ret.add(generateRoll(num.intValue()));
            ret.add(generateRoll(num.intValue()));
        }
        return ret;
    }

    //function to help easily generate N rolls given the type
    public List<Roll> generateNRolls(int type, int n) {
        List<Roll> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ret.add(generateRoll(type));
        }
        return ret;
    }
}

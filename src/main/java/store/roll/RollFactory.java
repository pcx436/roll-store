package store.roll;

import store.roll.RollDecorator.ExtraFilling;
import store.roll.RollDecorator.ExtraSauce;
import store.roll.RollDecorator.ExtraTopping;
import store.roll.subrolls.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RollFactory {

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


    public List<Roll> casualOrder() {
        Random r = new Random();
        int total = r.nextInt(3) + 1;
        List<Roll> ret = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            int type = r.nextInt(5) + 1;
            ret.add(generateRoll(type));
        }
        return ret;
    }

    public List<Roll>  businessOrder() {

    }

    public List<Roll> caterOrder() {

    }

    public List<Roll> generateNRolls(String type, int n) {

    }
}

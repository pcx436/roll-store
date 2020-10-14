package store.order;

import store.roll.RollFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderFactory {
    private final RollFactory rollFactory;

    public OrderFactory() {
        rollFactory = new RollFactory();
    }

    public List<Order> createOrders() {
        List<Order> ret = new ArrayList<>();
        Random r = new Random();

        int casualCount = r.nextInt(12) + 1;
        int businessCount = r.nextInt(3) + 1;
        int cateringCount = r.nextInt(3) + 1;
        int currentType;

        while (casualCount > 0 || businessCount > 0 || cateringCount > 0) {
            currentType = r.nextInt(3);

            // casual
            Order currentOrder;
            if (currentType == 0 && casualCount > 0) {
                currentOrder = new CasualOrder(rollFactory.casualOrder());
                casualCount--;
                ret.add(currentOrder);
            } else if (currentType == 1 && businessCount > 0) {
                currentOrder = new BusinessOrder(rollFactory.businessOrder());
                businessCount--;
                ret.add(currentOrder);
            } else if (currentType == 2 && cateringCount > 0) {
                currentOrder = new CateringOrder(rollFactory.caterOrder());
                cateringCount--;
                ret.add(currentOrder);
            }
        }
        
        return ret;
    }

}

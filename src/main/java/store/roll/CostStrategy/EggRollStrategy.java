package store.roll.CostStrategy;

public class EggRollStrategy implements CostStrategy {
//override cost of extras for given specific roll
    @Override
    public double getFillingCost() {
        return 0.70;
    }

    @Override
    public double getSauceCost() {
        return 0.40;
    }

    @Override
    public double getToppingCost() {
        return 3.50;
    }
}

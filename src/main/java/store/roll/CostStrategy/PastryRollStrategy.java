package store.roll.CostStrategy;

public class PastryRollStrategy implements CostStrategy {
    @Override
    public double getFillingCost() {
        return 1.51;
    }

    @Override
    public double getSauceCost() {
        return 7.93;
    }

    @Override
    public double getToppingCost() {
        return 81.42;
    }
}

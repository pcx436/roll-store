package store.roll.CostStrategy;

public class JellyRollStrategy implements CostStrategy {
    //override cost of extras for given specific roll
    @Override
    public double getFillingCost() {
        return 1.00;
    }

    @Override
    public double getSauceCost() {
        return 8.91;
    }

    @Override
    public double getToppingCost() {
        return 50.0;
    }
}

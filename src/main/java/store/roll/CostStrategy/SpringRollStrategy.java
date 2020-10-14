package store.roll.CostStrategy;

public class SpringRollStrategy implements CostStrategy {
    @Override
    public double getFillingCost() {
        return 3.33;
    }

    @Override
    public double getSauceCost() {
        return 4.44;
    }

    @Override
    public double getToppingCost() {
        return 5.55;
    }
}

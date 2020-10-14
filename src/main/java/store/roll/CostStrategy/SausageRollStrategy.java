package store.roll.CostStrategy;

public class SausageRollStrategy implements CostStrategy {
    //override cost of extras for given specific roll
    @Override
    public double getFillingCost() {
        return 0.01;
    }

    @Override
    public double getSauceCost() {
        return 0.02;
    }

    @Override
    public double getToppingCost() {
        return 0.03;
    }
}

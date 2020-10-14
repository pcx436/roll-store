package store.roll.CostStrategy;

//1 of 3 Distinct Design Patterns for this Project
//Used Strategy to handle different costs per extra for each different roll type
public interface CostStrategy {
    double getFillingCost();
    double getSauceCost();
    double getToppingCost();
}

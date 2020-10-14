package store;

public class Store {

    private static void printInventory(Inventory inventory) {
        System.out.println("The current inventory is as follows:");
        for(int i = 1; i <= 5; i++) {
            System.out.println("\t" + inventory.typeToString(i) + ": " + inventory.getRollAmount(i));
        }
    }

    public static void main(String[] args){

    }
}

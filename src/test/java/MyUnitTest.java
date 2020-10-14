import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import store.Inventory;
import store.roll.Roll;
import store.roll.RollFactory;

import java.util.List;

public class MyUnitTest {
    Inventory inventory;
    RollFactory rollFactory;

    @BeforeEach
    public void setup() {
        inventory = new Inventory();
        rollFactory = new RollFactory();
    }

    @Test
    public void testTypeToStringSpringRoll() {
        Assertions.assertEquals("spring roll", inventory.typeToString(1));
    }
    @Test
    public void testTypeToStringEggRoll() {
        Assertions.assertEquals("egg roll", inventory.typeToString(2));
    }
    @Test
    public void testTypeToStringSausageRoll() {
        Assertions.assertEquals("sausage roll", inventory.typeToString(3));
    }
    @Test
    public void testTypeToStringPastryRoll() {
        Assertions.assertEquals("pastry roll", inventory.typeToString(4));
    }
    @Test
    public void testTypeToStringJellyRoll() {
        Assertions.assertEquals("jelly roll", inventory.typeToString(5));
    }

    @Test
    public void testValidCatering() {
        List<Roll> rollList = rollFactory.caterOrder();

        // got 15 rolls
        Assertions.assertEquals(15, rollList.size());

        for (int i = 0; i < 5; i++) {
            Assertions.assertEquals(rollList.get(0).getType(), rollList.get(i).getType());
        }
        for (int i = 5; i < 10; i++) {
            Assertions.assertEquals(rollList.get(5).getType(), rollList.get(i).getType());
        }
        for (int i = 10; i < 15; i++) {
            Assertions.assertEquals(rollList.get(10).getType(), rollList.get(i).getType());
        }
    }
}

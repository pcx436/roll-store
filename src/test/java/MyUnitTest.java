import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import store.Inventory;

public class MyUnitTest {
    Inventory inventory;

    @BeforeEach
    public void setup() {
        inventory = new Inventory();
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
}

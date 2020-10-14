import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import store.Inventory;
import store.roll.Roll;
import store.roll.RollDecorator.ExtraFilling;
import store.roll.RollDecorator.ExtraSauce;
import store.roll.RollFactory;
import store.roll.subrolls.SausageRoll;
import store.roll.subrolls.SpringRoll;

import java.util.List;

public class MyUnitTest {
    Inventory inventory;
    RollFactory rollFactory;

    @BeforeEach
    public void setup() {
        inventory = new Inventory();
        rollFactory = new RollFactory();
    }

    //the following 5 tests are testing for outputs of the typeToString method
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

        // checking 15 rolls created
        Assertions.assertEquals(15, rollList.size());

        //asserting types of rolls in the list of rolls
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

    @Test
    public void testValidBusiness() {
        List<Roll> rollList = rollFactory.businessOrder();

        // checking 10 rolls created
        Assertions.assertEquals(10, rollList.size());
    }

    @Test
    public void testValidCasual() {
        List<Roll> rollList = rollFactory.casualOrder();

        //checking between 1 and 3 rolls were created as the casual customer wants
        Assertions.assertTrue(rollList.size() > 0 && rollList.size() < 4);
    }

    @Test
    public void testExtraSauce() {
        Roll r1 = new SpringRoll();
        r1 = new ExtraSauce(r1);
        Assertions.assertEquals("spring roll, with extra sauce", r1.getDescription());

        //testing both the descriptions of the spring roll and the decoration applying the extra sauce
    }

    @Test
    public void testExtraFilling() {
        Roll r2 = new SausageRoll();
        r2 = new ExtraFilling(r2);
        Assertions.assertEquals("sausage roll, with extra filling", r2.getDescription());

        //testing both the descriptions of the sausage roll and the decoration applying the extra filling
    }




}

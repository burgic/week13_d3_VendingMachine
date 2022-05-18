import Product.Crisps;
import Product.Drink;
import Product.Sweet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private Sweet chocolateBar;
    private Crisps crisps;
    private Drink drink;

    @Before
    public void before() {
        chocolateBar = new Sweet("lionBar", "Nestle");
        crisps = new Crisps("readySalted", "Walkers");
        drink = new Drink("irnBru", "Barr");
    }

    @Test
    public void hasName() {
        assertEquals("lionBar", chocolateBar.getName());
    }

    @Test
    public void hasBrand(){
        assertEquals("Walkers", crisps.getBrand());
    }

}

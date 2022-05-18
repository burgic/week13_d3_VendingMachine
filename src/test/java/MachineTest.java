import Coin.Coin;
import Coin.CoinReturn;
import Coin.CoinType;
import Machine.Drawer;
import Machine.ProductType;
import Machine.VendingMachine;
import Product.Crisps;
import Product.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MachineTest {

    private Drawer topDrawer, middleDrawer, bottomDrawer;
    private ArrayList<Drawer> listOfDrawers;
    private VendingMachine vendingMachine;
    private CoinReturn returnedCoins;
    private Crisps crisp1, crisp2, crisp3, crisp4;
    private Coin coin1, coin2, coin3, coin4, coin5, coin6;

    @Before
    public void before() {
        topDrawer = new Drawer(ProductType.C123);
        middleDrawer = new Drawer(ProductType.S123);
        bottomDrawer = new Drawer(ProductType.D123);
        crisp1 = new Crisps("readySalted", "Walkers");
        crisp2 = new Crisps("cheese and Onion", "Golden Wonder");
        crisp3 = new Crisps("BBQ", "KP");
        crisp4 = new Crisps("Prawn Cocktail", "Pringles");
        listOfDrawers = new ArrayList<>(Arrays.asList(topDrawer, middleDrawer, bottomDrawer));
        vendingMachine = new VendingMachine(listOfDrawers, returnedCoins);
        coin1 = new Coin(CoinType.ONEPENCE);
        coin2 = new Coin(CoinType.TWOPENCE);
        coin3 = new Coin(CoinType.ONEPOUND);
        coin4 = new Coin(CoinType.FIFTYPENCE);
        coin5 = new Coin(CoinType.TWENTYPENCE);
        coin6 = new Coin(CoinType.TENPENCE);

    }

    @Test
    public void hasProductType() {
        assertEquals(ProductType.C123, topDrawer.getDrawType());
    }

    @Test
    public void hasProductPrice() {
        assertEquals(0.60, topDrawer.getDrawType().getProductCost(), 0.0);
    }

    @Test
    public void canAddProduct() {
        topDrawer.addProduct(crisp1);
        assertEquals(Arrays.asList(crisp1), topDrawer.getProducts());
    }

    @Test
    public void canReturnProduct() {
        topDrawer.addProduct(crisp1);
        topDrawer.addProduct(crisp2);
        topDrawer.addProduct(crisp3);
        topDrawer.returnProduct(crisp2);
        assertEquals(Arrays.asList(crisp1, crisp3), topDrawer.getProducts());

    }

    @Test
    public void hasDrawers(){
        assertEquals(Arrays.asList(topDrawer, middleDrawer, bottomDrawer), vendingMachine.getDrawerList());
    }

    @Test
    public void canAddCoins(){
        vendingMachine.addCoin(coin1);
        vendingMachine.addCoin(coin2);
        vendingMachine.addCoin(coin3);
        vendingMachine.addCoin(coin4);
        vendingMachine.addCoin(coin5);
        assertEquals(Arrays.asList( coin3, coin4, coin5), vendingMachine.getCoinList());
    }

    @Test
    public void testCoinIsValid() {
        assertEquals(false, vendingMachine.isCoinValid(coin1));
        assertEquals(true, vendingMachine.isCoinValid(coin3));
    }

    @Test
    public void canBuyProduct() {
        topDrawer.addProduct(crisp1);
        topDrawer.addProduct(crisp2);
        topDrawer.addProduct(crisp3);
        vendingMachine.addCoin(coin1);
        vendingMachine.addCoin(coin2);
        vendingMachine.addCoin(coin3);
        vendingMachine.addCoin(coin4);
        vendingMachine.addCoin(coin5);
        Product boughtCrisps = vendingMachine.buyProduct(topDrawer.getDrawType());
        assertEquals(crisp1, boughtCrisps);
    }

    @Test
    public void canReturnCoins(){
        topDrawer.addProduct(crisp1);
        topDrawer.addProduct(crisp2);
        topDrawer.addProduct(crisp3);
        vendingMachine.addCoin(coin5);
        vendingMachine.addCoin(coin6);
        vendingMachine.buyProduct(topDrawer.getDrawType());
        assertEquals(Arrays.asList(coin5, coin6), vendingMachine.getReturnedCoins());

    }



}

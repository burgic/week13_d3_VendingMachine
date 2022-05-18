import Coin.Coin;
import Coin.CoinType;
import Coin.CoinReturn;
import org.junit.Before;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    private Coin coin1, coin2, coin3, coin4, coin5;
    private CoinReturn returnedCoins;

    @Before
    public void before() {
        coin1 = new Coin(CoinType.ONEPENCE);
        coin2 = new Coin(CoinType.TWOPENCE);
        coin3 = new Coin(CoinType.ONEPOUND);
        coin4 = new Coin(CoinType.FIFTYPENCE);
        coin5 = new Coin(CoinType.TWENTYPENCE);
        returnedCoins = new CoinReturn();
    }

    @Test
    public void canGetValue() {
        assertEquals(0.01, coin1.getValue(), 0.0);
    }

    @Test
    public void canAddCoin() {
        returnedCoins.addCoin(coin1);
        returnedCoins.addCoin(coin2);
        returnedCoins.addCoin(coin3);
        assertEquals(Arrays.asList(coin1, coin2, coin3), returnedCoins.getReturnCoins());
    }

    @Test
    public void canGetTotalAmount() {
        returnedCoins.addCoin(coin1);
        returnedCoins.addCoin(coin2);
        returnedCoins.addCoin(coin3);
        assertEquals(1.03, returnedCoins.calculateTotalAmount(), 0.0);
    }


}

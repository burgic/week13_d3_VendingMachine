package Coin;

import java.util.ArrayList;

public class CoinReturn {

    private ArrayList<Coin> returnCoins;

    public CoinReturn() {
        this.returnCoins = new ArrayList<>();
    }

    public ArrayList<Coin> getReturnCoins() {
        return returnCoins;
    }

    public void addCoin(Coin coin) {
        this.returnCoins.add(coin);
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (Coin coin: returnCoins){
            total += coin.getType().getValue();
        }


        return total;
    }


}

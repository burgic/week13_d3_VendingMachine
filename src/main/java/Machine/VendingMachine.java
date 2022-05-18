package Machine;

import Coin.Coin;
import Coin.CoinReturn;
import Product.Product;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawerList;
    private ArrayList<Coin> coinList;
    private CoinReturn returnedCoins;

    public VendingMachine(ArrayList<Drawer> drawerList, CoinReturn returnedCoins) {
        this.drawerList = drawerList;
        this.coinList = new ArrayList<>();
        this.returnedCoins = returnedCoins;
    }

    public ArrayList<Drawer> getDrawerList() {
        return drawerList;
    }

    public ArrayList<Coin> getCoinList() {
        return coinList;
    }

    public CoinReturn getReturnedCoins() {
        return returnedCoins;
    }

    public void addCoin(Coin coin) {
        if(isCoinValid(coin)) {
            coinList.add(coin);
        }
    }

    public boolean isCoinValid(Coin coin) {
        return coin.getType().isAcceptCoin();
    }

    public double calculateValueOfCoins(){
        double total = 0;
        for(Coin coin: coinList) {
            total += coin.getValue();
        }

        return total;
    }

    public Product buyProduct(ProductType productType){

        Product returnedProduct = null;

        for (Drawer drawer: drawerList){ // loop through all drawers
            if(drawer.getDrawType() == productType){ // does drawer code match code entered
                if (calculateValueOfCoins() >  productType.getProductCost()) { // value of coins more than product cost?
                    Product firstProduct = drawer.getProducts().get(0); // assign first product in product list to new variables
                    returnedProduct = drawer.returnProduct(firstProduct); // remove product from drawer and save it so we can return it to customer
                    clearCoinList();
                } // end second if
            } // end first if
        } // end for

        return returnedProduct;
    }

    public void clearCoinList(){
        coinList.clear();
    }

}

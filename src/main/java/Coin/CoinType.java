package Coin;

public enum CoinType {

    ONEPENCE(0.01, false),
    TWOPENCE(0.02, false),
    FIVEPENCE(0.05, false),
    TENPENCE(0.1, true),
    TWENTYPENCE(0.2, true),
    FIFTYPENCE(0.5, true),
    ONEPOUND(1, true),
    TWOPOUND(2, true);

    private final double value;
    private final boolean acceptCoin;

    CoinType(double value, boolean acceptCoin) {
        this.value = value;
        this.acceptCoin = acceptCoin;
    }

    public double getValue() {
        return value;
    }

    public boolean isAcceptCoin() {
        return acceptCoin;
    }
}

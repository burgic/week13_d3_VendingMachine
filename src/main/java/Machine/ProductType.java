package Machine;

public enum ProductType {

    S123(0.50),
    C123(0.60),
    D123(0.70);

    private double productCost;

    ProductType(double productCost) {
        this.productCost = productCost;
    }

    public double getProductCost() {
        return productCost;
    }
}

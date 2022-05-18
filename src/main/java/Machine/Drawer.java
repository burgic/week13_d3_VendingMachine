package Machine;

import Product.Product;

import java.sql.Array;
import java.util.ArrayList;

public class Drawer {

    private ProductType drawType;
    private ArrayList<Product> products;

    public Drawer(ProductType drawType) {
        this.drawType = drawType;
        this.products = new ArrayList<Product>();
    }

    public ProductType getDrawType() {
        return drawType;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product returnProduct(Product product) {
        int productIndex = products.indexOf(product);
        Product returnedProduct = products.remove(productIndex);
        return returnedProduct;
    }

}

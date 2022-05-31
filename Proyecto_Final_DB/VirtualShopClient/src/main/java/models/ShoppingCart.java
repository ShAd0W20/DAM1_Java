package models;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart {
    private ArrayList<ShoppingCartProduct> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public boolean addProductToCart(ShoppingCartProduct product) {
        if(!this.products.contains(product)) {
            this.products.add(product);
            return true;
        }
        return false;
    }

    public void modifyProductQuantity(String productName, int newQuantity) {

        HashMap<String, ShoppingCartProduct> mapper = new HashMap<>();

        for(ShoppingCartProduct product : this.products) {
            mapper.put(product.getProduct().getName(), product);
        }

        products.get(products.indexOf(mapper.get(productName))).setQuantity(newQuantity);
    }

    public ShoppingCartProduct searchProductInCartByName(String productName) {
        HashMap<String, ShoppingCartProduct> mapper = new HashMap<>();

        for(ShoppingCartProduct product : this.products) {
            mapper.put(product.getProduct().getName(), product);
        }

        return mapper.get(productName);
    }

    public ArrayList<ShoppingCartProduct> getAllProducts() {
        return this.products;
    }

}

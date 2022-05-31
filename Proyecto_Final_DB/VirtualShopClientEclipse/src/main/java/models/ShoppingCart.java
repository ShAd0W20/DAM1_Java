package main.java.models;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart {
	private ArrayList<ShoppingCartProduct> products;

	public ShoppingCart() {
		this.products = new ArrayList<>();
	}

	public boolean addProductToCart(ShoppingCartProduct product) {
		if (!this.products.contains(product)) {
			this.products.add(product);
			return true;
		}
		return false;
	}

	public void modifyProductQuantity(String productName, int newQuantity) {

		HashMap<String, ShoppingCartProduct> mapper = new HashMap<>();

		this.products.forEach(p -> mapper.put(p.getProduct().getName(), p));

		products.get(products.indexOf(mapper.get(productName))).setQuantity(newQuantity);
	}

	public ShoppingCartProduct searchProductInCartByName(String productName) {
		HashMap<String, ShoppingCartProduct> mapper = new HashMap<>();

		this.products.forEach(p -> mapper.put(p.getProduct().getName(), p));

		return mapper.get(productName);
	}

	public ArrayList<ShoppingCartProduct> getAllProducts() {
		return this.products;
	}

}

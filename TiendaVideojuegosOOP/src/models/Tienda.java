package models;

import java.util.ArrayList;
import java.util.HashMap;

public class Tienda {
	private ArrayList<Producto> products;
	private ArrayList<Producto> soltProducts;
	
	public Tienda() {
		this.products = new ArrayList<>();
		this.soltProducts = new ArrayList<>();
	}
	
	public boolean addProduct(Producto p) {
		if(findProductInShoop(p.getCode(), products) == null) {
			this.products.add(p);
			return true;
		}
		return false;
	}
	
	public boolean addStockToProduct(String productID, int productStock) {
		if(findProductInShoop(productID, products) != null) {
			findProductInShoop(productID, products).addStock(productStock);
			return true;
		}
		return false;
	}
	
	public boolean deleteProductFromShop(String productID) {
		if(findProductInShoop(productID, products) != null) {
			this.products.remove(findProductInShoop(productID, products));
			return true;
		}
		return false;
	}
	
	public String buyProduct(String productID) {
		if(findProductInShoop(productID, products) == null) {
			return "Product not found";
		}
		
		if(findProductInShoop(productID, products) != null) {
			if(findProductInShoop(productID, products).getStock() <= 0) {
				return "Product has no stock";
			} else {
				findProductInShoop(productID, products).addStock(-1);
			}
		}
		
		if(soltProducts.contains(findProductInShoop(productID, soltProducts))) {
			soltProducts.get(soltProducts.indexOf(findProductInShoop(productID, soltProducts))).addSells(1);
		} else {
			findProductInShoop(productID, products).addSells(1);
			soltProducts.add(findProductInShoop(productID, products));
		}
		
		return "";		
	}
	
	public ArrayList<Producto> listAllProducts() {
		return this.products;
	}
	
	public ArrayList<Producto> listSoltProducts() {
		return this.soltProducts;
	}
	
	private Producto findProductInShoop(String productID, ArrayList<Producto> products) {
		HashMap<String, Producto> mapper = new HashMap<>();
		
		for(Producto p : products) {
			mapper.put(p.getCode(), p);
		}
		
		return mapper.get(productID);
	}
}

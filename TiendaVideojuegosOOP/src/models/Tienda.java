package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Tienda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4227726431181889261L;
	private ArrayList<Producto> products;
	private ArrayList<Producto> soltProducts;
	
	public Tienda() {
		this.products = new ArrayList<>();
		this.soltProducts = new ArrayList<>();
	}
	
	public boolean addProduct(Producto p) {
		if(findProductInShoop(p.getCode(), this.products) == null) {
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
		if(findProductInShoop(productID, this.products) == null) {
			return "Product not found";
		}
		
		if(findProductInShoop(productID, this.products) != null) {
			if(findProductInShoop(productID, this.products).getStock() <= 0) {
				return "Product has no stock";
			} else {
				findProductInShoop(productID, this.products).addStock(-1);
			}
		}
		
		if(this.soltProducts.contains(findProductInShoop(productID, this.soltProducts))) {
			this.soltProducts.get(this.soltProducts.indexOf(findProductInShoop(productID, this.soltProducts))).addSells(1);
		} else {
			findProductInShoop(productID, this.products).addSells(1);
			this.soltProducts.add(findProductInShoop(productID, this.products));
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

package views;

import models.Producto;
import models.Tienda;

public class Edit {
	public static void addProduct(Tienda t) {
		t.addProduct(null);
	}
	
	public static void addStockToProduct(Tienda t) {
		t.addStockToProduct(null, 0);
	}
	
	public static void deleteProduct(Tienda t) {
		t.deleteProductFromShop(null);
	}
	
	public static void listAllProducts(Tienda t) {
		for(Producto p : t.listAllProducts()) {
			System.out.println(p.toString());
		}
	}
}

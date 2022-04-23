package views;

import models.Producto;
import models.Tienda;
import utils.ConsoleHelper;

public class Buy {
	public static void buyProduct(Tienda t) {
		listAllProducts(t);
		String productToBuy =  ConsoleHelper.readString("Introduce el codigo del producto a comprar: ");
		
		String isCompleted = t.buyProduct(productToBuy);
		if(isCompleted.isBlank()) {
			System.out.println("Compra completada");
		}
	}
	
	private static void listAllProducts(Tienda t) {
		for (Producto p : t.listAllProducts()) {
			System.out.println(p.toString());
		}
	}
}

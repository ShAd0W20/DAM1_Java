package mainapp;

import java.util.Scanner;

public class MainApp {

	final static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String[] begudes = { "Cocacola", "Fanta", "Cafe", "Te", "Trina", "Nestea" };
		double[] preuBegudes = { 1.5, 0.5, 0.8, 2.5, 1.25, 1.75 };
		int[] stockBegudes = { 3, 6, 7, 2, 1, 9 };

		maquinaExpendedora(begudes, preuBegudes, stockBegudes);

	}

	static void maquinaExpendedora(String[] bebidas, double[] precios, int[] stockBebidas) {
		while (true) {
			String menuOption = "";
			double givenCoins;
			System.out.println(mostrarProductes(bebidas, precios, stockBebidas));
			System.out.println("Seleccione el nombre del producto");
			menuOption = input.nextLine();

			if(comprovarExistencies(menuOption, bebidas, stockBebidas) > 0) {
				System.out.println(String.valueOf(buscarPreu(menuOption, bebidas, precios)) + "€");
				System.out.println("Introduce la cantidad a pagar");
				givenCoins = input.nextDouble();
				input.nextLine();
				
				if(givenCoins >= buscarPreu(menuOption, bebidas, precios)) {
					if(tornarCanvi(givenCoins, buscarPreu(menuOption, bebidas, precios)) > 0) {						
						System.out.println("Aqui tiene su canvio \n" + String.valueOf(tornarCanvi(givenCoins, buscarPreu(menuOption, bebidas, precios))) + "€ \n");
					} else {
						System.out.println("Precio exacto. Gracias!");
					}
					actualitzarStock(menuOption, bebidas, stockBebidas);
				} else {
					System.out.println("Pago insuficiente");
				}
			} else {
				System.out.println("Producto agotado");
			}
			
			System.out.println("Pulse enter para volver al menu");
			input.nextLine();
		}
	}

	static String mostrarProductes(String[] bebidas, double[] precios, int[] stockBebidas) {
		String menu = "";
		for (int i = 0; i < bebidas.length; i++) {
			if(stockBebidas[i] <= 0) {
				menu += "[" + (i + 1) + "] " + bebidas[i] + " -> Prodcuto agotado" ; 				
			} else {
				menu += "[" + (i + 1) + "] " + bebidas[i] + " -> " + precios[i] + "€" + "\n";
			}
		}
		return menu;
	}

	static int comprovarExistencies(String bebidaToSearch, String[] bebidas, int[] stockBebidas) {
		int i = 0;

		while (!bebidaToSearch.equalsIgnoreCase(bebidas[i]) && i < bebidas.length) {
			i++;
		}

		if (!bebidaToSearch.equalsIgnoreCase(bebidas[i])) {
			return 0;
		}
		return stockBebidas[i];
	}
	
	static double buscarPreu(String bebidaToSearch, String[] bebidas, double[] precios) {
		int i = 0;
		while (!bebidaToSearch.equalsIgnoreCase(bebidas[i]) && i < bebidas.length) {
			i++;
		}

		if (!bebidaToSearch.equalsIgnoreCase(bebidas[i])) {
			return 0;
		}
		return precios[i];
	}

	static double tornarCanvi(double pagament, double preuProducte) {
		if(pagament < preuProducte) {
			return 0;
		}
		return pagament - preuProducte;
	}
	
	static void actualitzarStock(String producte, String[] bebidas, int[] stockBebidas) {
		int i = 0;
		while (!producte.equalsIgnoreCase(bebidas[i]) && i < bebidas.length) {
			i++;
		}

		if (producte.equalsIgnoreCase(bebidas[i])) {
			stockBebidas[i]--;
		}
		
	}
	
}

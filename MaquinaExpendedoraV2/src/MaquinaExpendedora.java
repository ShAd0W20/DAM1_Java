import java.util.Scanner;

public class MaquinaExpendedora {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		final int MAX_PRODCUTS_IN_MACHINE = 10;
		final String STOCK_MANAGER_PASSWORD = "DAM1";

		String[] productName = new String[MAX_PRODCUTS_IN_MACHINE];
		int[] productPrice = new int[MAX_PRODCUTS_IN_MACHINE];
		int[] productStock = new int[MAX_PRODCUTS_IN_MACHINE];
		int[] productSells = new int[MAX_PRODCUTS_IN_MACHINE];

		int availableProductsInMachine = 5;


		productName[0] = "Coca Cola"; productPrice[0] = 150; productStock[0] = 4;
		productName[1] = "Fanta"; productPrice[1] = 200; productStock[1] = 10;
		productName[2] = "Trina"; productPrice[2] = 70; productStock[2] = 2;
		productName[3] = "Nestea"; productPrice[3] = 125; productStock[3] = 15; 
		productName[4] = "Coffee"; productPrice[4] = 175; productStock[4] = 8;
		
		
		clientMenu(productName, productPrice, productStock, productSells, availableProductsInMachine);
	}

	static void clientMenu(String[] productName, int[] productPrice, int[] productStock, int[] productSells, int availableProductsInMachine) {
		int userSelectedProduct = 0;
		int totalToPay = 0;
		
		productsMenu(productName, productPrice, productStock, availableProductsInMachine);
		
		userSelectedProduct = input.nextInt() - 1;
		input.nextLine();
		
		totalToPay = productPrice[userSelectedProduct];
		
		productsPayment(productName, productPrice, productStock, productSells, availableProductsInMachine, userSelectedProduct, totalToPay);

	}

	static void productsMenu(String[] productName, int[] productPrice, int[] productStock, int availableProductsInMachine) {
		for(int i = 0; i < availableProductsInMachine; i++) {
			if(productStock[i] != 0) {
				System.out.println("[" + (i + 1) + "] Producto: " + productName[i] + " -> " + (productPrice[i] / 100) + "," + (productPrice[i] % 100) + "€");
			}
		}
	}
	
	static void productsPayment(String[] productName, int[] productPrice, int[] productStock, int[] productSells, int availableProductsInMachine, int userSelectedProduct, int totalToPay) {
		int[] validCoins = { 200, 100, 50, 20, 10, 5 };
		String[] userInsertedCoins = new String[6];
		
		System.out.println("Ha seleccionado " + productName[userSelectedProduct] + ", y tiene que pagar: " + calculateProductPrice(productPrice, userSelectedProduct));
		
		System.out.println("Con que monedas desea pagar, seleccione las monedas con la cantidad separada por '-'");
		for (int i = 0; i < validCoins.length; i++) {
			System.out.print((validCoins[i] / 100) + "," + (validCoins[i] % 100) + "  ");
		}
		System.out.println();
		
		userInsertedCoins = input.nextLine().split("-");
		System.out.println(calculateChange(productName, productPrice, productStock, productSells, userInsertedCoins, userSelectedProduct, validCoins, totalToPay));
	}
	
	static String calculateChange(String[] productName, int[] productPrice, int[] productStock, int[] productSells, String[] userInsertedCoins, int userSelectedProduct, int[] validCoins, int totalToPay) {
		
		for (int i = 0; i < validCoins.length; i++) {
			if (!userInsertedCoins[i].equals("0")) {
				totalToPay -= (validCoins[i] * Integer.parseInt(userInsertedCoins[i]));
			}
		}
		if(totalToPay > 0) {
			 return "Te falta por pagar: " + (totalToPay / 100) + "," + (totalToPay % 100) + "€ \nCon que monedas desea pagar, seleccione las monedas con la cantidad separada por '-'";
		}
		else if (totalToPay == 0) {
			productStock[userSelectedProduct]--;
			productSells[userSelectedProduct]++;
			totalToPay = 0;
			return "Gracias por tu compra, has pagado justo";
		}
		else {
			productStock[userSelectedProduct]--;
			productSells[userSelectedProduct]++;
			totalToPay = 0;
			return "Has pagado de mas aquí tienes tu cambio: " + (((totalToPay + (totalToPay * -2)) / 100)) + "," + (((totalToPay + (totalToPay * -2)) % 100)) + "€";
		}
	}
	
	static String calculateProductPrice(int[] productPrice, int productSelected) {
		return (productPrice[productSelected] / 100) + "," + (productPrice[productSelected] % 100) + "€";
	}
}

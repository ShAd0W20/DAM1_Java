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


		productName[0] = "Coca Cola"; productPrice[0] = 150; productStock[0] = 4; productSells[0] = 6;
		productName[1] = "Fanta"; productPrice[1] = 200; productStock[1] = 10;
		productName[2] = "Trina"; productPrice[2] = 70; productStock[2] = 2; productSells[2] = 4;
		productName[3] = "Nestea"; productPrice[3] = 125; productStock[3] = 15; 
		productName[4] = "Coffee"; productPrice[4] = 175; productStock[4] = 8;
		
		mainMenu(productName, productPrice, productStock, productSells, availableProductsInMachine, STOCK_MANAGER_PASSWORD);
		
		System.out.println("Has salido del programa");
	}

	/*Main menu method used to control all the main programs as well as the sub menus (client menu and manager menu)*/
	static void mainMenu(String[] productName, int[] productPrice, int[] productStock, int[] productSells, int availableProductsInMachine, String STOCK_MANAGER_PASSWORD) {
		String mainMenuOption = "";
		String passwordEntered = "";
		System.out.println("[1] Para menu cliente \n[2] Menu gesti�n \n['Salir'] Para salir del programa");
		do {
			mainMenuOption = input.nextLine();
			switch(mainMenuOption) {
			case "1":
				clientMenu(productName, productPrice, productStock, productSells, availableProductsInMachine);
				break;
			case "2":
				System.out.println("Introduce la contrase�a para entrar");
				passwordEntered = input.nextLine();
				
				if(passwordEntered.equals(STOCK_MANAGER_PASSWORD)) { //if password entered equals password defined in the beginning of the program enter to managerMenu
					managerMenu(productName, productPrice, productStock, productSells, availableProductsInMachine);
				} else {
					System.out.println("Contrase�a incorrecta. Pulse 'enter' para volver al menu");
				}
				break;
			default:
				if(!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.println("[1] Para menu cliente \n[2] Menu gesti�n \n['Salir'] Para salir del programa");
				}
			}
			
		} while(!mainMenuOption.equalsIgnoreCase("salir"));
	}
	
	/*Lineal menu to buy 1 product*/
	static void clientMenu(String[] productName, int[] productPrice, int[] productStock, int[] productSells, int availableProductsInMachine) {
		int userSelectedProduct = 0;
		int totalToPay = 0;
		
		productsMenu(productName, productPrice, productStock, availableProductsInMachine); //Call a method that will display all the available products
		
		System.out.println("Que producto desea? Seleccione el numero del producto para continuar");
		userSelectedProduct = input.nextInt() - 1; //Select the product ID and subtracts it 1 in order to be the same index as the index in the array
		input.nextLine();
		
		totalToPay = productPrice[userSelectedProduct]; // Initializes the total to pay by getting the information from the array
		
		productsPayment(productName, productPrice, productStock, productSells, availableProductsInMachine, userSelectedProduct, totalToPay); //Call the payment method

	}

	/*Method to display all available products*/
	static void productsMenu(String[] productName, int[] productPrice, int[] productStock, int availableProductsInMachine) {
		for(int i = 0; i < availableProductsInMachine; i++) {
			if(productStock[i] != 0) {
				System.out.println("[" + (i + 1) + "] Producto: " + productName[i] + " -> " + (productPrice[i] / 100) + "," + (productPrice[i] % 100) + "�");
			}
		}
	}
	
	/*Method to control the user payment as well as the change to give back*/
	static void productsPayment(String[] productName, int[] productPrice, int[] productStock, int[] productSells, int availableProductsInMachine, int userSelectedProduct, int totalToPay) {
		int[] validCoins = { 200, 100, 50, 20, 10, 5 }; //array of permitted coins
		String[] userInsertedCoins = new String[6]; //array to save the user inserted coins
		
		System.out.println("Ha seleccionado " + productName[userSelectedProduct] + ", y tiene que pagar: " + calculateProductPrice(productPrice, userSelectedProduct));
		
		System.out.println("Con que monedas desea pagar, seleccione las monedas con la cantidad separada por '-'");
		for (int i = 0; i < validCoins.length; i++) {
			System.out.print((validCoins[i] / 100) + "," + (validCoins[i] % 100) + "  ");
		}
		System.out.println();
		
		userInsertedCoins = input.nextLine().split("-");
		System.out.println(calculateChange(productName, productPrice, productStock, productSells, userInsertedCoins, userSelectedProduct, validCoins, totalToPay)); //Call method to calculate the change to give back
	}
	
	/*Function used to calculate the change to give back and to subtract stock of the selected product and plus 1 to product sells*/
	static String calculateChange(String[] productName, int[] productPrice, int[] productStock, int[] productSells, String[] userInsertedCoins, int userSelectedProduct, int[] validCoins, int totalToPay) {
		
		/*For loop to subtract the amount payed to the total to pay*/
		for (int i = 0; i < validCoins.length; i++) {
			if (!userInsertedCoins[i].equals("0")) {
				totalToPay -= (validCoins[i] * Integer.parseInt(userInsertedCoins[i])); //subtract to total to pay the amount of coins we have entered
			}
		}
		if(totalToPay > 0) {
			 return "Te falta por pagar: " + (totalToPay / 100) + "," + (totalToPay % 100) + "� \nCon que monedas desea pagar, seleccione las monedas con la cantidad separada por '-'";
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
			return "Has pagado de mas aqu� tienes tu cambio: " + (((totalToPay + (totalToPay * -2)) / 100)) + "," + (((totalToPay + (totalToPay * -2)) % 100)) + "�";
		}
	}
	
	/*Functions used to calculate the product price and return it as a String. Example: '2,50�'*/
	static String calculateProductPrice(int[] productPrice, int productSelected) {
		return (productPrice[productSelected] / 100) + "," + (productPrice[productSelected] % 100) + "�";
	}

	/*Method that controls the manager menu*/
	static void managerMenu(String[] productName, int[] productPrice, int[] productStock, int[] productSells, int availableProductsInMachine) {
		String managerMenuOption = "";
		System.out.println("[1] Para menu stock \n[2] Menu repostar producto \n[3] Menu recaptaci�n diaria \n[4] Menu reset recapcati�n \n['Salir'] Para salir del programa");
		do {
			managerMenuOption = input.nextLine();
			switch(managerMenuOption) {
			case "1":
				managerProductStock(productName, productStock, availableProductsInMachine);
				break;
			case "2":
				managerReStockProduct(productName, productStock, availableProductsInMachine);
				break;
			case "3":
				managerProductSells(productName, productPrice, productSells, availableProductsInMachine);
				break;
			case "4":
				managerSellsReset(productSells, availableProductsInMachine);
				break;
			default:
				if(!managerMenuOption.equalsIgnoreCase("salir")) {
					System.out.println("[1] Para menu stock \n[2] Menu repostar producto \n[3] Menu recaptaci�n diaria \n[4] Menu reset recapcati�n \n['Salir'] Para salir del programa");
				}
			}
		}while(!managerMenuOption.equalsIgnoreCase("salir"));
	}
	
	/*Method that will display all products and their stock*/
	static void managerProductStock(String[] productName, int[] productStock, int availableProductsInMachine) {
		for(int i = 0; i < availableProductsInMachine; i++) {
			System.out.println("[" + (i + 1) + "] Producto: " + productName[i] + " -> " + productStock[i] + " unidades");
		}
	}
	
	/*Method to re-stock a product*/
	static void managerReStockProduct(String[] productName, int[] productStock, int availableProductsInMachine) {
		int productToUpdate = 0;
		int productNewStock = 0;
		
		/*Call the method to print the actual stock of the products*/
		managerProductStock(productName, productStock, availableProductsInMachine);
		
		System.out.println("Que producto desea acutalizar. Introduce el numero del producto");
		
		productToUpdate = input.nextInt() - 1; //get the product manager want's to update
		input.nextLine();
		
		/*Ask how many products want's to put in*/
		System.out.println("Ha seleccionado: " + productName[productToUpdate] + "\nQue cantidad desea a�adir?");
		productNewStock = input.nextInt();
		input.nextLine();
		
		/*Add the selected amount of products to the array of stock*/
		productStock[productToUpdate] += productNewStock;
		
		System.out.println("Ha introducido " + productNewStock + " al producto: " + productName[productToUpdate]);
	}
	
	/*Method to print how many products has sold as well as the total gained with all products*/
	static void managerProductSells(String[] productName, int[] productPrice, int[] productSells, int availableProductsInMachine) {
		int totalGained = 0;
		for(int i = 0; i < availableProductsInMachine; i++) {
			System.out.println("[" + (i + 1) + "] " + productName[i] + " -> " + productSells[i] + " Recaudado: " + ((productPrice[i] * productSells[i]) / 100) + "," + ((productPrice[i] * productSells[i]) % 100) + "�");
			totalGained += (productPrice[i] * productSells[i]); //plus the total gained with the diferent products
		}
		System.out.println("\nTOTAL GANADO: " + (totalGained / 100) + "," + (totalGained % 100) + "�");
		
		System.out.println("\nPulse enter para volver al menu");
	}
	
	/*Method to put all sells to 0*/
	static void managerSellsReset(int[] productSells, int availableProductsInMachine) {
		for(int i = 0; i < availableProductsInMachine; i++) {
			productSells[i] = 0;
		}
		System.out.println("Todos los productos reseteados. \nPulse enter para volver al menu");
	}
}

import java.util.Scanner;

public class Maquina_Expendedora {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Variables region 
			
			final int MAX_PRODCUTS_IN_MACHINE = 10;
			final String STOCK_MANAGER_PASSWORD = "SukaBlyat";
			
			String[] productName = new String[MAX_PRODCUTS_IN_MACHINE];
			int[] productPrice = new int[MAX_PRODCUTS_IN_MACHINE];
			int[] productStock = new int[MAX_PRODCUTS_IN_MACHINE];
			
			int availableProductsInMachine = 5;
			
			String[] validCoins = {"200", "100", "50", "20", "10", "5"};
			
			productName[0] = "Coca Cola"; productPrice[0] = 150; productStock[0] = 4;
			productName[1] = "Fanta"; productPrice[1] = 200; productStock[1] = 10;
			productName[2] = "Trina"; productPrice[2] = 70; productStock[2] = 2;
			productName[3] = "Nestea"; productPrice[3] = 125; productStock[3] = 15;
			productName[4] = "Coffee"; productPrice[4] = 150; productStock[4] = 8;
			
			String[] userInsertedCoins = new String[6];
			int userSelectedProduct = 0;
			int totalToPay = 0;
			
			String mainMenuOption = "";
			String subMenuOption = "";
			String enteredPassword = "";
			int stockManagerProductSearch = 0;
			int updateStockValue = 0;
		//End region
		
		System.out.println("1) Menu Cliente \n2) Menu Gestión \n'Salir') Para salir de programa");
		
		do {
			mainMenuOption = input.nextLine();
			
			switch (mainMenuOption) {
				case "1":					
					do {
						for (int i = 0; i < availableProductsInMachine; i++) {
							System.out.println((i + 1) + ") " + productName[i] + " - " + (productPrice[i] / 100) + "," + (productPrice[i] % 100) + "€");
						}
						
						userSelectedProduct = input.nextInt();
						input.nextLine();
					} while (userSelectedProduct > availableProductsInMachine || userSelectedProduct <= 0);
					
					totalToPay = productPrice[userSelectedProduct - 1];
					
					System.out.println("Ha seleccionado " +  productName[userSelectedProduct - 1] + ", y tiene que pagar: " + (productPrice[userSelectedProduct - 1] / 100) + "," + (productPrice[userSelectedProduct - 1] % 100) + "€");
					System.out.println("Con que monedas desea pagar, seleccione las monedas con la cantidad separada por '-'");
					for(int i = 0; i < validCoins.length; i++) {
						System.out.print((Integer.parseInt(validCoins[i]) / 100) + "," + (Integer.parseInt(validCoins[i]) % 100) + " - ");
					}
					System.out.println();
					do {
						userInsertedCoins = input.nextLine().split("-");
						
						for (int i = 0; i < validCoins.length; i++) {
							if (!userInsertedCoins[i].equals("0")) {
								totalToPay -= (Integer.parseInt(validCoins[i]) * Integer.parseInt(userInsertedCoins[i]));
							}
						}
						if(totalToPay > 0) {
							System.out.println("Te falta por pagar: " + (totalToPay / 100) + "," + (totalToPay % 100) + "€ \nCon que monedas desea pagar, seleccione las monedas con la cantidad separada por '-'");
						}
						if(totalToPay < 0) {
							System.out.println("Has pagado de mas aquí tienes tu cambio: " + (((totalToPay + (totalToPay * -2)) / 100)) + "," + (((totalToPay + (totalToPay * -2)) % 100)) + "€");
						}
					} while (totalToPay >= 0);
					
					productStock[userSelectedProduct]--;
					
					System.out.println("Presiona enter para volver al menu");					
					
					break;
					
				case "2":
					System.out.println("Introduce la contraseña");
					enteredPassword = input.nextLine();
					if(enteredPassword.equals(STOCK_MANAGER_PASSWORD)) {
						System.out.println("1) Mira el stock de los productos \n2) Augmenta el stock de los productos \n 'Salir') Para salir al menu principal");
						do {
							subMenuOption = input.nextLine();
							
							switch (subMenuOption) {
								case "1":
									for(int i = 0; i < availableProductsInMachine; i++) {
										System.out.println(productName[i] + " -> " + productStock[i]);
									}
									break;
								case "2":
									do {
										for (int i = 0; i < availableProductsInMachine; i++) {
											System.out.println((i + 1) + ") " + productName[i] + " -> " + productStock[i]);
										}
										stockManagerProductSearch = input.nextInt();
										input.nextLine();
									} while (stockManagerProductSearch > availableProductsInMachine || stockManagerProductSearch <= 0);
									
									System.out.println("Cuantas unidades desea añadir del producto: " + productName[stockManagerProductSearch - 1] + " actualmente tiene: " + productStock[stockManagerProductSearch - 1]);
									updateStockValue = input.nextInt();
									input.nextLine();
									
									productStock[stockManagerProductSearch - 1] += updateStockValue;
									
									System.out.println("Producto actualizado: " + productName[stockManagerProductSearch - 1] + " actualmente tiene: " + productStock[stockManagerProductSearch - 1] + "\nPulsa enter para salir al menu");
									
									break;
								default:
									if(!subMenuOption.equalsIgnoreCase("salir")) {
										System.out.println("1) Mira el stock de los productos \n2) Augmenta el stock de los productos \n 'Salir') Para salir al menu principal");
									}
							}
							
						} while(!subMenuOption.equalsIgnoreCase("salir"));
					} else {
						System.out.println("Password incorrecta");
					}
					System.out.println("Presiona enter para volver al menu");
					break;
				
				default: 
					if(!mainMenuOption.equalsIgnoreCase("salir")) {
						System.out.println("1) Menu Cliente \n2) Menu Gestión \n'Salir') Para salir de programa");
					}
			}
			
		} while (!mainMenuOption.equalsIgnoreCase("salir"));
		
		input.close();
		System.out.println("Has salido del programa");
	}

}

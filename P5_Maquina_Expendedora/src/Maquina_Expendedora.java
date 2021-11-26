import java.util.Scanner;

public class Maquina_Expendedora {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
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
					
					totalToPay = productPrice[userSelectedProduct];
					System.out.println("Ha seleccionado " +  productName[userSelectedProduct - 1] + ", y tiene que pagar: " + (productPrice[userSelectedProduct - 1] / 100) + "," + (productPrice[userSelectedProduct - 1] % 100) + "€");
					System.out.println("Con que monedas desea pagar, seleccione las monedas con la cantidad separada por '-'");
					for(int i = 0; i < validCoins.length; i++) {
						System.out.print((Integer.parseInt(validCoins[i]) / 100) + "," + (Integer.parseInt(validCoins[i]) % 100) + " - ");
					}
					System.out.println("");
					
					userInsertedCoins = input.nextLine().split("-");
					
					for (int i = 0; i < validCoins.length; i++) {
						if (validCoins[i].equals(userInsertedCoins[i])) {
							if (!userInsertedCoins[i].equals("0")) {
								totalToPay -= (Integer.parseInt(validCoins[i]) * Integer.parseInt(userInsertedCoins[i]));
							}
						}
					}
					System.out.println(totalToPay);
					
					break;
					
				case "2":
					System.out.println("1) Menu Cliente \n 2) Menu Gestión \n 'Salir') Para salir al menu principal");
					do {
						subMenuOption = input.nextLine();
						
						switch (subMenuOption) {
						case "1":
							
							break;
						}
						
					} while(!subMenuOption.equalsIgnoreCase("salir"));
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

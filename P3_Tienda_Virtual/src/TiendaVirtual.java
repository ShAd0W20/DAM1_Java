import java.util.Random;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class TiendaVirtual {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rnd = new Random();

		final int MAX_PRODUCTS = 10;

		String[] availableProductName = new String[MAX_PRODUCTS];
		double[] availableProductPrice = new double[MAX_PRODUCTS];
		int[] availableProductQuantity = new int[MAX_PRODUCTS];

		int totalAvailableProducts = 5;
		
		String mainMenuOption = "";
		String subMenuOption = "";
		char userChangeMenuOption = '0';
		
		String password = "";
		String productNameToModify = "";
		String productoToDelete = "";
		int productIndexToDelete = 0;
		
		String productNameSortChange = "";
		double productPriceSortChange = 0;
		int productQuantitySortChange = 0; 
		int compareProductName;
		
		String[] invoiceDateText = new String[3];
		int[] invoiceNumberDate = new int[3];
		
		int invoiceID = rnd.nextInt(1000);		
		LocalDate invoiceDate = LocalDate.of(1940, 1, 1);
		String clientDNIToCheck = "";
		String clientDNINumbers = "";
		int clientDNI;
		boolean validClientDNI = false;
		String clientName = "";
		
		
		double IVA = 0.21;
		double totalPrice = 0;
		double totalPriceIVA = 0;
		
		String clientProductListOption = "";
		int clientProductListQuantity = 0;
		
		String[] clientProductList = new String[MAX_PRODUCTS];
		int[] clientProductQuantity = new int[MAX_PRODUCTS];
		double[] clientProductPrice = new double[MAX_PRODUCTS];
		double[] clientProductUnitaryPrice = new double[MAX_PRODUCTS];
		
		char[] posbileDNILetters = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
		

		
		availableProductName[0] = "Pera"; availableProductPrice[0] = 0.99; availableProductQuantity[0] = 2;
		availableProductName[1] = "Poma"; availableProductPrice[1] = 1.99; availableProductQuantity[1] = 3;
		availableProductName[2] = "Banana"; availableProductPrice[2] = 2.99; availableProductQuantity[2] = 10;
		availableProductName[3] = "Pi�a"; availableProductPrice[3] = 3.99; availableProductQuantity[3] = 5;
		availableProductName[4] = "Malacatonen"; availableProductPrice[4] = 1.23; availableProductQuantity[4] = 7;
		
		System.out.println("Que desea hacer? \n 1: Gestion de productos \n 2: Ventas \n 'Salir': para salir del programa");
		
		do {
			mainMenuOption = input.nextLine();
			switch(mainMenuOption) {
				case "1":
					System.out.println("Introduce la contrase�a para poder entrar");
					do {
						password = input.nextLine();
						if(!password.equals("DaM1")) {
							System.out.println("Introduce la contrase�a para poder entrar");
						}
					} while(!password.equals("DaM1"));
					
					System.out.println("Que desea hacer? \n A: Registrar producto \n B: Modificar producto \n C: Borrar un producto \n D: Listar por nombre \n E: Listar por precio \n 'Salir' para salir al menu principal");
					do {
						subMenuOption = input.nextLine();
						switch(subMenuOption) {
							case "A":
								System.out.println("Introduce el nombre del nuevo producto");
								availableProductName[totalAvailableProducts] = input.nextLine();
								
								System.out.println("Introduce el precio del producto");
								availableProductPrice[totalAvailableProducts] = input.nextDouble();
								input.nextLine();
								
								System.out.println("Introduce el stock del producto");
								availableProductQuantity[totalAvailableProducts] = input.nextInt();
								input.nextLine();
								
								System.out.println(availableProductName[totalAvailableProducts] + " - " + availableProductPrice[totalAvailableProducts] + " - " + availableProductQuantity[totalAvailableProducts] + " : Producto guardado"); // print product data stored into the arrays
								
								totalAvailableProducts++; // plus 1 to totalAvailableProducts
								System.out.println("\n Actualmente tienes " + totalAvailableProducts + " productos guardados \n\n Pulse enter para salir al menu."); // print the total products stored
								
								break;
							case "B":
								System.out.println("Introduce el nombre del producto a modificar"); //ask user what product whant's to change
								productNameToModify = input.nextLine(); //store user input into the variable
								
								int i = 0; // integer used to know array index equals to user input
								while(!productNameToModify.equals(availableProductName[i]) && i < totalAvailableProducts) {// loop throw total products in array while user input not equals game name					
									i++;
								}
								if(productNameToModify.equals(availableProductName[i])) { // if finds product name equals to user input do:
									
									System.out.println("Que valor quieres modificar? \n 1: Precio \n 2: Stock"); // ask what value to change
									
									userChangeMenuOption = input.nextLine().charAt(0); // store user input into the variable
									
									switch(userChangeMenuOption) { // switch between user input value
										case '1': // case user input == 1 change product price
											System.out.println("Introduce el nuevo precio para " + availableProductName[i] + " actualmente con precio: " + availableProductPrice[i]); // ask the new price for the game
											availableProductPrice[i] = input.nextDouble(); // store the new price into gamePrice array with index of the gameName
											input.nextLine();
											
											break;
										case '2': // case user input == 2 change product stock
											System.out.println("Introduce el nuevo stock para " + availableProductName[i] + " actualmente hay " + availableProductQuantity[i]); // ask the new stock for the product
											availableProductQuantity[i] = input.nextInt(); // store user input product stock to array
											input.nextLine();											
											break;
									}
									
									System.out.println(availableProductName[i] + " " + availableProductPrice[i] + " " + availableProductQuantity[i] + " : Producto actualizado \n Pulse enter para salir la menu"); // print the new values of the game	
								} else {
									System.out.println("El producto " + productNameToModify + " no existe \n Pulse enter para salir al menu."); // if user input a non existing product print product does not exists
								}
								break;
							case "C":
								if(totalAvailableProducts > 0) { //don't enter this menu if we don't have any product registered in the array
									System.out.println("Que producto desea borrar? Introduce su nombre"); //ask for product name we want to delete
									
									productoToDelete = input.nextLine(); //save product name we want to delete into variable
									
									while(!productoToDelete.equals(availableProductName[productIndexToDelete]) && productIndexToDelete < totalAvailableProducts) { //search into the productName array for the name entered before	
										productIndexToDelete++; // while name entered not equals 1 value of the array continue searching
									}
									
									if(productoToDelete.equals(availableProductName[productIndexToDelete])) { //if user input equals 1 name into the array
										for(int j = productIndexToDelete; j < totalAvailableProducts - 1; j++) { // for loop to delete the user we specified and reorder all arrays
											availableProductName[j] = availableProductName[j + 1]; //move positions to reorder the array
											availableProductPrice[j] = availableProductPrice[j + 1];
											availableProductQuantity[j] = availableProductQuantity[j + 1];
										}
										totalAvailableProducts--; //delete 1 to total products in the array
										System.out.println("Producto eliminado \n Pulse enter para salir al menu.");
									} else {
										System.out.println("El producto no existe \n Pulse enter para salir al menu.");
									}
								} else {
									System.out.println("Aun no se ha registrado ning�n producto");
								}
								break;
							case "D":
								for (int l = 0; l < totalAvailableProducts - 1; l++) { //Order by name
									
									for (int j = l + 1; j < totalAvailableProducts; j++) {
										
										compareProductName = availableProductName[l].compareTo(availableProductName[j]);
										if (compareProductName > 0) {
											
											productPriceSortChange = availableProductPrice[l];
											
											availableProductPrice[l] = availableProductPrice[j];
											
											availableProductPrice[j] = productPriceSortChange;
											
											productQuantitySortChange = availableProductQuantity[l];
											
											availableProductQuantity[l] = availableProductQuantity[j];
											
											availableProductQuantity[j] = productQuantitySortChange;

											productNameSortChange = availableProductName[l];
											
											availableProductName[l] = availableProductName[j];
											
											availableProductName[j] = productNameSortChange;
										}
									}
								}
								
								for (int k = 0; k < totalAvailableProducts - 1; k++) {
									System.out.println(availableProductName[k] + " " + availableProductPrice[k] + "� " + availableProductQuantity[k]);
								}
								System.out.println("Presiona enter para salir al menu");
								break;
							case "E":
								for (int k = 0; k < totalAvailableProducts - 1; k++) { //Order by price
									
									for (int j = k + 1; j < totalAvailableProducts; j++) {
										
										if (availableProductPrice[k] > availableProductPrice[j]) {
											
											productPriceSortChange = availableProductPrice[k];
											
											availableProductPrice[k] = availableProductPrice[j];
											
											availableProductPrice[j] = productPriceSortChange;
											
											productQuantitySortChange = availableProductQuantity[k];
											
											availableProductQuantity[k] = availableProductQuantity[j];
											
											availableProductQuantity[j] = productQuantitySortChange;

											productNameSortChange = availableProductName[k];
											
											availableProductName[k] = availableProductName[j];
											
											availableProductName[j] = productNameSortChange;
										}	
									}
								}
								
								for (int k = 0; k < totalAvailableProducts - 1; k++) {
									System.out.println(availableProductName[k] + " " + availableProductPrice[k] + "� " + availableProductQuantity[k]);
								}

								System.out.println("Presiona enter para salir al menu");
								break;
							default:
								if(!subMenuOption.toLowerCase().equals("salir")) {
									System.out.println("Que desea hacer? \n A: Registrar producto \n B: Modificar producto \n C: Borrar un producto \n D: Listar por nombre \n E: Listar por precio \n 'Salir' para salir al menu principal");
								}
								break;								
						}
					} while(!subMenuOption.toLowerCase().equals("salir"));
					System.out.println("Presiona enter para salir al menu");
					break;
				case "2":
					System.out.println("Introduce la fecha de compra -> dd/mm/aaaa");
					invoiceDateText = input.nextLine().split("/");
					
					for (int i = 0; i < invoiceDateText.length; i++) {
						invoiceNumberDate[i] = Integer.parseInt(invoiceDateText[i]);
					}
					
					try {
						invoiceDate = LocalDate.of(invoiceNumberDate[2], invoiceNumberDate[1], invoiceNumberDate[0]);
					} catch(Exception e) {
						System.out.println(e);
					}
					
					System.out.println("Introduce tu DNI");
					do {
						clientDNIToCheck = input.nextLine();
						
						if (!Character.isLetter(clientDNIToCheck.charAt(8)) && clientDNIToCheck.length() != 9) {
							validClientDNI =  false;
							System.out.println("Introduce tu DNI");
				        }
				 
				        for (int i = 0; i < 8; i++) {
				   
				             if(!Character.isDigit(clientDNIToCheck.charAt(i))){
				            	 validClientDNI = false;  
								System.out.println("Introduce tu DNI");  
				             }
				             if(Character.isDigit(clientDNIToCheck.charAt(i))) {
				            	 clientDNINumbers += clientDNIToCheck.charAt(i);
				             }
				        }
				  
				        clientDNI = Integer.parseInt(clientDNINumbers);
				        clientDNINumbers = "";
				        clientDNI %= 23;
				  
				        if ((Character.toUpperCase(clientDNIToCheck.charAt(8))) != posbileDNILetters[clientDNI]){
				        	validClientDNI = false;
							System.out.println("Introduce tu DNI");
				        } else {				        	
				        	validClientDNI = true;
				        }
					} while(!validClientDNI);
					System.out.println("DNI correcto \n Introduce tu nombre");
					clientName = input.nextLine();
					
					System.out.println("Introduce el nombre del producto a comprar");
					int k = 0;
					do {
						clientProductListOption = input.nextLine();
						int i = 0; // integer used to know array index equals to user input
						while(!clientProductListOption.equals(availableProductName[i]) && i < totalAvailableProducts) {// loop throw total products in array while user input not equals game name					
							i++;
						}
						if(clientProductListOption.equals(availableProductName[i])) { // if finds product name equals to user input do:
							
							System.out.println("Cuantas unidades desea? Actualmente tenemos: " + availableProductQuantity[i] + " a precio de: " + availableProductPrice[i]);							
							clientProductListQuantity = input.nextInt();
							input.nextLine();
							
							if(clientProductListQuantity <= availableProductQuantity[i]) {
															
								availableProductQuantity[i] -= clientProductListQuantity;
								
								clientProductList[k] = clientProductListOption;
								clientProductQuantity[k] = clientProductListQuantity;
								clientProductPrice[k] = (clientProductListQuantity * availableProductPrice[i]);
								clientProductUnitaryPrice[k] = availableProductPrice[i];

								k++;
								
							} else if(clientProductListQuantity > availableProductQuantity[i]) {
								System.out.println("No tenemos tantas unidades de ese producto. Introduce un nuevo valor");
								clientProductListQuantity = 0;
							}
							
						} else {
							if(!clientProductListOption.equals("salir")) {
								System.out.println("El producto " + clientProductListOption + " no existe"); // if user input a non existing product print product does not exists
							}
						}
						
						if(!clientProductListOption.equals("salir")) {
							System.out.println("Introduce el nombre del producto a comprar");
						}
					} while(!clientProductListOption.equals("salir"));
					
					
					for(int i = 0; i < k; i++) {
						totalPrice += clientProductPrice[i];
					}
					
					totalPriceIVA = ((totalPrice * IVA) + totalPrice);
					
					System.out.println("Numero factura: " + invoiceID +"\n Fecha factura: " + invoiceDate.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + "\n Client DNI: " + clientDNIToCheck + "\n Client name: " + clientName + "\n Productos: ");
					
					for(int i = 0; i < k; i++) {
						System.out.println("Nombre: " + clientProductList[i] + " Cantidad: " + clientProductQuantity[i] + " Precio unitario: " + clientProductUnitaryPrice[i] + " Precio total: " + clientProductPrice[i]);
					}
					
					System.out.println("TOTAL SIN IVA: " + totalPrice + "\n TOTAL IVA: " + totalPriceIVA + "\n Enter para salir al menu");
					
					break;
				default: 
					if(!mainMenuOption.toLowerCase().equals("salir")) {
						System.out.println("Que desea hacer? \n 1: Gestion de productos \n 2: Ventas \n 'Salir': para salir del programa");
					}
					break;
			}
		} while(!mainMenuOption.toLowerCase().equals("salir"));
		
		System.out.println("Has salido del programa");
		
		input.close();
	}

}

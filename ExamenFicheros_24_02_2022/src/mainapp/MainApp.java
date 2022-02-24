package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import modules.Buy;
import modules.BuyProduct;
import modules.Product;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Menu Compres usuari Comprar Sortir
		 */
		Scanner input = new Scanner(System.in);
		String mainMenuOption = "";
		
		System.out.println("[1] Ver compras de usuario \n[2] Comprar productos \n[Salir] para salir");
		mainMenuOption = input.nextLine();
		
		switch(mainMenuOption) {
		case "1":
			viewUserBuy();
			break;
		case "2":
			buyMenu();
			break;
		}
		//
	}

	static void viewUserBuy() throws FileNotFoundException {
		File buyData = new File("Compres.txt");
		File userData = new File("Clients.txt");
		File productData = new File("Productes.txt");

		Scanner input = new Scanner(System.in);
		Scanner fileData = new Scanner(buyData);
		Scanner users = new Scanner(userData);
		Scanner products = new Scanner(productData);

		String clientID = "";
		int totalCompra = 0;

		String[] fileLine = new String[0];
		String[] userLine = new String[0];
		String[] userLineBuy = new String[0];
		String[][] userLineBuyData = new String[0][0];

		ArrayList<Product> availableProducts = new ArrayList<Product>();
		
		System.out.printf("Introduce el DNI del cliente %n");
		clientID = input.nextLine();

		input.close();

		while (fileData.hasNextLine()) {
			fileLine = fileData.nextLine().split("-");
			int lineLength = fileLine.length;
			
			if (fileLine[1].equalsIgnoreCase(clientID)) {
				while (users.hasNextLine()) {
					userLine = users.nextLine().split("-");
					if (userLine[0].equalsIgnoreCase(clientID)) {
						
						if (lineLength > 3) {
							System.out.println(userLine[1]);
							System.out.print(fileLine[0] + " \n" + fileLine[2] + "\n");

							userLineBuy = fileLine[3].split("#");
							userLineBuyData = new String[userLineBuy.length][2];
							for (int i = 0; i < userLineBuy.length; i++) {
								userLineBuyData[i] = userLineBuy[i].split(",");
							}
							for (int i = 3; i < lineLength; i++) {
								for (int k = 0; k < userLineBuyData.length; k++) {
									while (products.hasNextLine()) {
										String[] a = new String[0];
										a = products.nextLine().split("-");

										Product p = new Product();
										p.productID = Integer.parseInt(a[0]);
										p.productName = a[1];
										p.productPrice = Integer.parseInt(a[2]);
										availableProducts.add(p);
									}
									for (Product p : availableProducts) {
										if (p.productID == Integer.parseInt(userLineBuyData[k][0])) {
											totalCompra += (p.productPrice * Integer.parseInt(userLineBuyData[k][1]));
											System.out.printf("%s (%s) - %s | TOTAL PRODUCTE: %s %n", p.productName, p.productPrice, userLineBuyData[k][1], (p.productPrice * Integer.parseInt(userLineBuyData[k][1])));
										}
									}
								}
							}
							System.out.println("TOTAL TOTAL " + totalCompra);
							exportToCSV(clientID);
						} else {
							System.out.println("Usuario con DNI: " + clientID + " no ha realizado ninguna compra");
						}
					}
				}

			}
		}
		fileData.close();
		users.close();
		products.close();
	}

	static void exportToCSV(String dni) throws FileNotFoundException {
		File exportToCSV = new File(dni + ".csv");
		File buyData = new File("Compres.txt");
		File userData = new File("Clients.txt");

		Scanner fileData = new Scanner(buyData);
		Scanner users = new Scanner(userData);

		String clientID = "";

		String[] fileLine = new String[0];
		String[] userLine = new String[0];
		String[] userLineBuy = new String[0];
		String[][] userLineBuyData = new String[0][0];

		ArrayList<Buy> userBuy = new ArrayList<Buy>();


		while (fileData.hasNextLine()) {
			fileLine = fileData.nextLine().split("-");
			int lineLength = fileLine.length;

			if (fileLine[1].equalsIgnoreCase(clientID)) {
				while (users.hasNextLine()) {
					userLine = users.nextLine().split("-");
					if (userLine[0].equalsIgnoreCase(clientID)) {

						if (lineLength > 3) {
							Buy b = new Buy();
							b.buyID = Integer.parseInt(fileLine[0]);
							b.clientID = fileLine[1];
							b.date = LocalDate.parse(fileLine[2], DateTimeFormatter.ofPattern("y/M/d"));

							userLineBuy = fileLine[3].split("#");
							userLineBuyData = new String[userLineBuy.length][2];
							for (int i = 0; i < userLineBuy.length; i++) {
								userLineBuyData[i] = userLineBuy[i].split(",");
							}
							for (int i = 3; i < lineLength; i++) {
								for (int k = 0; k < userLineBuyData.length; k++) {
									BuyProduct buyProduct = new BuyProduct();
									buyProduct.productID = Integer.parseInt(userLineBuyData[0][0]);
									buyProduct.productQuantity = Integer.parseInt(userLineBuyData[0][1]);
									b.products.add(buyProduct);
								}
							}
							userBuy.add(b);
						}
					}
				}
			}
		}
		
		fileData.close();
		users.close();

		PrintStream stream = new PrintStream(exportToCSV);
		stream.printf("%s;%s;%s;%s;%s%n", "DNI", "Num Compra", "Data", "Producte ID", "Quantitat");
		for(Buy b : userBuy) {
			for(BuyProduct bp : b.products) {
				stream.printf("%s;%d;%s;", userBuy.get(0).clientID, userBuy.get(0).buyID, userBuy.get(0).date);
				stream.printf("%s;%s;", bp.productID, bp.productQuantity);
				stream.println();
			}
		}
		stream.close();
	}

	static void buyMenu() throws FileNotFoundException {
		File buyData = new File("Compres.txt");
		File clients = new File("Clients.txt");
		File productData = new File("Productes.txt");
		Scanner buyDataLines = new Scanner(buyData);
		Scanner products = new Scanner(productData);
		Scanner input = new Scanner(System.in);
		
		String[][] registeredClients = new String[3][2];
		ArrayList<Product> availableProducts = new ArrayList<Product>();
		ArrayList<Buy> listBuy = new ArrayList<Buy>();
		
		int buyNextID = 0;
		LocalDate buyDate = LocalDate.now();
		String clientID = "";
		String clientName = "";
		
		while(buyDataLines.hasNextLine()) {
			buyNextID++;
			buyDataLines.nextLine();
		}
		buyDataLines.close();
		
		System.out.println("DNI del comprador");
		clientID = input.nextLine();
		
		Scanner clientLines = new Scanner(clients);
		int i = 0;
		while(clientLines.hasNextLine()) {
			registeredClients[i] = clientLines.nextLine().split("-");
			i++;
		}
		clientLines.close();
		
		for(int j = 0; j < registeredClients.length; j++) {
			if(registeredClients[j][0].equals(clientID)) {
				clientName = registeredClients[j][1];
			}
		}
		
		while (products.hasNextLine()) {
			String[] a = new String[0];
			a = products.nextLine().split("-");

			Product p = new Product();
			p.productID = Integer.parseInt(a[0]);
			p.productName = a[1];
			p.productPrice = Integer.parseInt(a[2]);
			availableProducts.add(p);
		}
		products.close();
		
		Buy b = new Buy();
		b.buyID = (buyNextID + 1);
		b.clientID = clientID;
		b.date = buyDate;
		
		for (Product p : availableProducts) {
			BuyProduct bp = new BuyProduct();
			System.out.println("Cuantas unidades quiere del producto: " + p.productName);
			bp.productID = p.productID;
			bp.productQuantity = input.nextInt();
			input.nextLine();
			b.products.add(bp);
			
		}
		
		listBuy.add(b);
		
		System.out.printf("Compra: %d %nData: %s %nDNI: %s %nNom client: %s%n", b.buyID, b.date.format(DateTimeFormatter.ofPattern("d/M/y")), clientID, clientName);
		for(BuyProduct bp : b.products) {
			if(bp.productQuantity != 0) {
				System.out.printf("%d %d %n", bp.productID, bp.productQuantity);
			}
		}
		
		File newBuy = new File(b.buyID + ".txt");
		
		PrintStream stream = new PrintStream(newBuy);
		stream.printf("%d-%s-%s-%s", b.buyID, b.date, b.clientID, clientName);
		for(BuyProduct bp : b.products) {
			if(bp.productQuantity != 0) {
				stream.printf("-%d-%d", bp.productID, bp.productQuantity);
			}
		}
		stream.close();
		
		Scanner saveDataLines = new Scanner(buyData);
		while(saveDataLines.hasNextLine()) {
			String[] lines = saveDataLines.nextLine().split("-");
			String[] lineProducts = new String[0];
			String[][] lineProductsData = new String[0][0];
			int lineLength = lines.length;
			
			Buy saveBuy = new Buy();
			saveBuy.buyID = Integer.parseInt(lines[0]);
			saveBuy.clientID = lines[1];
			saveBuy.date = LocalDate.parse(lines[2], DateTimeFormatter.ofPattern("y/M/d"));
			
			if (lineLength > 3) {
				lineProducts = lines[3].split("#");
				lineProductsData = new String[lineProducts.length][2];
				for (int k = 0; k < lineProducts.length; k++) {
					lineProductsData[k] = lineProducts[k].split(",");
				}
				for (int k = 3; k < lineLength; k++) {
					for (int j = 0; j < lineProductsData.length; j++) {
						BuyProduct bp = new BuyProduct();
						bp.productID = Integer.parseInt(lineProductsData[j][0]);
						bp.productQuantity = Integer.parseInt(lineProductsData[j][1]);
						
						saveBuy.products.add(bp);
					}
				}
			}

			listBuy.add(saveBuy);
			
		}
		saveDataLines.close();
		
		PrintStream saveBuyStream = new PrintStream(buyData);
		for(Buy save: listBuy) {
			saveBuyStream.printf("%d-%s-%s-", save.buyID, save.clientID, save.date.format(DateTimeFormatter.ofPattern("d/M/y")));
			for(BuyProduct bp: save.products) {
				if(bp.productQuantity != 0) {
					saveBuyStream.printf("%d,%d#", bp.productID, bp.productQuantity);
				}
			}
			saveBuyStream.printf("%n");
		}
		saveBuyStream.close();
		input.close();
	}
}

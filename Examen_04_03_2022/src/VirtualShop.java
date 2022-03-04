import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import models.BuyLog;

public class VirtualShop {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("VirtualShop.txt");
		Scanner input = new Scanner(System.in);
		ArrayList<BuyLog> buyLogs = new ArrayList<BuyLog>();

		String mainMenuOption = "";

		getDataFromFile(file, buyLogs);

		System.out.printf("Que desea hacer? %n[1] Ver compras de usuario %n[2] Comprar %n");
		mainMenuOption = input.nextLine();
		
		

		switch (mainMenuOption) {
		case "1":
			userBuys(buyLogs);
			break;
		case "2":
			buy(file, buyLogs);
			break;
		}

	}

	static void getDataFromFile(File file, ArrayList<BuyLog> buyLogs) throws FileNotFoundException {

		try (Scanner fileData = new Scanner(file)) {
			while (fileData.hasNextLine()) {
				BuyLog b = new BuyLog();
				b.buyID = fileData.nextInt();
				b.name = fileData.next();
				b.date = LocalDate.parse(fileData.next());
				b.productA = fileData.nextInt();
				b.productB = fileData.nextInt();
				b.productC = fileData.nextInt();
				b.totalBuy = fileData.nextInt();
				fileData.nextLine();
				buyLogs.add(b);
			}
			fileData.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

	static void buy(File file, ArrayList<BuyLog> buyLogs) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);

		int buyID;
		String userName;
		LocalDate buyDate;
		int productA, productB, productC, total;

		System.out.println("Introduce el numero de compra");
		buyID = input.nextInt();
		input.nextLine();

		System.out.println("Introduce el nombre del cliente");
		userName = input.nextLine();

		System.out.println("Introduce la fecha de compra");
		buyDate = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));

		System.out.println("Cuantas unidades quiere de producto A");
		productA = input.nextInt();
		input.nextLine();

		System.out.println("Cuantas unidades quiere de producto B");
		productB = input.nextInt();
		input.nextLine();

		System.out.println("Cuantas unidades quiere de producto C");
		productC = input.nextInt();
		input.nextLine();
		
		

		total = (5 * productA) + (9 * productB) + (12 * productC);
		
		BuyLog b = new BuyLog();
		b.buyID = buyID;
		b.name = userName;
		b.date = buyDate;
		b.productA = productA;
		b.productB = productB;
		b.productC = productC;
		b.totalBuy = total;
		
		buyLogs.add(b);

		File export = new File(buyID + ".txt");
		
		PrintStream output = new PrintStream(export);
		output.printf("%d %s %s %d %d %d %d%n", buyID, userName, buyDate, productA, productB, productC, total);
		output.close();
		
		PrintStream data = new PrintStream(file);
		for(BuyLog bl : buyLogs) {
			data.printf("%d %s %s %d %d %d %d%n", bl.buyID, bl.name, bl.date, bl.productA, bl.productB, bl.productC, b.totalBuy);
		}
		data.close();
	}

	static void userBuys(ArrayList<BuyLog> buyLogs) {
		Scanner input = new Scanner(System.in);
		String userName;
		
		System.out.println("Nombre de usuario a buscar");
		userName = input.nextLine();
		
		int i = 0;
		while(!buyLogs.get(i).name.equals(userName) && i < buyLogs.size() - 1) {
			i++;
		}
		if(buyLogs.get(i).name.equals(userName)) {
			System.out.printf("%d %n%s %n%d %n%d %n%d %n%d", buyLogs.get(i).buyID, buyLogs.get(i).date, buyLogs.get(i).productA, buyLogs.get(i).productB, buyLogs.get(i).productC, buyLogs.get(i).totalBuy);
		} else {
			System.out.println("Usuario no encontrado");
		}
	}
}

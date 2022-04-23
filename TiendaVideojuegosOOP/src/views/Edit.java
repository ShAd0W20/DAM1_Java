package views;

import models.Producto;
import models.Programa;
import models.Tienda;
import models.Videojuego;
import models.enums.GameTypes;
import models.enums.OSTypes;
import models.enums.ProgramTypes;
import models.enums.ConsoleTypes;
import utils.ConsoleHelper;

public class Edit {
	public static void addProduct(Tienda t) {
		System.out.printf("%nQue producto desea registrar? %n[1] Programa %n[2] Videojuego%n");
		int opt;
		opt = ConsoleHelper.choseOption(0, 2);
		switch (opt) {
		case 1:
			registerProgram(t);
			break;
		case 2:
			registerGame(t);
			break;
		}
	}

	public static void addStockToProduct(Tienda t) {
		listAllProducts(t);
		String productID = ConsoleHelper.readString("Introduce el codigo del producto: ");
		int stock = ConsoleHelper.readInteger("Introduce el nuevo stock: ");
		t.addStockToProduct(productID, stock);
	}

	public static void deleteProduct(Tienda t) {
		listAllProducts(t);
		String productID = ConsoleHelper.readString("Introduce el codigo del producto a eliminar: ");
		t.deleteProductFromShop(productID);
	}

	public static void listAllProducts(Tienda t) {
		for (Producto p : t.listAllProducts()) {
			System.out.printf(p.toString());
		}
	}
	
	public static void listSoltProducts(Tienda t) {
		for (Producto p : t.listSoltProducts()) {
			System.out.println(p.toString());
		}
	}

	private static void registerGame(Tienda t) {
		String code = ConsoleHelper.readString("Introduce el codigo del videojuego: ");
		String name = ConsoleHelper.readString("Introduce el nombre del videojuego: ");
		double price = ConsoleHelper.readDouble("Introduce el precio del juego: ");
		int stock = ConsoleHelper.readInteger("Introduce el stock del juego: ");
		int sells = ConsoleHelper.readInteger("Introduce las veces vendido: ");

		System.out.println("Que tipo de videojuego es? Escoge un tipo:");
		printGameTypes();

		GameTypes gametype = getGameType(ConsoleHelper.choseOption(1, 5));

		System.out.println("Para que tipo de consola es? Escoge un tipo:");
		printConsoleTypes();

		ConsoleTypes consoleType = getConsoleType(ConsoleHelper.choseOption(1, 4));

		Videojuego v = new Videojuego(code, name, price, stock, sells, gametype, consoleType);
		t.addProduct(v);
	}

	private static void registerProgram(Tienda t) {
		String code = ConsoleHelper.readString("Introduce el codigo del programa: ");
		String name = ConsoleHelper.readString("Introduce el nombre del programa: ");
		double price = ConsoleHelper.readDouble("Introduce el precio del programa: ");
		int stock = ConsoleHelper.readInteger("Introduce el stock del programa: ");
		int sells = ConsoleHelper.readInteger("Introduce las veces vendido: ");

		System.out.println("Que tipo de programa es? Escoge un tipo:");
		printProgramTypes();

		ProgramTypes programType = getProgramType(ConsoleHelper.choseOption(1, 3));

		System.out.println("Para que tipo de consola es? Escoge un tipo:");
		printOSTypes();

		OSTypes osType = getOSTypes(ConsoleHelper.choseOption(1, 3));

		Programa p = new Programa(code, name, price, stock, sells, programType, osType);
		t.addProduct(p);
	}
	
	private static void printGameTypes() {
		for (GameTypes gameType : GameTypes.values()) {
			System.out.println("[" + (gameType.ordinal() + 1) + "]" + " " + gameType.getGameType());
		}
	}

	private static void printConsoleTypes() {
		for (ConsoleTypes consoleType : ConsoleTypes.values()) {
			System.out.println("[" + (consoleType.ordinal() + 1) + "]" + " " + consoleType.getConsoleType());
		}
	}

	private static void printProgramTypes() {
		for (ProgramTypes programType : ProgramTypes.values()) {
			System.out.println("[" + (programType.ordinal() + 1) + "]" + " " + programType.getProgramType());
		}
	}

	private static void printOSTypes() {
		for (OSTypes osTypes : OSTypes.values()) {
			System.out.println("[" + (osTypes.ordinal() + 1) + "]" + " " + osTypes.getOsType());
		}
	}

	private static GameTypes getGameType(int type) {
		switch (type) {
		case 1:
			return GameTypes.ACCION;
		case 2:
			return GameTypes.ARCADE;
		case 3:
			return GameTypes.DEPORTIVO;
		case 4:
			return GameTypes.ESTRATEGIA;
		case 5:
			return GameTypes.SIMULACION;
		}
		return null;
	}

	private static ConsoleTypes getConsoleType(int type) {
		switch (type) {
		case 1:
			return ConsoleTypes.PS4;
		case 2:
			return ConsoleTypes.PS5;
		case 3:
			return ConsoleTypes.XBOX;
		case 4:
			return ConsoleTypes.PC;
		}
		return null;
	}

	private static ProgramTypes getProgramType(int type) {
		switch (type) {
		case 1:
			return ProgramTypes.PROCESADORTEXT;
		case 2:
			return ProgramTypes.HOJASDECALCULO;
		case 3:
			return ProgramTypes.PRESENTACIONES;
		}
		return null;
	}

	private static OSTypes getOSTypes(int type) {
		switch (type) {
		case 1:
			return OSTypes.WINDOWS;
		case 2:
			return OSTypes.MACOS;
		case 3:
			return OSTypes.LINUX;
		}
		return null;
	}

}

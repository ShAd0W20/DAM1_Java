package main.java.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleHelper {
	private static Scanner sc = new Scanner(System.in);

	public static void printMainMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Gestion usuarios \n[2] Gestion productos \n[3] Historial ventas \n[0] Salir");
		System.out.println("Eliga una opcion: ");
	}

	public static void printUpdateProductMenu() {
		System.out.println("Que desea actualizar?");
		System.out.println("[1] Stock \n[2] Precio \n[3] IVA \n[0] Salir");
		System.out.println("Eliga una opcion: ");
	}

	public static void printUserMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Mostrar datos de [1] usuario \n[2] Mostrar todos los usuarios  \n[0] Salir");
		System.out.println("Eliga una opcion: ");
	}

	public static void printProductMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Registrar producto \n[2] Modificar producto \n[3] Eliminar producto \n[0] Salir");
		System.out.println("Eliga una opcion: ");
	}

	public static void printSellsMenu() {
		System.out.println("Que desea hacer?");
		System.out.println(
				"[1] Ver una factura \n[2] Ver todas las facturas de un cliente \n[3] Ver facturas entre dos fechas \n[4] Ver estadisticas de un producto \n[5] Ver estadisticas de todos los productos \n[0] Salir");
		System.out.println("Eliga una opcion: ");
	}

	public static int choseMenuOption(int minValue, int maxValue) {
		boolean isNumber = false;
		int opc = 0;
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < minValue || opc > maxValue) {
					System.out.println("ERROR: Por favor, elige una opción entre " + minValue + " y " + maxValue);
					printMainMenu();
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce números del " + minValue + " al " + maxValue);
				printMainMenu();
			}
		}
		return opc;
	}

	public static int choseOption(int minValue, int maxValue) {
		boolean isNumber = false;
		int opc = 0;
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < minValue || opc > maxValue) {
					System.out.println("ERROR: Por favor, elige una opción entre " + minValue + " y " + maxValue);
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce números del " + minValue + " al " + maxValue);
			}
		}
		return opc;
	}

	public static String readString(String what) {
		System.out.println(what);
		return sc.nextLine();
	}

	public static int readInteger(String what) {
		System.out.println(what);
		boolean isNumber = false;
		int integerToRead = 0;
		while (!isNumber) {
			try {
				integerToRead = Integer.parseInt(sc.nextLine());
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce un número válido");
			}
		}
		return integerToRead;
	}

	public static double readIDouble(String what) {
		System.out.println(what);
		boolean isDouble = false;
		double doubleToRead = 0.0;
		while (!isDouble) {
			try {
				doubleToRead = Double.parseDouble(sc.nextLine());
				isDouble = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce un número válido");
			}
		}
		return doubleToRead;
	}

	public static LocalDate readLocalDate(String what) {
		System.out.println(what);
		boolean isLocalDate = false;
		LocalDate localDateToRead = null;
		while (!isLocalDate) {
			try {
				localDateToRead = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));
				isLocalDate = true;
			} catch (DateTimeParseException e) {
				System.out.println("ERROR: Introduce una fecha válida con formato (DD/MM/YY)");
			}
		}
		return localDateToRead;
	}
}

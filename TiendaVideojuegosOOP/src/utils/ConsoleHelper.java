package utils;

import java.util.Scanner;

public class ConsoleHelper {
	private static Scanner sc = new Scanner(System.in);

	public static void printMainMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Comprar \n[2] Editar \n[0] Salir");
		System.out.println("Elige una opción: ");
	}
	
	public static void printEditMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Registrar producto \n[2] Añadir stock \n[3] Borrar producto \n[4] Listar productos \n[5] Listar productos vendidos \n[0] Salir");
		System.out.println("Elige una opción: ");
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
	
	public static String readFormatedString(String what) {
		System.out.printf(what);
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
	
	public static double readDouble(String what) {
		System.out.println(what);
		boolean isDouble = false;
		double doubleToRead = 0;
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
}

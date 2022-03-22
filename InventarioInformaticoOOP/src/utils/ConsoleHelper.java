package utils;

import java.util.Scanner;

public class ConsoleHelper {
	private static Scanner sc = new Scanner(System.in);

	public static void printMainMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Registrar \n[2] Editar \n[3] Listar \n[4] Borrar \n[0] Salir");
		System.out.println("Elige una opción: ");
	}

	public static void printRegisterMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Registrar portatil \n[2] Registrar sobremesa \n[3] Registrar proyector \n[4] Registrar impresora \n[0] Salir");
		System.out.println("Elige una opción: ");
	}

	public static void printEditMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Editar portatil \n[2] Editar sobremesa \n[3] Editar proyector \n[4] Editar impresora \n[0] Salir");
		System.out.println("Elige una opción: ");
	}

	public static void printListMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Listar equipos \n[2] Listar en ubicación \n[3] Listar por ubicación \n[4] Listar ordenado por tipo \n[5] Listar ordenado por estado \n[0] Salir");
		System.out.println("Elige una opción: ");
	}
	
	public static void printDeleteMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Eliminar portatil \n[2] Eliminar sobremesa \n[3] Eliminar proyector \n[4] Eliminar impresora \n[0] Salir");
		System.out.println("Elige una opción: ");
	}
	
	public static void printError(String what) {
		System.out.printf("%n%n[!] " + what + " %n");
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

	public static boolean readYesNo(String what) {
		boolean isNumber = false;
		int opc = 0;
		System.out.println(what);
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < 0 || opc > 1) {
					System.out.println("ERROR: Por favor, elige una opción entre " + 0 + " (no) y " + 1 + "(sí)");
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce números del " + 0 + " (no) y " + 1 + "(sí)");
			}
		}
		return opc == 1;
	}
}

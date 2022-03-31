package utils;

import java.util.Scanner;

public class ConsoleHelper {
	private static Scanner sc = new Scanner(System.in);

	public static void printMainMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Registrar \n[2] Listar \n[0] Salir");
		System.out.println("Elige una opción: ");
	}
	
	public static void printRegisterMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Alumno \n[2] Deportista \n[0] Salir");
		System.out.println("Elige una opción: ");
	}
	
	public static void printTypeStudentToRegister() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] ESO \n[2] CF \n[0] Salir");
		System.out.println("Elige una opción: ");
	}
	
	public static void printTypeSportToRegister() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Futbolista \n[2] Basketball \n[0] Salir");
		System.out.println("Elige una opción: ");
	}
	
	public static void printListMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Listar ESO \n[2] Listar CF \n[3] Listar Futbolista \n[4] Listar Baloncesto \n[5] Listar alumnos \n[6] Listar deportistas \n[7] Listar personas \n[0] Salir");
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

package utils;

import java.util.Scanner;

public class ConsoleHelper {
	private static Scanner sc = new Scanner(System.in);

	public static void printMainMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Comprar \n[2] Editar \n[0] Salir");
		System.out.println("Elige una opci�n: ");
	}
	
	public static void printRegisterMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Registrar piloto \n[2] Registrar equipo \n[3] Registrar circuito \n[4] Registrar carrera \n[0] Salir");
		System.out.println("Elige una opci�n: ");
	}
	
	public static void printEditMenu() {
		System.out.println("Que desea hacer?");
		System.out.println("[1] Editar piloto \n[2] Editar equipo \n[3] Editar circuito \n[4] Editar carrera \n[0] Salir");
		System.out.println("Elige una opci�n: ");
	}
	
	public static int choseMenuOption(int minValue, int maxValue) {
		boolean isNumber = false;
		int opc = 0;
		while (!isNumber) {
			try {
				opc = Integer.parseInt(sc.nextLine());
				while (opc < minValue || opc > maxValue) {
					System.out.println("ERROR: Por favor, elige una opci�n entre " + minValue + " y " + maxValue);
					printMainMenu();
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce n�meros del " + minValue + " al " + maxValue);
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
					System.out.println("ERROR: Por favor, elige una opci�n entre " + minValue + " y " + maxValue);
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce n�meros del " + minValue + " al " + maxValue);
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
				System.out.println("ERROR: Introduce un n�mero v�lido");
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
					System.out.println("ERROR: Por favor, elige una opci�n entre " + 0 + " (no) y " + 1 + "(s�)");
					opc = Integer.parseInt(sc.nextLine());
				}
				isNumber = true;
			} catch (NumberFormatException e) {
				System.out.println("ERROR: Introduce n�meros del " + 0 + " (no) y " + 1 + "(s�)");
			}
		}
		return opc == 1;
	}
}

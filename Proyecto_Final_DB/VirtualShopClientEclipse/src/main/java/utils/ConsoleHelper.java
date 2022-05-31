package main.java.utils;

import java.util.Scanner;

public class ConsoleHelper {
	private static Scanner sc = new Scanner(System.in);

	public static void printMainMenu() {
		System.out.println("\nQue desea hacer?");
		System.out.println("[1] Zona cliente \n[2] Zona tienda \n[0] Salir");
		System.out.println("Eliga una opcion: ");
	}

	public static void printClientMenu() {
		System.out.println("\nQue desea hacer?");
		System.out.println("[1] Registrarse \n[2] Modificar datos \n[3] Eliminar cuenta \n[0] Salir");
		System.out.println("Eliga una opcion: ");
	}

	public static void printShopNotRegistered() {
		System.out.println("\nQue desea hacer?");
		System.out.println("[1] Registrarse \n[0] Salir");
		System.out.println("Eliga una opcion: ");
	}

	public static void printShopContinueShopping() {
		System.out.println("\nQue desea hacer?");
		System.out.println("[1] Seguir comprando \n[0] Finalizar compra");
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
}

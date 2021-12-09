import java.util.Scanner;

public class Metodos2 {

	static final int MAX_NUMBERS = 10;
	static int[] numbers = new int[MAX_NUMBERS];
	static int[] originalNumbers = new int[MAX_NUMBERS];
	static int totaNumbersRegistered = 0;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Menu();
	}

	static void Menu() {
		String mainMenuOption = "";

		System.out.println("Que desea hacer? \n1) Entrar numeros \n2) Imprimir por orden de entrada \n3) Imprimir de menor a mayor \n4) Imprimir de mayor a menor \n'Salir' para salir del programa");

		do {
			mainMenuOption = input.nextLine();
			switch (mainMenuOption) {
				case "1":
					RegisterNumbers();
					break;
				case "2":
					PrintOriginalNumberList();
					break;
				case "3":
					OrderByLowerNumber();
					break;
				case "4":
					OrderByHigherNumber();
					break;
				default:
					if (!mainMenuOption.equalsIgnoreCase("salir")) {
						System.out.println("Que desea hacer? \n1) Entrar numeros \n2) Imprimir por orden de entrada \n3) Imprimir de menor a mayor \n4) Imprimir de mayor a menor \n'Salir' para salir del programa");
					}
			}
		} while (!mainMenuOption.equalsIgnoreCase("salir"));

		input.close();
	}

	static void RegisterNumbers() {
		String numberToRegister = "";
		do {
			System.out.println("Introduce el siguiente numero a registrar. 'Salir' para salir al menu principal");
			numberToRegister = input.nextLine();
			if (!numberToRegister.equalsIgnoreCase("salir")) {
				numbers[totaNumbersRegistered] = Integer.parseInt(numberToRegister);
				totaNumbersRegistered++;
			}
		} while (!numberToRegister.equalsIgnoreCase("salir"));
		System.out.println("Pulsa enter para volver");
		for (int i = 0; i < totaNumbersRegistered; i++) {
			originalNumbers[i] = numbers[i];
		}
	}

	static void PrintOriginalNumberList() {
		for (int i = 0; i < totaNumbersRegistered; i++) {
			System.out.println(originalNumbers[i]);
		}
		System.out.println("Pulse enter para volver al menu");
	}

	static void PrintOrderedNumberList() {
		for (int i = 0; i < totaNumbersRegistered; i++) {
			System.out.println(numbers[i]);
		}
		System.out.println("Pulse enter para volver al menu");
	}

	static void OrderByLowerNumber() {
		int numberToSort = 0;
		for (int i = 0; i < totaNumbersRegistered - 1; i++) {
			for (int j = i + 1; j < totaNumbersRegistered; j++) {
				if (numbers[i] > numbers[j]) {

					numberToSort = numbers[i];

					numbers[i] = numbers[j];

					numbers[j] = numberToSort;
				}
			}
		}
		
		PrintOrderedNumberList();
	}

	static void OrderByHigherNumber() {
		int numberToSort = 0;
		for (int i = 0; i < totaNumbersRegistered - 1; i++) {
			for (int j = i + 1; j < totaNumbersRegistered; j++) {
				if (numbers[i] < numbers[j]) {

					numberToSort = numbers[i];

					numbers[i] = numbers[j];

					numbers[j] = numberToSort;
				}
			}
		}
		
		PrintOrderedNumberList();
	}
}

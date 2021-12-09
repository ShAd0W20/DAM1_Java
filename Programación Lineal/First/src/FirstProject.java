import java.util.Scanner;

public class FirstProject {

	public static void main(String[] args) {
		Scanner inputScreen = new Scanner(System.in);

		System.out.println("Anem a sumar tres nombres enters");


		System.out.print("Write the first number and press enter: ");

		int firstNumber = inputScreen.nextInt();

		inputScreen.nextLine();

		System.out.print("Write the second number: ");

		int segondNumber = inputScreen.nextInt();

		inputScreen.nextLine();
		
		System.out.print("And the last one: ");

		int thirdNumber = inputScreen.nextInt();

		inputScreen.nextLine();

		int total = firstNumber + segondNumber + thirdNumber;


		System.out.println("Total = " + total);
		
		inputScreen.close();

	}

}

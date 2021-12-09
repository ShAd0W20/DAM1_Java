import java.util.Random;
import java.util.Scanner;

public class DoubleSelection {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		int secretNumber1 = random.nextInt(11);
		int secretNumber2 = random.nextInt(11);
		int userInput = 0;

		System.out.println("Introdueix un numero");
		
		userInput = input.nextInt();
		input.nextLine();
		
		input.close();
		
		if(userInput == secretNumber1 || userInput == secretNumber2) {
			System.out.println("Enhorabona! Has encertat un dels dos nombres secrets!!!");
		} else {
			System.out.println("Malauradament el nombre " + userInput + " no és cap dels dos nombres secrets.");
		}
	}

}

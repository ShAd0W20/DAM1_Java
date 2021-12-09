import java.util.Random;
import java.util.Scanner;

public class RandomLottery {

	public static void main(String[] args) {
		Random rnd = new Random();
		Scanner input = new Scanner(System.in);
		
		final int MAX_USER_NUMBERS = 4;
		final int MAX_WINNER_NUMBERS = 4;

		int[] winnerNumbers = new int[MAX_USER_NUMBERS];
		int[] userNumbers = new int[MAX_WINNER_NUMBERS];
		
		int sorter;
		int correctNumbers = 0;
		
		System.out.println("Introduce " + MAX_USER_NUMBERS + " numeros seguidos separados por espacios");

		for (int i = 0; i < MAX_USER_NUMBERS; i++) {
			userNumbers[i] = input.nextInt();
		}
		input.nextLine();
		
		for (int i = 0; i < MAX_USER_NUMBERS - 1; i++) {

			for (int j = i + 1; j < MAX_USER_NUMBERS; j++) {

				if (userNumbers[i] > userNumbers[j]) {

					sorter = userNumbers[i];

					userNumbers[i] = userNumbers[j];

					userNumbers[j] = sorter;

				}
			}
		}
		
		for (int i = 0; i < MAX_USER_NUMBERS; i++) {
			System.out.println("Numero escogido " + (i + 1) + ": " + userNumbers[i]);
		}

		for (int i = 0; i < MAX_WINNER_NUMBERS; i++) {
			winnerNumbers[i] = rnd.nextInt(12) + 1;
		}

		for (int i = 0; i < MAX_WINNER_NUMBERS - 1; i++) {

			for (int j = i + 1; j < MAX_WINNER_NUMBERS; j++) {

				if (winnerNumbers[i] > winnerNumbers[j]) {

					sorter = winnerNumbers[i];

					winnerNumbers[i] = winnerNumbers[j];

					winnerNumbers[j] = sorter;

				}
			}
		}

		for (int i = 0; i < MAX_WINNER_NUMBERS; i++) {
			System.out.println("Numero ganador " + (i + 1) + ": " + winnerNumbers[i]);
		}
		
		for (int i = 0; i < MAX_WINNER_NUMBERS; i++) {
			int j = 0;
			while((userNumbers[i] > winnerNumbers[j]) && (j < MAX_WINNER_NUMBERS)) {
				j++;
			}
			if(userNumbers[i] == winnerNumbers[j]) correctNumbers++;
		}
		
		System.out.println("Has acertado " + correctNumbers + " numeros");

		input.close();
	}
	
}

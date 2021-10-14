import java.util.Scanner;
import java.util.Random;

public class doWhile1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		int intentos = 0;
		int numSecreto = random.nextInt(11);
		int userSecretNumber = 11;
		
		do {
			System.out.println("Introduce un numero entre 0 - 10");
			
			userSecretNumber = input.nextInt();
			input.nextLine();
			
			if(userSecretNumber != numSecreto) {
				System.out.println("No has acertado el numero");
			}
			
			intentos++;
		} while(userSecretNumber != numSecreto);
		
		System.out.println("Has acertado el numero secreto con " + intentos + " intentos");
		
		input.close();

	}

}

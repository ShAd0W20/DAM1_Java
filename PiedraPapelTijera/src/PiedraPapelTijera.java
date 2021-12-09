import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rnd = new Random();
		String[] options = { "Piedra", "Papel", "Tijera" };

		int userOption = 0;
		String result = "";

		int userWins = 0;
		int computerWins = 0;

		do {
			int computerOption = rnd.nextInt(3) + 1;
			do {
				System.out.println("Que quieres tirar? \n 1: Piedra \n 2: Papel \n 3: Tijera");
				userOption = input.nextInt();
				input.nextLine();
			} while (userOption >= 4 || userOption <= 0);

			switch (userOption) {
			case 1:
				switch (computerOption) {
				case 1:
					result = "\n Habeis empatado";
					break;
				case 2:
					result = "\n Has perdido :(";
					computerWins++;
					break;
				case 3:
					result = "\n Has ganado!!";
					userWins++;
					break;
				}
				System.out.println("Has tirado: " + options[userOption - 1] + "\n El ordenador ha tirado: "
						+ options[computerOption - 1] + result);
				break;
			case 2:
				switch (computerOption) {
				case 1:
					result = "\n Has ganado!!";
					userWins++;
					break;
				case 2:
					result = "\n Habeis empatado";
					break;
				case 3:
					result = "\n Has perdido :(";
					computerWins++;
					break;
				}
				System.out.println("Has tirado: " + options[userOption - 1] + "\n El ordenador ha tirado: "
						+ options[computerOption - 1] + result);
				break;
			case 3:
				switch (computerOption) {
				case 1:
					result = "\n Has perdido :(";
					computerWins++;
					break;
				case 2:
					result = "\n Has ganado!!";
					userWins++;
					break;
				case 3:
					result = "\n Habeis empatado";
					break;
				}
				System.out.println("Has tirado: " + options[userOption - 1] + "\n El ordenador ha tirado: "
						+ options[computerOption - 1] + result);
				break;
			}
			System.out.println("User wins: " + userWins + "\nComputer wins: " + computerWins + "\n");
		} while (userWins <= 4 && computerWins <= 4);

		result = (computerWins > userWins) ? "Has perdido :((" : "Has ganado!!!!";
		System.out.println(result);

		input.close();
	}

}

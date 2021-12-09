import java.util.Random;
import java.util.Scanner;

public class TresEnRaya {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Random rnd = new Random();

		final int boardHeight = 10;
		final int boardWidth = 4;

		char[][] board = new char[boardWidth][boardHeight];

		int userInput = 0;
		int computerInput = 0;
		int position = 0;
		int position2 = 0;

		do {
			System.out.println("A que columna desea tirar");

			userInput = input.nextInt();
			input.nextLine();

			computerInput = rnd.nextInt(4);

			if (Character.toLowerCase(board[userInput - 1][position]) != '\0' && Character.toLowerCase(board[computerInput][position2]) != 'X') {
				board[userInput - 1][position + 1] = 'O';
				position++;
			} else {
				board[userInput - 1][0] = 'O';
			}
			
			if (Character.toLowerCase(board[computerInput][position2]) != '\0' && Character.toLowerCase(board[computerInput][position2]) != 'O') {
				board[computerInput][position2 + 1] = 'X';
				position2++;
			} else {
				board[computerInput][0] = 'X';
			}
			

			for (int i = 9; i >= 0; i--) {
				for (int j = 3; j >= 0; j--) {
					/*if (Character.toLowerCase(board[j][i]) == '\0') {
						System.out.print(" _ ");
					} else if (Character.toLowerCase(board[j][i]) == 'o') {
						System.out.print(" O ");
					} else if (Character.toLowerCase(board[j][i]) == 'x') {
						System.out.print(" X ");
					}*/
					System.out.print(board[j][i]);
				}
				System.out.println();
			}
		} while (true);
		

	}

}

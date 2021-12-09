import java.util.Random;
import java.util.Scanner;

public class Examen2_1_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rnd = new Random();

		final int MAX_ROWS = 4;
		final int MAX_COLUMNS = 4;
		final int MAX_USER_TRY = 10;

		String[][] tablero = new String[MAX_ROWS][MAX_COLUMNS];
		String[][] tableroKill = new String[MAX_ROWS][MAX_COLUMNS];

		String userTry = "";
		int userTryCount = 0;

		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS; j++) {
				tablero[i][j] = "O";
			}
		}
		
		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS; j++) {
				tableroKill[i][j] = "O";
			}
		}
		
		for(int i = 0; i < 4; i++) {
			tableroKill[rnd.nextInt(4)][rnd.nextInt(4)] = "X";
		}

		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMNS - 1; j++) {
				System.out.print(tablero[0][j]);
			}
			System.out.println(tablero[i][0]);
		}

		System.out.println("A que casilla desea tirar \nFilas: ABCD \nColumnas: 1234");
		
		do {
			userTry = input.nextLine();

			switch (userTry.charAt(0)) {
			case 'A':
				switch (userTry.charAt(1)) {
					case '1':
						if (tableroKill[0][0].equals("X")) {
							tablero[0][0] = "P";
						} else {
							tablero[0][0] = "X";
						}
						break;
					case '2':
						if (tableroKill[0][1].equals("X")) {
							tablero[0][1] = "P";
						} else {
							tablero[0][1] = "X";
						}
						break;
					case '3':
						if (tableroKill[0][2].equals("X")) {
							tablero[0][2] = "P";
						} else {
							tablero[0][2] = "X";
						}
						break;
					case '4':
						if (tableroKill[0][3].equals("X")) {
							tablero[0][3] = "P";
						} else {
							tablero[0][3] = "X";
						}
						break;
				}
				break;
			case 'B':
				switch (userTry.charAt(1)) {
					case '1':
						if (tableroKill[1][0].equals("X")) {
							tablero[1][0] = "P";
						} else {
							tablero[1][0] = "X";
						}
						break;
					case '2':
						if (tableroKill[1][1].equals("X")) {
							tablero[1][1] = "P";
						} else {
							tablero[1][1] = "X";
						}
						break;
					case '3':
						if (tableroKill[1][2].equals("X")) {
							tablero[1][2] = "P";
						} else {
							tablero[1][2] = "X";
						}
						break;
					case '4':
						if (tableroKill[1][3].equals("X")) {
							tablero[1][3] = "P";
						} else {
							tablero[1][3] = "X";
						}
						break;
				}
				break;
			case 'C':
				switch (userTry.charAt(1)) {
					case '1':
						if (tableroKill[2][0].equals("X")) {
							tablero[2][0] = "P";
						} else {
							tablero[2][0] = "X";
						}
						break;
					case '2':
						if (tableroKill[2][1].equals("X")) {
							tablero[2][1] = "P";
						} else {
							tablero[2][1] = "X";
						}
						break;
					case '3':
						if (tableroKill[2][2].equals("X")) {
							tablero[2][2] = "P";
						} else {
							tablero[2][2] = "X";
						}
						break;
					case '4':
						if (tableroKill[2][3].equals("X")) {
							tablero[2][3] = "P";
						} else {
							tablero[2][3] = "X";
						}
						break;
				}
				break;
			case 'D':
				switch (userTry.charAt(1)) {
					case '1':
						if (tableroKill[3][0].equals("X")) {
							tablero[3][0] = "P";
						} else {
							tablero[3][0] = "X";
						}
						break;
					case '2':
						if (tableroKill[3][1].equals("X")) {
							tablero[3][1] = "P";
						} else {
							tablero[3][1] = "X";
						}
						break;
					case '3':
						if (tableroKill[3][2].equals("X")) {
							tablero[3][2] = "P";
						} else {
							tablero[3][2] = "X";
						}
						break;
					case '4':
						if (tableroKill[3][3].equals("X")) {
							tablero[3][3] = "P";
						} else {
							tablero[3][3] = "X";
						}
						break;
				}
				break;
			}
			
			for (int i = 0; i < MAX_ROWS; i++) {
				for (int j = 0; j < MAX_COLUMNS - 1; j++) {
					System.out.print(tablero[0][j]);
				}
				System.out.println(tablero[i][0]);
			}
			userTryCount++;
		} while (userTryCount < MAX_USER_TRY);

		input.close();
	}

}

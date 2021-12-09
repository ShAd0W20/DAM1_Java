import java.util.Random;
import java.util.Scanner;

public class Examen1_3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Random rnd = new Random();

		final int NOMBRE_CARRILES = 5;
		final int NOMBRE_POSICIONES = 10;

		String[] totalPlayes = new String[NOMBRE_CARRILES];
		int[] playerPoints = new int[NOMBRE_CARRILES];
		
		String canvio = "";
		int canvio2 = 0;
		
		for (int i = 0; i < NOMBRE_CARRILES; i++) {
			totalPlayes[i] = "Camello " + (i + 1);

			System.out.println(totalPlayes[i] + " -> " + playerPoints[i]);
		}

		System.out.println("Enter para empezar la ronda");
		input.nextLine();
		while(playerPoints[0] <= NOMBRE_POSICIONES) {
			
			
			for (int i = 0; i < NOMBRE_CARRILES; i++) {
				playerPoints[i] += rnd.nextInt(5);
				System.out.println(totalPlayes[i] + " -> " + playerPoints[i]);
			}
			for (int i = 0; i < totalPlayes.length - 1; i++) {

				for (int j = i + 1; j < playerPoints.length; j++) {

					if (playerPoints[i] < playerPoints[j]) {

						canvio = totalPlayes[i];

						totalPlayes[i] = totalPlayes[j];

						totalPlayes[j] = canvio;

						canvio2 = playerPoints[i];

						playerPoints[i] = playerPoints[j];

						playerPoints[j] = canvio2;

					}
				}
			}
			System.out.println("Enter para siguiente ronda");
			input.nextLine();
			
		}
		
		System.out.println("Ha ganado: " + totalPlayes[0]);

		input.close();
	}

}

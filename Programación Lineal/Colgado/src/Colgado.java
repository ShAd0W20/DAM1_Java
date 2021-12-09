import java.util.Scanner;

public class Colgado {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String availableWords[] = { "camisa", "adios", "rosa", "corazon", "automovil" };
		
		String finalWord = "";
		
		String gameWord = availableWords[(int) (Math.random() * availableWords.length)];
		String wordLetters[] = new String[gameWord.length()];
		
		String hiddenWord = "";
		
		String palabraresp[] = new String[gameWord.length()];
		
		for (int i = 0; i < gameWord.length(); i++) {
			wordLetters[i] = String.valueOf(gameWord.charAt(i));
			hiddenWord += "*";
			palabraresp[i] = "*";

		}
		
		System.out.println("Buesque la Palabra...");
		System.out.println();
		
		System.out.println(hiddenWord);

		int vidas = 5;
		
		String enteredLetter[] = new String[100];

		for (int q = 0; q < enteredLetter.length; q++) {
			System.out.println("Ingrese una letra: ");
			enteredLetter[q] = input.nextLine().toLowerCase();
			
			if (q >= 1) {
				for (int a = 0; a < q; a++) {
					if (enteredLetter[a].equalsIgnoreCase(enteredLetter[q])) {
						System.err.println("Ya has entrado esa letra, Intenta denuevo...");

					}
				}
			}

			if (gameWord.contains(enteredLetter[q]) == true) {

				if (gameWord.equalsIgnoreCase(enteredLetter[q])) {

					System.out.println("HAS GANADO, La palabra oculta era a: " + gameWord);
					System.exit(0);
				}
				
				for (int e = 0; e < gameWord.length(); e++) {
					if (enteredLetter[q].equalsIgnoreCase(wordLetters[e])) {
						palabraresp[e] = enteredLetter[q];
					}
				}
				
				String palabraW = "";
				for (int z = 0; z < gameWord.length(); z++) {
					palabraW = palabraW + palabraresp[z];
				}
				
				finalWord = palabraW;
				
				System.out.println(palabraW);
				System.out.println();

			} else {
				
				System.out.println(" no esta, una vida menos");
				vidas--;
				
				String palabraL = "";
				for (int z = 0; z < gameWord.length(); z++) {
					palabraL = palabraL + palabraresp[z];
				}
				
				System.out.println(palabraL);
				System.out.println();
				
				if (vidas == 0) {
					System.out.println("GAME OVER!");
					System.exit(0);
				}
			}
			
			if (finalWord.equalsIgnoreCase(gameWord)) {

				System.out.println("HAS GANADO, La palabra oculta era: " + gameWord);
			}

		}
		
		input.close();

	}

}

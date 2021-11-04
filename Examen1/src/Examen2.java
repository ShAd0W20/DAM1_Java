import java.util.Random;
import java.util.Scanner;

public class Examen2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rnd = new Random();
		
		final int maxWinWords = 3;
		
		String menuOption = "";
		
		String[] adivinaP = {"Cuadrado", "Rectangulo", "Triangulo", "Circulo", "Hexagono"};
		int randomWord = 0;		
		String winWord = "";
		String[] userWinWords = new String[maxWinWords];
		
		int computerWinNumber = 101;
		int userWinNumber = 101;
		int userTry = 0;
		
		System.out.println("A que desea jugar? \n P: Adivinar palabra \n N: Adivinar numero \n S: Salir del programa");
		do {
			menuOption = input.nextLine();
			switch(menuOption.toLowerCase()) {
			case "p":
				System.out.println("Has entrado adivinar una palabra");
				for(int i = 0; i < maxWinWords; i++ ) {
					randomWord = rnd.nextInt(5);
					winWord = adivinaP[randomWord];
				}
				//System.out.println(winWord); just testing
				
				System.out.println("Introduce 3 palabras separadas por espacios");
				for(int i = 0; i < maxWinWords; i++ ) {
					userWinWords[i] = input.next();
				}
				input.nextLine();
				
				int j = 0;				
				while(!userWinWords[j].toLowerCase().equals(winWord.toLowerCase()) && j < maxWinWords - 1) {
					j++;
				}
				
				if(userWinWords[j].toLowerCase().equals(winWord.toLowerCase())) {
					System.out.println("Feliciades, has acertado la palabra secreta: " + winWord);
				} else {
					System.out.println("Lo sentimos la palabra secreta era: " + winWord);
				}
				
				break;
			case "n":
				System.out.println("Has entrado adivinar un numero");
				computerWinNumber = rnd.nextInt(100);
				
				System.out.println(computerWinNumber);
				System.out.println("Introduce un numero");
				
				do {
					userWinNumber = input.nextInt();
					input.nextLine();
					userTry++;
					if(userWinNumber < computerWinNumber) {
						System.out.println("El numero secreto es mayor al introducido");
					} else if(userWinNumber > computerWinNumber) {
						System.out.println("El numero secreto es menor al introducido");
					}
					System.out.println("Introduce un numero");
				} while(userWinNumber != computerWinNumber);
				
				if(userWinNumber == computerWinNumber) {
					System.out.println("Felicidades has acertado el numero secreto: " + computerWinNumber + " con: " + userTry + " intentos");
				}
				break;
			default:
				if(!menuOption.toLowerCase().equals("s")) {
					System.out.println("A que desea jugar? \n P: Adivinar palabra \n N: Adivinar numero \n S: Salir del programa");
				}
			}
		} while(!menuOption.toLowerCase().equals("s"));
		
		System.out.println("Has salido del programa");
		input.close();
	}

}

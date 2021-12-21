import java.util.Scanner;

public class JuegosDeCinta {

	public static void main(String[] args) {
		/*
		 	10 4
			7 7 3 3
			10 3
			4 7 7
		 */
		
		Scanner input = new Scanner(System.in);
		
		int[] capacidadCaraCinta = new int[2];
		int capacidadCinta = 0;
		int totalAGuardar = 0;
		
		while(!input.hasNextInt()) {
			input.next();
		}
		capacidadCaraCinta[0] = input.nextInt();
		while(!input.hasNextInt()) {
			input.next();
		}
		capacidadCaraCinta[1] = input.nextInt();
		input.nextLine();
		
		capacidadCinta = capacidadCaraCinta[0];
		totalAGuardar = capacidadCaraCinta[1];
		
		int[] cinta = new int[totalAGuardar];
		String[] idJuegosAGuardar = new String[totalAGuardar];
		
		idJuegosAGuardar = input.nextLine().split(" ");
		
		for(int i = 0; i < totalAGuardar; i++) {
			cinta[i] = Integer.parseInt(idJuegosAGuardar[i]);
		}
		
		if(canBeSaved(capacidadCinta, totalAGuardar, cinta)) {
			System.out.println("SI");
		} else {
			System.out.println("NO");
		}
	}
	
	static boolean canBeSaved(int max, int maxGames, int[] cinta) {
		for(int i = 0; i < maxGames; i++) {
			if(i < maxGames) {
				if(cinta[i] != cinta[i + 1]) {
					if((cinta[i] + cinta[i + 1]) > max) {
						return false;
					} else {
						return true;
					}
				}
				if(cinta[i] == cinta[i + 1]) {
					return true;
				}
			}		
		}
		
		return false;
	}

}

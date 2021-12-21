import java.util.Scanner;
import java.util.regex.Pattern;

public class SpaceInvader {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int row = 0;
		int maxPunctuations = 0;
		String word = "";
		
		do {
			while(!input.hasNextInt()) {
				input.next();
			}
			maxPunctuations = input.nextInt();
			input.nextLine();
		} while(maxPunctuations <= 0 || maxPunctuations > 20);
		
		for(int k = 0; k < maxPunctuations; k++) {
			while(!input.hasNextInt()) {
				input.next();
			}
			row = input.nextInt();
			input.nextLine();
			char[][] letras = new char[row][3];
			
			for(int i = 0; i < row; i++) {
				while(!Pattern.matches("[a-zA-z][0-9]{3}", input.nextLine())) {
					input.next();
				}
				word = input.nextLine();
				letras[i][0] = word.charAt(0);
				letras[i][1] = word.charAt(1);
				letras[i][2] = word.charAt(2);
			}
			
			for (int j = 0; j < 3; j++) {
				for(int i = 0; i < row; i++) {
					System.out.print(letras[i][j]);
				}
			}
		}
		
		input.close();
	}

}

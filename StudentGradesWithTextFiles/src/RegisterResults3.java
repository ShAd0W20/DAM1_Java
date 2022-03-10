import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class RegisterResults3 {

	public static void main(String[] args) throws FileNotFoundException {
		File results = new File("results.txt");
		Scanner fileData = new Scanner(results);
		Scanner input = new Scanner(System.in);
		String[][] studentNames = new String[5][3];
		int[][] studentGrades = new int[5][4];
		
		int i = 0;
		while(fileData.hasNextLine()) {
			studentNames[i][0] = fileData.next();
			studentNames[i][1] = fileData.next();
			studentNames[i][2] = fileData.next();
			studentGrades[i][0] = fileData.nextInt();
			studentGrades[i][1] = fileData.nextInt();
			studentGrades[i][2] = fileData.nextInt();
			studentGrades[i][3] = fileData.nextInt();
			fileData.nextLine();
			i++;
		}

		fileData.close();
		
		for(int j = 0; j < studentNames.length; j++) {
			System.out.printf("Introduce la nota para la UF de Fitxers de %s %s %n", studentNames[j][1], studentNames[j][2]);
			studentGrades[j][2] = input.nextInt();
			input.nextLine();
			
			System.out.printf("Introduce la nota para la UF de Programació Orientada a Objecte de %s %s %n", studentNames[j][1], studentNames[j][2]);
			studentGrades[j][3] = input.nextInt();
			input.nextLine();
		}
		
		PrintStream stream = new PrintStream(results);
		
		for(int j = 0; j < studentNames.length; j++) {
			for(int l = 0; l < studentNames[j].length; l++) {
				stream.print(studentNames[j][l] + " ");
			}
			for(int k = 0; k < studentGrades[j].length; k++) {
				stream.print("" + " " + studentGrades[j][k]);
			}
			stream.println();
		}
		
		stream.close();
		
		
		input.close();

	}

}

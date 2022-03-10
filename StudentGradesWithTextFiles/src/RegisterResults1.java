import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class RegisterResults1 {

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
			fileData.nextLine();
			i++;
		}

		fileData.close();
		
		for(int j = 0; j < studentNames.length; j++) {
			System.out.printf("Introduce la nota para la UF de Programació Estructurada de %s %s %n", studentNames[j][1], studentNames[j][2]);
			studentGrades[j][0] = input.nextInt();
			input.nextLine();
		}
		
		for(int j = 0; j < studentNames.length; j++) {
			for(int k = 1; k < studentGrades[j].length; k++) {
				studentGrades[j][k] = -1;
			}
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

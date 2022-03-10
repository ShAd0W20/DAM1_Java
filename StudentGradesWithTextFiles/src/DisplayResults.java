import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplayResults {

	public static void main(String[] args) throws FileNotFoundException {
		File results = new File("results.txt");
		Scanner fileData = new Scanner(results);
		String[][] studentNames = new String[5][3];
		int[][] studentGrades = new int[5][4];
		
		String[] grades = {"Programació Estructurada", "Programació Modular", "Fitxers", "Programació Orientada a Objecte"};
		
		int t = 0;
		while(fileData.hasNextLine()) {
			studentNames[t][0] = fileData.next();
			studentNames[t][1] = fileData.next();
			studentNames[t][2] = fileData.next();
			studentGrades[t][0] = fileData.nextInt();
			studentGrades[t][1] = fileData.nextInt();
			studentGrades[t][2] = fileData.nextInt();
			studentGrades[t][3] = fileData.nextInt();
			fileData.nextLine();
			t++;
		}

		fileData.close();
		
		for(int i = 0; i < studentNames.length; i++) {
			System.out.printf("-".repeat(50) + " %n%n%5s: %s %s %n%n", "Nom", studentNames[i][1], studentNames[i][2].replace('_', ' '));
			for(int j = 0; j < studentGrades[i].length; j++) {
				if(studentGrades[i][j] != -1) {
					System.out.printf("%10s%d %s: %d %n", "[+] UF", (j + 1), grades[j], studentGrades[i][j]);
				}
			}
			System.out.printf("%n");
		}

	}

}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExportToCSV {

	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("results.txt");
		Scanner fileData = new Scanner(data);
		
		File exportToCSV = new File("toCSV.csv");
		
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
		
		PrintStream stream = new PrintStream(exportToCSV);
		stream.printf("%s;%s;%s;%s;%s;%s;%s%n", "DNI", "Nom", "Cognoms", "Programació Estructurada", "Programació Modular", "Programació amb Fitxers", "Programació Orientada a Objecte");
		for(int j = 0; j < studentNames.length; j++) {
			stream.printf("%s;%s;%s;", studentNames[j][0], studentNames[j][1], studentNames[j][2].replace('_', ' '));
			stream.printf("%d;%d;%d;%d", studentGrades[j][0], studentGrades[j][1], studentGrades[j][2], studentGrades[j][3]);
			stream.println();
		}
		
		stream.close();
	}

}

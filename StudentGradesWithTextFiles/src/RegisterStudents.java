import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RegisterStudents {

	public static void main(String[] args) {
		File results = new File("results.txt");
		Scanner input = new Scanner(System.in);
		ArrayList<String> studentID = new ArrayList<String>();
		ArrayList<String> studentNames = new ArrayList<String>();
		ArrayList<String> studentSurnames = new ArrayList<String>();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Introduce el DNI del alumno");
			studentID.add(input.nextLine());
			
			System.out.println("Introduce el nombre del alumno");
			studentNames.add(input.nextLine());
			
			System.out.println("Introduce el apellido del alumno");
			studentSurnames.add(input.nextLine());
		}
		
		try {
			PrintStream stream = new PrintStream(results);
			
			for(int i = 0; i < studentID.size(); i++) {
				stream.printf("%s %s %s %n", studentID.get(i), studentNames.get(i).replace(" ", "_"), studentSurnames.get(i));
			}
			
			stream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		input.close();
	}

}

package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import models.Alumno;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner userInput = new Scanner(System.in);

		//File to save data
		File fileToSave = new File("Alumnos.txt");

		// Arrays of grades and student objects
		ArrayList<Alumno> students = new ArrayList<Alumno>();
		String[] grades = { "SMX", "DAM", "DAW" };

		// Menu option controller
		String mainMenuOption = "";

		getDataFromFile(fileToSave, students);

		System.out.println("Que desea hacer? \n[1] Registrar alumno \n[2] Listar alumnos \n[3] Guardar datos \n[Salir] para salir");
		do {
			mainMenuOption = userInput.nextLine();
			switch (mainMenuOption) {
			case "1":
				Alumno a = new Alumno();

				System.out.println("Introduce el DNI del alumno");
				a.setDni(userInput.nextLine());

				System.out.println("Introduce el nombre del alumno");
				a.setName(userInput.nextLine());

				System.out.println("Introduce la fecha de nacimiento del alumno -> dd/mm/yy");
				a.setBirthDate(LocalDate.parse(userInput.nextLine(), DateTimeFormatter.ofPattern("d/M/y")));

				System.out.println("Introduce el ciclo del alumno");
				a.setGradeID(userInput.nextInt());
				userInput.nextLine();

				students.add(a);

				break;
			case "2":
				for (Alumno student : students) {
					System.out.println("[+] " + student.getDni() + " " + student.getName() + " " + student.getBirthDate().format(DateTimeFormatter.ofPattern("d/M/y")) + " " + grades[student.getGradeID() - 1]);
				}
				break;
			case "3":
				saveDataToFile(fileToSave, students);
				break;
			default:
				if (!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.println("Que desea hacer? \n[1] Registrar alumno \n[2] Listar alumnos \n[3] Guardar datos \n[Salir] para salir");
				}
			}
		} while (!mainMenuOption.equalsIgnoreCase("salir"));

		userInput.close();
		
		saveDataToFile(fileToSave, students);

		System.out.println("\n\n[!] Saliendo...");

	}

	static void getDataFromFile(File fileToSave, ArrayList<Alumno> students) throws FileNotFoundException {
		Scanner fileInput = new Scanner(fileToSave);
		while (fileInput.hasNextLine()) {
			Alumno alumn = new Alumno();
			alumn.setDni(fileInput.next());
			alumn.setName(fileInput.next());
			alumn.setBirthDate(LocalDate.parse(fileInput.next()));
			alumn.setGradeID(fileInput.nextInt());
			fileInput.nextLine();
			students.add(alumn);
		}
		fileInput.close();
	}

	static void saveDataToFile(File fileToSave, ArrayList<Alumno> students) throws FileNotFoundException {
		PrintStream output = new PrintStream(fileToSave);
		for (Alumno student : students) {
			output.println(student.getDni() + " " + student.getName() + " " + student.getBirthDate() + " " + student.getGradeID());
		}
		output.close();
	}

}

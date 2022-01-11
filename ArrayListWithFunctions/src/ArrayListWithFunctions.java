import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListWithFunctions {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<String> studentNames = new ArrayList<String>();

		mainMenu(studentNames);

	}

	static void mainMenu(ArrayList<String> studentNames) {
		String mainMenuOption = "";

		System.out.println("Que desea hacer? \n[1] Registrar alumno. \n[2] Borrar alumno. \n[3] Listar alumnos. \n['Salir'] Para salir del programa");

		do {
			mainMenuOption = input.nextLine();
			switch (mainMenuOption) {
			case "1":
				registerNewStudent(studentNames);
				break;
			case "2":
				deleteStudent(studentNames);
				break;
			case "3":
				showAllStudent(studentNames);
				break;
			default:
				if (!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.println("Que desea hacer? \n[1] Registrar alumno. \n[2] Borrar alumno. \n[3] Listar alumnos. \n['Salir'] Para salir del programa");
				}
			}
		} while (!mainMenuOption.equalsIgnoreCase("salir"));

	}

	static void registerNewStudent(ArrayList<String> studentNames) {
		String enteredStudentName = "";

		System.out.println("Introduce el nombre del alumno");
		enteredStudentName = input.nextLine();

		while (studentExistInArray(studentNames, enteredStudentName)) {
			System.out.println("Alumno ya existente. Introduce otro nombre");
			enteredStudentName = input.nextLine();
		}

		addStudentToArray(studentNames, enteredStudentName);

		System.out.println("Alumno registrado. Pulse 'enter' para volver al menu.");
	}

	static void addStudentToArray(ArrayList<String> studentNames, String studentNameToSave) {
		studentNames.add(studentNameToSave);
	}

	static void deleteStudent(ArrayList<String> studentNames) {
		String studentToDelete = "";

		System.out.println("Introduce el nombre del alumno a borrar");
		studentToDelete = input.nextLine();

		while (!studentExistInArray(studentNames, studentToDelete)) {
			System.out.println("Vuelve a introducir el nombre del alumno");
			studentToDelete = input.nextLine();
		}
		deleteStudentFromArray(studentNames, studentToDelete);
	}

	static void deleteStudentFromArray(ArrayList<String> studentNames, String studentToDelete) {
		studentNames.remove(studentNames.indexOf(studentToDelete));
	}

	static void showAllStudent(ArrayList<String> studentNames) {
		for (int i = 0; i < studentNames.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + studentNames.get(i));
		}
	}

	static boolean studentExistInArray(ArrayList<String> studentNames, String studentToDelete) {

		if (studentNames.indexOf(studentToDelete) == -1) {
			return false;
		}
		return true;
	}
}

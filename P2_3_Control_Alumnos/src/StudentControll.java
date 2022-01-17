import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentControll {

	static Scanner input = new Scanner(System.in);
	final static String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	public static void main(String[] args) {
		
		final int TOTA_GRADES = 3;
		final int TOTAL_SUBJECTS_IN_GRADES = 4;
		
		ArrayList<String> studentName = new ArrayList<String>();
		ArrayList<String> studentID = new ArrayList<String>();
		ArrayList<LocalDate> studentBirthDate = new ArrayList<LocalDate>();
		ArrayList<Integer> studentGrade = new ArrayList<Integer>();
		
		String[][] schoolGrades = new String[TOTA_GRADES][TOTAL_SUBJECTS_IN_GRADES];
		schoolGrades[0][0] = "SMX"; schoolGrades[0][1] = "M1"; schoolGrades[0][2] = "M2"; schoolGrades[0][3] = "M3";
		schoolGrades[1][0] = "DAM"; schoolGrades[1][1] = "M4"; schoolGrades[1][2] = "M5"; schoolGrades[1][3] = "M6";
		schoolGrades[2][0] = "DAW"; schoolGrades[2][1] = "M7"; schoolGrades[2][2] = "M8"; schoolGrades[2][3] = "M9";
		
		studentName.add("Pepe"); studentID.add("49184488E"); studentBirthDate.add(LocalDate.now()); studentGrade.add(0);
		studentName.add("Pepa"); studentID.add("49184486E"); studentBirthDate.add(LocalDate.now()); studentGrade.add(1);
		studentName.add("Maria"); studentID.add("49184865E"); studentBirthDate.add(LocalDate.now()); studentGrade.add(1);
		studentName.add("Laura"); studentID.add("59184865E"); studentBirthDate.add(LocalDate.now()); studentGrade.add(2);
		
		mainMenu(studentName, studentID, studentBirthDate, studentGrade, schoolGrades);
		input.close();
	}
	
	static void mainMenu(ArrayList<String> studentName, ArrayList<String> studentID, ArrayList<LocalDate> studentBirthDate, ArrayList<Integer> studentGrade, String[][] schoolGrades) {
		String mainMenuOption = "";

		System.out.println("Que desea hacer? \n[1] Registrar alumno. \n[2] Eliminar alumno. \n[3] Buscar alumno. \n[4] Listar ciclos del instituto. \n[5] Listar ciclo y modulos que hace un alumno. \n[6] Listar alumnos de un ciclo. \n[7] Listar todos los alumnos agrupados por ciclo. \n['Salir'] para salir del programa");
		
		do {
			mainMenuOption = input.nextLine();
			
			switch (mainMenuOption) {
			case "1":
				registerStudent(studentName, studentID, studentBirthDate, studentGrade, schoolGrades);
				break;
			case "2":
				deleteStudent(studentName, studentID, studentBirthDate, studentGrade, schoolGrades);
				break;
			case "3":
				searchStudent(studentName, studentID, studentBirthDate, studentGrade, schoolGrades);
				break;
			case "4":
				printSchoolGradesInfo(schoolGrades);
				System.out.println("Pulse enter para volver al menu.");
				break;
			case "5":
				printStudentGradeInfo(studentName, studentID, studentBirthDate, studentGrade, schoolGrades);
				break;
			case "6":
				printStudentInSameGrade(studentName, studentID, studentBirthDate, studentGrade, schoolGrades);
				break;
			case "7":
				printStudentByGrade(studentName, studentID, studentBirthDate, studentGrade, schoolGrades);
				break;
			default:
				if(!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.println("Que desea hacer? \n[1] Registrar alumno. \n[2] Eliminar alumno. \n[3] Buscar alumno. \n[4] Listar ciclos del instituto. \n[5] Listar ciclo y modulos que hace un alumno. \n[6] Listar alumnos de un ciclo. \n[7] Listar todos los alumnos agrupados por ciclo. \n['Salir'] para salir del programa");					
				}
			}	
		} while (!mainMenuOption.equalsIgnoreCase("salir"));
	}
	
	/*Method to register new student into the array*/
	static void registerStudent(ArrayList<String> studentName, ArrayList<String> studentID, ArrayList<LocalDate> studentBirthDate, ArrayList<Integer> studentGrade, String[][] schoolGrades) {
		String enteredStudentName = "";
		String enteredStudentID = "";
		String enteredStudentBirthDate = "";
		int enteredStudentGrade = 0;
		
		System.out.println("Introduce el nombre del alumno");
		enteredStudentName = input.nextLine();
		
		/*We call a function that will check if the student name already exists if not it will be saved*/
		while(searchStudentInArray(studentName, enteredStudentName) >= 0) {
			System.out.println("Alumno ya registrado. Introduzca otro nombre.");
			enteredStudentName = input.nextLine();
		}
		
		studentName.add(enteredStudentName);
		
		System.out.println("Introduce el DNI del alumno");
		enteredStudentID = input.nextLine();
		
		/* We call a function that will check if the student id (dni) already exists and if it's a valid DNI
		 * While it doesn't have the correct format or while it has already being registered keep asking
		 */
		while(!validateStudentID(enteredStudentID) || searchStudentInArray(studentID, Integer.parseInt(enteredStudentID.substring(0, 8))) >= 0) {
			System.out.println("DNI incorrecto o ya registrado. Introduzca otro DNI valido.");
			enteredStudentID = input.nextLine();
		}
		
		studentID.add(enteredStudentID);
		
		System.out.println("Introduzca la fecha de nacimiento del alumno. Formato: dd/mm/aa");
		enteredStudentBirthDate = input.nextLine();
		
		/* We call a function that will check if the student birth day has a correct format following the above ask format
		 * While it doesn't have the correct format keep asking for a valid birth day format
		 */
		while(!validateStudentBirthDate(enteredStudentBirthDate)) {
			System.out.println("Fecha incorrecta. Introduzca otra fecha valida.");
			enteredStudentBirthDate = input.nextLine();
		}
		
		studentBirthDate.add(LocalDate.parse(enteredStudentBirthDate, DateTimeFormatter.ofPattern("d/M/y")));

		printSchoolGradesInfo(schoolGrades);
		System.out.println("Introduzca el numero del ciclo al que pertenece el alumno");
		enteredStudentGrade = input.nextInt() - 1;
		input.nextLine();
		studentGrade.add(enteredStudentGrade);
		
		System.out.println("Alumno registrado. Pulse enter para volver al menu.");
	}
	
	/*Method that will allow us to delete 1 student from the array*/
	static void deleteStudent(ArrayList<String> studentName, ArrayList<String> studentID, ArrayList<LocalDate> studentBirthDate, ArrayList<Integer> studentGrade, String[][] schoolGrades) {
		String searchMenuOption = "";
		String searchStudent = "";
		String finalDecision = "";
		
		System.out.println("Como desea buscar el alumno. \n[1] Por nombre. \n[2] Por DNI.");
		searchMenuOption = input.nextLine();
		
		switch (searchMenuOption) {
		case "1":
			System.out.println("Introduce el nombre del alumno");
			searchStudent = input.nextLine();
			/*Check if the student exists in the names array in order to continue the program*/
			if(searchStudentInArray(studentName, searchStudent) < 0) {
				System.out.println("El nombre introducido no esta registrado. Pulse enter para volver al menu.");
			} else {
				/*Print the student info follower by the grade that student is in*/
				System.out.println(studentInfo(studentName, studentID, studentBirthDate, searchStudentInArray(studentName, searchStudent)));
				
				System.out.println(studentGradeInfo(schoolGrades, searchGradeID(studentGrade, searchStudentInArray(studentName, searchStudent))));
				
				/*Ask is we are sure that we what to delete the student*/
				System.out.println("Esta seguro que desea eliminar este alumno? \n[+] Si. \n[+] No.");
				finalDecision = input.nextLine();
				
				if(finalDecision.equalsIgnoreCase("si")) {
					studentID.remove(searchStudentInArray(studentName, searchStudent));
					studentBirthDate.remove(searchStudentInArray(studentName, searchStudent));
					studentGrade.remove(searchStudentInArray(studentName, searchStudent));
					studentName.remove(searchStudentInArray(studentName, searchStudent));
					System.out.println("Alumno eliminado con exito. Pulsa enter para volver al menu.");
				} else {
					System.out.println("Proceso cancelado. Pulse enter para volver al menu");
				}
			}
			
			break;
		case "2":
			System.out.println("Introduce el DNI del alumno");
			searchStudent = input.nextLine();
			/*Check if the student ID (dni) exists in the studentID array in order to continue*/
			if(searchStudentInArray(studentID, Integer.parseInt(searchStudent.substring(0, 8))) < 0) {
				System.out.println("El DNI introducido no esta registrado");
			} else {
				/*Print the student info follower by the grade that student is in*/
				System.out.println(studentInfo(studentName, studentID, studentBirthDate, searchStudentInArray(studentID, Integer.parseInt(searchStudent.substring(0, 8)))));
				
				System.out.println(studentGradeInfo(schoolGrades, searchGradeID(studentGrade, searchStudentInArray(studentID, Integer.parseInt(searchStudent.substring(0, 8))))));
				
				/*Ask is we are sure that we what to delete the student*/
				System.out.println("Esta seguro que desea eliminar este alumno? \n[+] Si. \n[+] No.");
				finalDecision = input.nextLine();
				if(finalDecision.equalsIgnoreCase("si")) {
					studentName.remove(searchStudentInArray(studentID, Integer.parseInt(searchStudent.substring(0, 8))));
					studentGrade.remove(searchStudentInArray(studentID, Integer.parseInt(searchStudent.substring(0, 8))));
					studentBirthDate.remove(searchStudentInArray(studentID, Integer.parseInt(searchStudent.substring(0, 8))));
					studentID.remove(searchStudentInArray(studentID, Integer.parseInt(searchStudent.substring(0, 8))));
					System.out.println("Alumno eliminado con exito. Pulsa enter para volver al menu.");
				} else {
					System.out.println("Proceso cancelado. Pulse enter para volver al menu");
				}
			}
			
			break;
		}
	}

	/*Method to search student by name or ID (dni) in the arrays*/
	static void searchStudent(ArrayList<String> studentName, ArrayList<String> studentID, ArrayList<LocalDate> studentBirthDate, ArrayList<Integer> studentGrade, String[][] schoolGrades) {
		String searchMenuOption = "";
		String searchStudent = "";
		
		/*Ask for the search method*/
		System.out.println("Como desea buscar el alumno. \n[1] Por nombre. \n[2] Por DNI.");
		searchMenuOption = input.nextLine();
		
		switch (searchMenuOption) {
		case "1":
			System.out.println("Introduce el nombre del alumno");
			searchStudent = input.nextLine();
			/* Check if the student name is registered in the array */
			if(searchStudentInArray(studentName, searchStudent) < 0) {
				System.out.println("El nombre introducido no esta registrado");
			} else {
				/* Prints the student info along with the grade of the student */
				System.out.println(studentInfo(studentName, studentID, studentBirthDate, searchStudentInArray(studentName, searchStudent)));
				
				System.out.println(studentGradeInfo(schoolGrades, searchGradeID(studentGrade, searchStudentInArray(studentName, searchStudent))));
				
				System.out.println("Pulse enter para volver al menu");
			}
			
			break;
		case "2":
			System.out.println("Introduce el DNI del alumno");
			searchStudent = input.nextLine();
			/* Check if the student ID is registered in the array */
			if(searchStudentInArray(studentID, Integer.parseInt(searchStudent.substring(0, searchStudent.length() - 1))) < 0) {
				System.out.println("El DNI introducido no esta registrado");
			} else {
				/* Prints the student info along with the grade of the student */
				System.out.println(studentInfo(studentName, studentID, studentBirthDate, searchStudentInArray(studentID, Integer.parseInt(searchStudent.substring(0, searchStudent.length() - 1)))));
				
				System.out.println(studentGradeInfo(schoolGrades, searchGradeID(studentGrade, searchStudentInArray(studentID, Integer.parseInt(searchStudent.substring(0, searchStudent.length() - 1))))));
				
				System.out.println("Pulse enter para volver al menu");
			}
			
			break;
		}
	}
	
	/* Method that will return all school grades whit their subjects */
	static void printSchoolGradesModulesInfo(String[][] schoolGrades) {
		for (int i = 0; i < schoolGrades.length; i++) {
			for (int j = 0; j < schoolGrades[i].length; j++) {
				System.out.print(schoolGrades[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Pulse enter para volver al menu.");
	}
	
	/* Method that will return just the school grade names with help of the function */
	static void printSchoolGradesInfo(String[][] schoolGrades) {
		System.out.println(schoolGradesPrint(schoolGrades));
	}
	
	/* Redundant method to print the student grade info */
	static void printStudentGradeInfo(ArrayList<String> studentName, ArrayList<String> studentID, ArrayList<LocalDate> studentBirthDate, ArrayList<Integer> studentGrade, String[][] schoolGrades) {
		searchStudent(studentName, studentID, studentBirthDate, studentGrade, schoolGrades);
	}
	
	/* Method used to print all students in the same grade */
	static void printStudentInSameGrade(ArrayList<String> studentName, ArrayList<String> studentID, ArrayList<LocalDate> studentBirthDate, ArrayList<Integer> studentGrade, String[][] schoolGrades) {
		String gradeToShow = "";
		printSchoolGradesInfo(schoolGrades);
		System.out.println("De que ciclo desea la informacion.");
		gradeToShow = input.nextLine();
		
		for(int i = 0; i < studentName.size(); i++) {
			if((Integer.parseInt(gradeToShow) - 1) == studentGrade.get(i)) {
				System.out.println(studentInfo(studentName, studentID, studentBirthDate, i));
			}
		}
		System.out.println("Pulse enter para volver al menu.");
	}
	
	/* Method that will print all students ordered by their grade */
	static void printStudentByGrade(ArrayList<String> studentName, ArrayList<String> studentID, ArrayList<LocalDate> studentBirthDate, ArrayList<Integer> studentGrade, String[][] schoolGrades) {
				
		for(int j = 0; j < schoolGrades.length; j++) {
			System.out.println("\n" + schoolGrades[j][0]);
			for(int i = 0; i < studentName.size(); i++) {
				if(studentGrade.get(i) == j) {
					System.out.println(studentInfo(studentName, studentID, studentBirthDate, i));
				}
			}
		}
		System.out.println("Pulse enter para volver al menu.");
	}
	
	/* Function that will return the student position in the ArrayList by searching it with the 'studentNameToSearch' parameter */
	static int searchStudentInArray(ArrayList<String> studentName, String studentNameToSearch) {
		if (studentName.indexOf(studentNameToSearch) == -1) {
			return -1;
		}
		return studentName.indexOf(studentNameToSearch);
	}
	
	/* Function that will return the student position in the ArrayList by searching it with the 'studentIDToSearch' parameter that will have to be an integer */
	static int searchStudentInArray(ArrayList<String> studentID, int studentIDToSearch) {
		
		for(int i = 0; i < studentID.size(); i++) {
			if(studentID.get(i).substring(0, 8).equals(Integer.toString(studentIDToSearch))) {
				return i;
			}
		}
		
		return -1;
	}
	
	/* Boolean function to check if it's a valid student ID (dni) or not */
	static boolean validateStudentID(String studentID) {
		
		if(studentID.length() != 9 ) {
			return false;
		} else {			
			String intPartDNI = studentID.trim().replaceAll(" ", "").substring(0, 8);
			char ltrDNI = studentID.charAt(8);
			if(intPartDNI.matches("[0-9]{8}") == false) {
				return false;
			} else {
				int valNumDNI = Integer.parseInt(intPartDNI) % 23;
				
				if (dniChars.charAt(valNumDNI) != ltrDNI) {
					return false;
				} else {
					return true;
				}
			}
		}
	}
	
	/* Boolean function to check if the entered student birth date is in a valid format following the 'day/month/year' format */
	static boolean validateStudentBirthDate(String studentBirthDate) {
		
		try {
			LocalDate.parse(studentBirthDate, DateTimeFormatter.ofPattern("d/M/y"));
		} catch (DateTimeParseException  e) {
			return false;
		}		
		return true;
	}
	
	/* Function that will return an String whit the school grade names */
	static String schoolGradesPrint(String[][] schoolGrades) {
		String grades = "";
		for (int i = 0; i < schoolGrades.length; i++) {
			grades += ("["+ (i + 1) + "] " + schoolGrades[i][0]) + "\n";
		}
		return grades;
	}
	
	/* Function that will return the student info based on the student position in the array determined by the parameter 'studentPosInArray' */
	static String studentInfo(ArrayList<String> studentName, ArrayList<String> studentID, ArrayList<LocalDate> studentBirthDate, int studentPosInArray) {
		String data = "";
		data += studentName.get(studentPosInArray) + " - ";
		data += studentID.get(studentPosInArray) + " - ";
		data += studentBirthDate.get(studentPosInArray).getDayOfMonth() + "/" + studentBirthDate.get(studentPosInArray).getMonthValue() + "/" + studentBirthDate.get(studentPosInArray).getYear();
		
		return data;
	}

	/* Integer function that will return the student grade info from the array */
	static int searchGradeID(ArrayList<Integer> studentGrade, int studentPosInArray) {
		return studentGrade.get(studentPosInArray);
	}

	/* Function that will return the student grade and their subjects */
	static String studentGradeInfo(String[][] schoolGrades, int gradeID) {
		String result = "";
		for(int j = 0; j < schoolGrades[gradeID].length; j++) {
			result += schoolGrades[gradeID][j] + " ";
		}
		return result;
	}

}

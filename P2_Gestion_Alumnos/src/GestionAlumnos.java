import java.util.Scanner;

public class GestionAlumnos {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Scanner to use for user input from the console

		final int TOTAL_STUDENTS = 30;
		
		String[] studentName = new String[TOTAL_STUDENTS]; // String array to store students names
		int[] studentAge = new int[TOTAL_STUDENTS]; // int array to store students age
		String[] studentStudies = new String[TOTAL_STUDENTS]; // String array to store students studies
		boolean[] studentRepeater = new boolean[TOTAL_STUDENTS]; // boolean array to store if students are repeaters or not

		String[] studiesType = {"CFGM", "Bachillerato", "Prueba de acceso"};
		
		int totalStudentsInArray = 0; // integer to know how many students have we stored in the arrays

		String menuOption = ""; // string to know what's the user option in the main menu
		String menuNewStudent = ""; // string to know what's the user option in the main menu
		String listStudentRepeater = "";  // String used to difference between studentRepeater boolean
		String userInputStudentName = ""; // String variable to know what student user whant's to update
		char userChangeOption = '0'; //char variable to know what value to change
		char userInputStudentRepeater = '0'; //char variable to get user input new student repeater
		byte userStudentSetStudies = 0; //byte variable to get user input student studies
		int studentIndexToDelete = 0; //int variable to know which student we want to delete

		System.out.println("Introduce que desea hacer: \n 1 - Registrar alumno \n 2 - Modificar datos de 1 alumno \n 3 - Lista de todos los alumnos \n 4 - Borrar un alumno \n 'Salir' para salir del programa");
		do {
			menuOption = input.nextLine(); // Assign user input to variable 'menuOption' in order to enter the different menu options

			switch (menuOption) { // switch main menu
				case "1": 
					if (totalStudentsInArray == TOTAL_STUDENTS) { //if arrays are full exit
						System.out.println("No puedes registrar mas alumnos");
					} else {						
						do { //ask to enter new students while user don't input word 'salir' or while arrays are not full
							System.out.println("Introduce el nombre del alumno o 'Salir' para ir al menu principal");
							menuNewStudent = input.nextLine(); // save student name to variable
		
							if(!menuNewStudent.toLowerCase().equals("salir")) { // if variable value no equals to word 'salir' continue
								studentName[totalStudentsInArray] = menuNewStudent; // save student name to array with index of total students
								
								System.out.println("Introduce la edad del alumno"); //ask for student change
								studentAge[totalStudentsInArray] = input.nextInt(); // save student age into the array 
								input.nextLine();

								System.out.println("Introduce los estudios del alumno \n 1: CFGM \n 2: Bachillerato \n 3: Prueba de acceso"); //ask for student studies
								do { //ask studies while user input not equals 1 menu option
									userStudentSetStudies = input.nextByte(); // save user input into the variable
									input.nextLine();
									switch(userStudentSetStudies) {
									case 1:
										studentStudies[totalStudentsInArray] = "CFGM";
										break;
									case 2:
										studentStudies[totalStudentsInArray] = "Bachillerato";
										break;
									case 3:
										studentStudies[totalStudentsInArray] = "Prueba de acceso";
										break;
									default:
										System.out.println("Valor no valido \n Introduce los estudios del alumno \\n 1: CFGM \\n 2: Bachillerato \\n 3: Prueba de acceso");
										break;
									}
								} while((userStudentSetStudies >= 4));
								
								System.out.println("Introduce \n 'S' si es repetidor \n 'N' si no es repetidor"); // ask if student is a repeater
								userInputStudentRepeater = input.nextLine().charAt(0); // save user input into the variable at char 0
								
								studentRepeater[totalStudentsInArray] = (Character.toLowerCase(userInputStudentRepeater) == 's') ? true : false; //save user input into array if user input equals s then save true into the array otherwise save false
								
								listStudentRepeater = (studentRepeater[totalStudentsInArray] == true) ? "Repetidor" : "No repetidor"; // if student is a repeater save "Repetidor" to the variable to print de value otherwise save "No repetidor"
								
								System.out.println(studentName[totalStudentsInArray] + " " + studentAge[totalStudentsInArray] + " " + studentStudies[totalStudentsInArray] + " " + listStudentRepeater + " : Alumno registrado"); // print the data entered to save a new student
			
								totalStudentsInArray++; // plus 1 to total students
								System.out.println("\n Actualmente tienes " + totalStudentsInArray + " alumnos guardados."); //print the total students saved we have
							}
						} while(!menuNewStudent.toLowerCase().equals("salir") && totalStudentsInArray < TOTAL_STUDENTS);
						System.out.println("\n Pulse enter para salir al menu. ");
					}
					break;
				case "2": // main menu case to change any value of 1 student
					System.out.println("Introduce el nombre del alumno a modificar"); // aks for the student name we whant to change
					userInputStudentName = input.nextLine(); //save the name into the variable
					
					int i = 0;
					while(!userInputStudentName.toLowerCase().equals(studentName[i].toLowerCase()) && i < totalStudentsInArray) { //search into the names array for the name entered before			
						i++; // while name entered not equals 1 value of the array continue searching
					}
					if(userInputStudentName.toLowerCase().equals(studentName[i].toLowerCase())) { //if name entered equals 1 name in the array do:
						
						System.out.println("Que valor quieres modificar? \n 1: Edad \n 2: Estudios \n 3: Repetidor"); //ask what value we whant to change
						
						userChangeOption = input.nextLine().charAt(0); //save what we want to change into de variable
						
						switch(userChangeOption) { //switch between optiones we whant to change
							case '1': //case we want to change student age
								System.out.println("Introduce la nueva edad para " + studentName[i] + " actualmente tiene: " + studentAge[i]);
								studentAge[i] = input.nextInt(); 
								input.nextLine();
								
								break;
							case '2': //case we want to change student studies
								System.out.println("Introduce los nuevos estudios para " + studentName[i] + " actualmente tiene: " + studentStudies[i]);
								System.out.println("Introduce los estudios del alumno \n 1: CFGM \n 2: Bachillerato \n 3: Prueba de acceso"); 
								do { //ask the new value while user input not equals a case value
									userStudentSetStudies = input.nextByte();
									input.nextLine();
									switch(userStudentSetStudies) {
									case 1:
										studentStudies[i] = "CFGM";
										break;
									case 2:
										studentStudies[i] = "Bachillerato";
										break;
									case 3:
										studentStudies[i] = "Prueba de acceso";
										break;
									default:
										System.out.println("Valor no valido \n Introduce los estudios del alumno \\n 1: CFGM \\n 2: Bachillerato \\n 3: Prueba de acceso");
										break;
									}
								} while((userStudentSetStudies >= 4));
								
								break;
							case '3': //case we whant to change if student is a repeater
								System.out.println("Introduce si es repetidor para " + studentName[i] + "\n 'S' si es repetidor \n 'N' si no lo es"); 
								userInputStudentRepeater = input.nextLine().charAt(0);
								
								studentRepeater[i] = (Character.toLowerCase(userInputStudentRepeater) == 's') ? true : false; //if user input equals 's' save to array ture else false
								
								break;
						}
						
						listStudentRepeater = (studentRepeater[i] == true) ? "Repetidor" : "No repetidor"; // if student is a repeater save "Repetidor" to the variable to print de value otherwise save "No repetidor"
						
						System.out.println(studentName[i] + " " + studentAge[i] + " " + studentStudies[i] + " " + listStudentRepeater + " : Alumno actualizado \n Pulse enter para salir la menu");	
					} else {
						System.out.println("El alumno " + userInputStudentName + " no existe \n Pulse enter para salir al menu.");
					}
					
					break;
				case "3":
					System.out.println("Actualmente tienes " + totalStudentsInArray + " alumnos registrados \n "); //print total students we have registered
					for(int k = 0; k < studiesType.length; k++) { // for loop between studies types
						System.out.println("\n" + studiesType[k]); //print the studies type name
						for (int j = 0; j < totalStudentsInArray; j++) { //for loop between all students in the array
							if(studentStudies[j].equals(studiesType[k])) {	//if student in the array have the same study type						
								listStudentRepeater = (studentRepeater[j] == true) ? "Repetidor" : "No repetidor";
								System.out.println(studentName[j] + " / " + studentAge[j] + " / " + listStudentRepeater); //print all students that have the same studies
							}
						}
					}
					System.out.println("\n Pulse enter para salir al menu.");
					break;
					
				case "4":
					if(totalStudentsInArray > 1) { //don't enter this menu if we don't have any student registered in the array
						System.out.println("Que alumno desea borrar? Introduce su nombre"); //ask for student name we want to delete
						
						userInputStudentName = input.nextLine(); //save student name we want to delete into variable
						
						while(!userInputStudentName.toLowerCase().equals(studentName[studentIndexToDelete].toLowerCase()) && studentIndexToDelete < totalStudentsInArray) { //search into the names array for the name entered before	
							studentIndexToDelete++; // while name entered not equals 1 value of the array continue searching
						}
						
						if(userInputStudentName.toLowerCase().equals(studentName[studentIndexToDelete].toLowerCase())) { //if user input equals 1 name into the array
							for(int j = studentIndexToDelete; j < totalStudentsInArray - 1; j++) { // for loop to delete the user we specified and reorder all arrays
								studentName[j] = studentName[j + 1]; //move positions to reorder the array
								studentAge[j] = studentAge[j + 1];
								studentStudies[j] = studentStudies[j + 1];
								studentRepeater[j] = studentRepeater[j + 1];
							}
							totalStudentsInArray--; //delete 1 to total students in the array
							System.out.println("Alumno eliminado \n Pulse enter para salir al menu.");
						} else {
							System.out.println("El alumno no existe \n Pulse enter para salir al menu.");
						}
					} else {
						System.out.println("Aun no se ha registrado ningún alumno");
					}
					break;
				default:
					if(!menuOption.toLowerCase().equals("salir")) {
						System.out.println("Introduce que desea hacer: \n 1 - Registrar alumno \n 2 - Modificar datos de 1 alumno \n 3 - Lista de todos los alumnos \n 4 - Borrar un alumno \n 'Salir' para salir del programa");
					}
			}

		} while (!menuOption.toLowerCase().equals("salir"));

		input.close();
		System.out.println("Has salido del programa");
	}

}
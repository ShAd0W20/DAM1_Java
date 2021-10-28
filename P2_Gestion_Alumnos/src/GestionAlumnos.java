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
		byte userStudentSetStudies = 0;
		int studentIndexToDelete = 0;

		System.out.println("Introduce que desea hacer: \n 1 - Registrar alumno \n 2 - Modificar datos de 1 alumno \n 3 - Lista de todos los alumnos \n 4 - Borrar un alumno \n 'Salir' para salir del programa");
		do {
			menuOption = input.nextLine(); // Assign user input to variable 'menuOption' in order to enter the different menu options

			switch (menuOption) { // switch main menu
				case "1": 
					if (totalStudentsInArray == TOTAL_STUDENTS) { 
						System.out.println("No puedes registrar mas alumnos");
					} else {						
						do {
							System.out.println("Introduce el nombre del alumno o 'Salir' para ir al menu principal");
							menuNewStudent = input.nextLine();
		
							if(!menuNewStudent.toLowerCase().equals("salir")) {
								studentName[totalStudentsInArray] = menuNewStudent;
								
								System.out.println("Introduce la edad del alumno"); 
								studentAge[totalStudentsInArray] = input.nextInt();
								input.nextLine();

								System.out.println("Introduce los estudios del alumno \n 1: CFGM \n 2: Bachillerato \n 3: Prueba de acceso"); 
								do {
									userStudentSetStudies = input.nextByte();
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
								
								System.out.println("Introduce \n 'S' si es repetidor \n 'N' si no es repetidor");
								userInputStudentRepeater = input.nextLine().charAt(0);
								
								studentRepeater[totalStudentsInArray] = (Character.toLowerCase(userInputStudentRepeater) == 's') ? true : false; 
								
								listStudentRepeater = (studentRepeater[totalStudentsInArray] == true) ? "Repetidor" : "No repetidor";
								
								System.out.println(studentName[totalStudentsInArray] + " " + studentAge[totalStudentsInArray] + " " + studentStudies[totalStudentsInArray] + " " + listStudentRepeater + " : Alumno registrado");
			
								totalStudentsInArray++;
								System.out.println("\n Actualmente tienes " + totalStudentsInArray + " alumnos guardados.");
							}
						} while(!menuNewStudent.toLowerCase().equals("salir") && totalStudentsInArray < TOTAL_STUDENTS);
						System.out.println("\n Pulse enter para salir al menu. ");
					}
					break;
				case "2":
					System.out.println("Introduce el nombre del alumno a modificar");
					userInputStudentName = input.nextLine();
					
					int i = 0;
					while(!userInputStudentName.toLowerCase().equals(studentName[i].toLowerCase()) && i < totalStudentsInArray) {					
						i++;
					}
					if(userInputStudentName.toLowerCase().equals(studentName[i].toLowerCase())) {
						
						System.out.println("Que valor quieres modificar? \n 1: Edad \n 2: Estudios \n 3: Repetidor"); 
						
						userChangeOption = input.nextLine().charAt(0); 
						
						switch(userChangeOption) { 
							case '1': 
								System.out.println("Introduce la nueva edad para " + studentName[i] + " actualmente tiene: " + studentAge[i]);
								studentAge[i] = input.nextInt(); 
								input.nextLine();
								
								break;
							case '2': 
								System.out.println("Introduce los nuevos estudios para " + studentName[i] + " actualmente tiene: " + studentStudies[i]);
								System.out.println("Introduce los estudios del alumno \n 1: CFGM \n 2: Bachillerato \n 3: Prueba de acceso"); 
								do {
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
							case '3':
								System.out.println("Introduce si es repetidor para " + studentName[i] + "\n 'S' si es repetidor \n 'N' si no lo es"); 
								userInputStudentRepeater = input.nextLine().charAt(0);
								
								studentRepeater[i] = (Character.toLowerCase(userInputStudentRepeater) == 's') ? true : false;
								
								break;
						}
						
						listStudentRepeater = (studentRepeater[i] == true) ? "Repetidor" : "No repetidor";
						
						System.out.println(studentName[i] + " " + studentAge[i] + " " + studentStudies[i] + " " + listStudentRepeater + " : Alumno actualizado \n Pulse enter para salir la menu");	
					} else {
						System.out.println("El alumno " + userInputStudentName + " no existe \n Pulse enter para salir al menu.");
					}
					
					break;
				case "3":
					System.out.println("Actualmente tienes " + totalStudentsInArray + " alumnos registrados \n ");
					for(int k = 0; k < studiesType.length; k++) {
						System.out.println("\n" + studiesType[k]);
						for (int j = 0; j < totalStudentsInArray; j++) {
							if(studentStudies[j].equals(studiesType[k])) {								
								listStudentRepeater = (studentRepeater[j] == true) ? "Repetidor" : "No repetidor";							
								System.out.println(studentName[j] + " / " + studentAge[j] + " / " + listStudentRepeater); 
							}
						}
					}
					System.out.println("\n Pulse enter para salir al menu.");
					break;
					
				case "4":
					if(totalStudentsInArray > 1) {
						System.out.println("Que alumno desea borrar? Introduce su nombre");
						
						userInputStudentName = input.nextLine();
						
						while(!userInputStudentName.toLowerCase().equals(studentName[studentIndexToDelete].toLowerCase()) && studentIndexToDelete < totalStudentsInArray) {
							studentIndexToDelete++;
						}
						
						if(userInputStudentName.toLowerCase().equals(studentName[studentIndexToDelete].toLowerCase())) {
							for(int j = studentIndexToDelete; j < totalStudentsInArray - 1; j++) {
								studentName[j] = studentName[j + 1];
								studentAge[j] = studentAge[j + 1];
								studentStudies[j] = studentStudies[j + 1];
								studentRepeater[j] = studentRepeater[j + 1];
							}			
							totalStudentsInArray--;
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
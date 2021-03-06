import java.util.Scanner;

public class GestionVideojuegos {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Scanner to use for user input from the console

		String[] gameName = new String[5]; // String array to store game names
		double[] gamePrice = new double[5]; // double array to store game prices
		boolean[] gameCategory = new boolean[5]; // boolean array to store if the games is +18 or not

		int totalGamesInArray = 0; // integer to know how many games have we stored in the arrays

		String menuOption = ""; // string to know what's the user option in the main menu
		String listStudentRepeater = "";  // String used to difference between gameCategory boolean
		String userInputStudentName = ""; // String variable to know what game user whant's to update
		char userChangeOption = '0'; //char variable to know what value to change
		char userInputStudentRepeater = '0'; //char variable to get user input new game category

		System.out.println("Introduce que desea hacer: \n 1 - Guardar un juego \n 2 - Modificar datos de un juego \n 3 - Lista de todos los juegos \n 'Salir' para salir del programa");
		do {
			menuOption = input.nextLine(); // Assign user input to variable 'menuOption' in order to enter the different menu options

			switch (menuOption) { // switch main menu
				case "1": // If user entered 1 in option menu enter this case and register a new game
					if (totalGamesInArray == 5) { // If array is full exit
						System.out.println("No puedes guardar mas juegos");
					} else {
						System.out.println("Introduce el nombre del juego a guardar"); // ask for game name
						gameName[totalGamesInArray] = input.nextLine(); // store user input game name to array index with value of totalGamesInArray (first input should be  totalGamesInArray = 0)
	
						System.out.println("Introduce el precio del juego a guardar"); // ask for game price
						gamePrice[totalGamesInArray] = input.nextDouble();// store user input game price to array index with value of totalGamesInArray
						input.nextLine();
	
						System.out.println("Introduce \n 'S' si es +18 \n 'N' si es -18"); // ask if game is +18 or not
						userInputStudentRepeater = input.nextLine().charAt(0); // store user input game category
						
						gameCategory[totalGamesInArray] = (Character.toLowerCase(userInputStudentRepeater) == 's') ? true : false; // if userInputStudentRepeater variable == s set boolean gameCategory with index of totalGamesInArray to TRUE else FALSE
						
						listStudentRepeater = (gameCategory[totalGamesInArray] == true) ? "+18" : "-18"; // if gameCategory index is true set listGameCateogry variable == +18 else set it to -18
						
						System.out.println(gameName[totalGamesInArray] + " " + gamePrice[totalGamesInArray] + " " + listStudentRepeater + " : Videojuego guardado"); // print game data stored into the arrays
	
						totalGamesInArray++; // plus 1 to totalGamesInArray
						System.out.println("\n Actualmente tienes " + totalGamesInArray + " juegos guardados \n\n Pulse enter para salir al menu."); // print the total games stored
					}
					break;
				case "2":
					System.out.println("Introduce el nombre del juego a modificar"); //ask user what game whant's to change
					userInputStudentName = input.nextLine(); //store user input into the variable
					
					int i = 0; // integer used to know array index equals to user input
					while(!userInputStudentName.toLowerCase().equals(gameName[i].toLowerCase()) && i < totalGamesInArray) {// loop throw total games in array while user input not equals game name					
						i++;
					}
					if(userInputStudentName.toLowerCase().equals(gameName[i].toLowerCase())) { // if finds game name equals to user input do:
						
						System.out.println("Que valor quieres modificar? \n 1: Precio \n 2: Categoria"); // ask what value to change
						
						userChangeOption = input.nextLine().charAt(0); // store user input into the variable
						
						switch(userChangeOption) { // switch between user input value
							case '1': // case user input == 1 change game price
								System.out.println("Introduce el nuevo precio para " + gameName[i] + " actualmente con precio: " + gamePrice[i]); // ask the new price for the game
								gamePrice[i] = input.nextDouble(); // store the new price into gamePrice array with index of the gameName
								input.nextLine();
								
								break;
							case '2': // case user input == 1 change game category
								System.out.println("Introduce la nueva categorya para " + gameName[i] + "\n 'S' si es +18 \n 'N' si es -18"); // ask the new category for the game
								userInputStudentRepeater = input.nextLine().charAt(0); // store user input game category to array index with value of totalGamesInArray
								
								gameCategory[i] = (Character.toLowerCase(userInputStudentRepeater) == 's') ? true : false; // if userInputStudentRepeater variable = s set boolean gameCategory to TRUE else FALSE
								
								break;
						}
						
						listStudentRepeater = (gameCategory[i] == true) ? "+18" : "-18"; // if gameCategory index is true set listGameCateogry variable = +18 else set it to -18
						
						System.out.println(gameName[i] + " " + gamePrice[i] + " " + listStudentRepeater + " : Videojuego actualizado \n Pulse enter para salir la menu"); // print the new values of the game	
					} else {
						System.out.println("El juego " + userInputStudentName + " no existe \n Pulse enter para salir al menu."); // if user input a non existing game print game does not exists
					}
					
					break;
				case "3":
					System.out.println("Actualmente tienes " + totalGamesInArray + " juegos registrados \n "); // print the total games stored in the array
	
					for (int j = 0; j < totalGamesInArray; j++) { // for loop throw totalGamesInArray
						
						listStudentRepeater = (gameCategory[j] == true) ? "+18" : "-18"; // if gameCategory index is true set listGameCateogry variable = +18 else set it to -18
						
						System.out.println(gameName[j] + " / " + gamePrice[j] + " / " + listStudentRepeater); // Print the list of games stored in the array
					}
					System.out.println("\n Pulse enter para salir al menu.");
					break;
				default:
					if(!menuOption.toLowerCase().equals("salir")) {
						System.out.println("Introduce que desea hacer: \n 1 - Guardar un juego \n 2 - Modificar datos de un juego \n 3 - Lista de todos los juegos \n 'Salir' para salir del programa");
					}
			}

		} while (!menuOption.toLowerCase().equals("salir"));

		input.close();
		System.out.println("Has salido del programa");
	}
}
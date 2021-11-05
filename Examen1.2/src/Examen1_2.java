import java.util.Scanner;

public class Examen1_2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		final int MAX_REGISTERED_GAMES = 15;
		
		String[] gameName = new String[MAX_REGISTERED_GAMES];
		int[] gameType = new int[MAX_REGISTERED_GAMES]; // 1 Esport, 2 Belic, 3 Plataforma, 4 Infantil
		char[] gameConsole = new char[MAX_REGISTERED_GAMES]; //P: Play, X: Xbox, W: WiiU
		double[] gamePrice = new double[MAX_REGISTERED_GAMES];
		boolean[] gameAge = new boolean[MAX_REGISTERED_GAMES]; // true +18 : -18
		
		int totalGamesRegistered = 12;
		
		int[] gameConsoleTypes = {1, 2, 3, 4};		
		char[] gameConsoleNames = {'P', 'X', 'W'};
		
		String menuOption = "";
		String subMenuOption = "";
		String subMenuOption2 = "";
		
		String consoleName = "";
		String gameTypeName = "";
		String gameCategoryName = "";
		
		String canvio = "";
		int canvio2 = 0;
		char canvio3 = '0';
		double canvio4 = 0;
		boolean canvio5 = false;
		
		int arrayIndexToDelete = 0;
		String gameToDelete = "";
		
		gameName[0] = "a"; gameType[0] = 2; gameConsole[0] = 'P'; gamePrice[0] = 59.99; gameAge[0] = true;
		gameName[1] = "c"; gameType[1] = 1; gameConsole[1] = 'X'; gamePrice[1] = 39.99; gameAge[1] = false;
		gameName[2] = "g"; gameType[2] = 3; gameConsole[2] = 'W'; gamePrice[2] = 49.99; gameAge[2] = true;
		gameName[3] = "f"; gameType[3] = 4; gameConsole[3] = 'X'; gamePrice[3] = 89.99; gameAge[3] = false;
		gameName[4] = "k"; gameType[4] = 4; gameConsole[4] = 'X'; gamePrice[4] = 99.99; gameAge[4] = false;
		gameName[5] = "b"; gameType[5] = 3; gameConsole[5] = 'X'; gamePrice[5] = 19.99; gameAge[5] = true;
		gameName[6] = "d"; gameType[6] = 3; gameConsole[6] = 'P'; gamePrice[6] = 29.99; gameAge[6] = false;
		gameName[7] = "h"; gameType[7] = 2; gameConsole[7] = 'P'; gamePrice[7] = 29.99; gameAge[7] = false;
		gameName[8] = "l"; gameType[8] = 1; gameConsole[8] = 'X'; gamePrice[8] = 9.99; gameAge[8] = true;
		gameName[9] = "j"; gameType[9] = 2; gameConsole[9] = 'W'; gamePrice[9] = 109.99; gameAge[9] = true;
		gameName[10] = "e"; gameType[10] = 1; gameConsole[10] = 'W'; gamePrice[10] = 79.99; gameAge[10] = false;
		gameName[11] = "i"; gameType[11] = 2; gameConsole[11] = 'P'; gamePrice[11] = 69.99; gameAge[11] = true;
		
		System.out.println("Que desea hacer? \n 1: Listar videojuegos \n 2: Agrupar videojuegos \n 3: Para eliminar un juego");
		
		do {
			menuOption = input.nextLine();
			
			switch(menuOption.toLowerCase()) {
				case "1":
					System.out.println("Que desea hacer? \n 1: Ordernar por nombre \n 2: Ordernar por precio \n 'Salir' para salir al menu principal");
					do {
						subMenuOption = input.nextLine();
						switch(subMenuOption) {
							case "1":
								for (int i = 0; i < totalGamesRegistered - 1; i++) { //Order by name
									
									for (int j = i + 1; j < totalGamesRegistered; j++) {
										
										int compare = gameName[i].compareTo(gameName[j]);
										if (compare > 0) {
											canvio = gameName[i];
											
											gameName[i] = gameName[j];
											
											gameName[j] = canvio;
											
											canvio2 = gameType[i];
											
											gameType[i] = gameType[j];
											
											gameType[j] = canvio2;
											
											canvio3 = gameConsole[i];
											
											gameConsole[i] =gameConsole[j];
											
											gameConsole[j] = canvio3;
											
											canvio4 = gamePrice[i];
											
											gamePrice[i] = gamePrice[j];
											
											gamePrice[j] = canvio4;
											
											canvio5 = gameAge[i];
											
											gameAge[i] = gameAge[j];
											
											gameAge[j] = canvio5;
											
										}
									}
								}
								
								for(int i = 0; i < totalGamesRegistered; i++) {
									if(gameConsole[i] == 'P') {
										consoleName = "PlayStation";
									} else if ( gameConsole[i] == 'X') {
										consoleName = "XBox";										
									} else {
										consoleName = "WiiU";										
									}
									if(gameType[i] == 1) {
										gameTypeName = "Deportes";
									} else if ( gameType[i] == 2) {
										gameTypeName = "Belico";										
									} else if ( gameType[i] == 3) {
										gameTypeName = "Plataformas";										
									} else {
										gameTypeName = "Infantil";										
									}

									gameCategoryName = (gameAge[i] == true) ? "+18" : "-18";
									System.out.println(gameName[i] + " " + gameTypeName + " " + consoleName + " " + gamePrice[i] + " " + gameCategoryName);
								}
								System.out.println("Pulsa enter para volver al menu de listado \n 'Salir' para ir al menu princial");
								break;
							case "2":
								for (int i = 0; i < totalGamesRegistered - 1; i++) {
									
									for (int j = i + 1; j < totalGamesRegistered; j++) {
										
										if (gamePrice[i] > gamePrice[j]) {
											
											canvio = gameName[i];
											
											gameName[i] = gameName[j];
											
											gameName[j] = canvio;
											
											canvio2 = gameType[i];
											
											gameType[i] = gameType[j];
											
											gameType[j] = canvio2;
											
											canvio3 = gameConsole[i];
											
											gameConsole[i] =gameConsole[j];
											
											gameConsole[j] = canvio3;
											
											canvio4 = gamePrice[i];
											
											gamePrice[i] = gamePrice[j];
											
											gamePrice[j] = canvio4;
											
											canvio5 = gameAge[i];
											
											gameAge[i] = gameAge[j];
											
											gameAge[j] = canvio5;
											
										}	
									}
								}
								for(int j = 0; j < totalGamesRegistered; j++) {
									if(gameConsole[j] == 'P') {
										consoleName = "PlayStation";
									} else if ( gameConsole[j] == 'X') {
										consoleName = "XBox";										
									} else {
										consoleName = "WiiU";										
									}
									if(gameType[j] == 1) {
										gameTypeName = "Deportes";
									} else if ( gameType[j] == 2) {
										gameTypeName = "Belico";										
									} else if ( gameType[j] == 3) {
										gameTypeName = "Plataformas";										
									} else {
										gameTypeName = "Infantil";										
									}

									gameCategoryName = (gameAge[j] == true) ? "+18" : "-18";
									System.out.println(gameName[j] + " " + gameTypeName + " " + consoleName + " " + gamePrice[j] + " " + gameCategoryName);
								}
								System.out.println("Pulsa enter para volver al menu de listado \n 'Salir' para ir al menu princial");
								break;
							default:
								if(!subMenuOption.toLowerCase().equals("salir")) {
									System.out.println("Que desea hacer? \n 1: Ordernar por nombre \n 2: Ordernar por precio \n 'Salir' para ir al menu princial");									
								}
						}
					} while(!subMenuOption.toLowerCase().equals("salir"));
					break;
				case "2":
					System.out.println("Que desea hacer? \n 1: Agrupar por consola \n 2: Ordernar por tipo \n 'Salir' para salir al menu principal");
					do {
						subMenuOption2 = input.nextLine();
						switch(subMenuOption2) {
							case "1":
								for(int i = 0; i < gameConsoleNames.length; i++) {
									if(gameConsoleNames[i] == 'P') {
										consoleName = "PlayStation";
									} else if ( gameConsoleNames[i] == 'X') {
										consoleName = "XBox";										
									} else {
										consoleName = "WiiU";										
									}
									System.out.println("\n" + consoleName);
									for(int j = 0; j < totalGamesRegistered; j++) {
										if(gameConsole[j] == gameConsoleNames[i]) {
											if(gameConsole[j] == 'P') {
												consoleName = "PlayStation";
											} else if ( gameConsole[i] == 'X') {
												consoleName = "XBox";										
											} else {
												consoleName = "WiiU";										
											}
											if(gameType[j] == 1) {
												gameTypeName = "Deportes";
											} else if ( gameType[j] == 2) {
												gameTypeName = "Belico";										
											} else if ( gameType[j] == 3) {
												gameTypeName = "Plataformas";										
											} else {
												gameTypeName = "Infantil";										
											}

											gameCategoryName = (gameAge[j] == true) ? "+18" : "-18";
											System.out.println(gameName[j] + " " + gameTypeName + " " + consoleName + " " + gamePrice[j] + " " + gameCategoryName);
										}
									}
								}
								System.out.println("Pulsa enter para volver al menu de agrupar \n 'Salir' para ir al menu princial");
								break;
							case "2":
								for(int i = 0; i < gameConsoleTypes.length; i++) {
									if(gameConsoleTypes[i] == 1) {
										gameTypeName = "Deportes";
									} else if ( gameConsoleTypes[i] == 2) {
										gameTypeName = "Belico";										
									} else if ( gameConsoleTypes[i] == 3) {
										gameTypeName = "Plataformas";										
									} else {
										gameTypeName = "Infantil";										
									}
									System.out.println("\n" + gameTypeName);
									for(int j = 0; j < totalGamesRegistered; j++) {
										if(gameType[j] == gameConsoleTypes[i]) {
											if(gameConsole[j] == 'P') {
												consoleName = "PlayStation";
											} else if ( gameConsole[j] == 'X') {
												consoleName = "XBox";										
											} else {
												consoleName = "WiiU";										
											}
											if(gameType[j] == 1) {
												gameTypeName = "Deportes";
											} else if ( gameType[j] == 2) {
												gameTypeName = "Belico";										
											} else if ( gameType[j] == 3) {
												gameTypeName = "Plataformas";										
											} else {
												gameTypeName = "Infantil";										
											}

											gameCategoryName = (gameAge[j] == true) ? "+18" : "-18";
											System.out.println(gameName[j] + " " + gameTypeName + " " + consoleName + " " + gamePrice[j] + " " + gameCategoryName);
										}
									}
								}
								System.out.println("Pulsa enter para volver al menu de listado \n 'Salir' para ir al menu princial");
								break;
							default:
								if(!subMenuOption2.toLowerCase().equals("salir")) {
									System.out.println("Que desea hacer? \n 1: Agrupar por consola \n 2: Ordernar por tipo \n 'Salir' para ir al menu princial");									
								}
						}
					} while(!subMenuOption2.toLowerCase().equals("salir"));
					break;
				case "3":
					
					System.out.println("Introduce el nombre del juego a eliminar");
					
					gameToDelete = input.nextLine();
					
					while(!gameToDelete.toLowerCase().equals(gameName[arrayIndexToDelete].toLowerCase()) && arrayIndexToDelete < totalGamesRegistered) {
						arrayIndexToDelete++;
					}
					
					if(gameToDelete.toLowerCase().equals(gameName[arrayIndexToDelete].toLowerCase())) {
						for(int i = arrayIndexToDelete; i < totalGamesRegistered - 1; i++) {
							gameName[i] = gameName[i + 1];
							gameType[i] = gameType[i + 1];
							gameConsole[i] = gameConsole[i + 1];
							gamePrice[i] = gamePrice[i + 1];
							gameAge[i] = gameAge[i + 1];
						}
						
						totalGamesRegistered--;
						
						System.out.println("Videojuego " + gameToDelete + " eliminado");
						System.out.println("Pulse enter para listar los juegos restantes");
						input.nextLine();
						for(int i = 0; i < totalGamesRegistered; i++) {
							if(gameConsole[i] == 'P') {
								consoleName = "PlayStation";
							} else if ( gameConsole[i] == 'X') {
								consoleName = "XBox";										
							} else {
								consoleName = "WiiU";										
							}
							if(gameType[i] == 1) {
								gameTypeName = "Deportes";
							} else if ( gameType[i] == 2) {
								gameTypeName = "Belico";										
							} else if ( gameType[i] == 3) {
								gameTypeName = "Plataformas";										
							} else {
								gameTypeName = "Infantil";										
							}

							gameCategoryName = (gameAge[i] == true) ? "+18" : "-18";
							System.out.println(gameName[i] + " " + gameTypeName + " " + consoleName + " " + gamePrice[i] + " " + gameCategoryName);
						}
					}
					break;
				default:
					if(!menuOption.toLowerCase().equals("salir")) {
						System.out.println("Que desea hacer? \n 1: Listar videojuegos \n 2: Agrupar videojuegos \n 3: Para eliminar un juego \n 'Salir' para salir del programa");
					}
				}
			
		} while(!menuOption.toLowerCase().equals("salir"));

		input.close();
		System.out.println("Has salido");
	}

}

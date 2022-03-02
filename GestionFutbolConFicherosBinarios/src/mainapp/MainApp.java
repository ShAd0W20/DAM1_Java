package mainapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import views.AddPlayer;
import views.EditPlayerScores;
import views.ListPlayers;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		String mainMenuOption = "";
		
		
		System.out.format("%s %n %s %n %s %n %s %n %s %n %s %n %s %n %s %n %s %n", "Que desea hacer?", "[1] Registrar jugador", "[2] Listar jugadores", "[3] Fichar jugador", "[4] Borrar jugador", "[5] Registrar goles", "[6] Clasificacion goleadores", "[7] Clasificacion porteros", "[Salir] para salir del programa");
		
		do {
			mainMenuOption = input.nextLine();
			
			switch(mainMenuOption) {
			case "1":
				AddPlayer.registerPlayer();
				break;
			case "2":
				ListPlayers.listPlayers();
				break;
			case "3":
				EditPlayerScores.editPlayerScores();
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			default:
				if(!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.format("%s %n %s %n %s %n %s %n %s %n %s %n %s %n %s %n %s %n", "Que desea hacer?", "[1] Registrar jugador", "[2] Listar jugadores", "[3] Fichar jugador", "[4] Borrar jugador", "[5] Registrar goles", "[6] Clasificacion goleadores", "[7] Clasificacion porteros", "[Salir] para salir del programa");
				}
			}
		} while(!mainMenuOption.equalsIgnoreCase("salir"));
		
		input.close();
	}

}

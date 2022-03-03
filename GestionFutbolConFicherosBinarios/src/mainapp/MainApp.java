package mainapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import views.AddPlayer;
import views.EditPlayer;
import views.PurgeFile;
import views.lists.ListPlayers;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		String mainMenuOption = "";
		
		
		System.out.format("%s %n %s %n %s %n %s %n %s %n %s %n %s %n %s %n %s %n %s %n", "Que desea hacer?", "[1] Registrar jugador", "[2] Listar jugadores", "[3] Fichar jugador", "[4] Borrar jugador", "[5] Registrar goles", "[6] Clasificacion goleadores", "[7] Clasificacion porteros", "[8] Purgar archivo" ,"[Salir] para salir del programa");
		
		do {
			mainMenuOption = input.nextLine();
			
			switch(mainMenuOption) {
			case "1":
				AddPlayer.registerPlayer();
				break;
			case "2":
				ListPlayers.listAllPlayersByTeam();
				break;
			case "3":
				EditPlayer.editPlayerTeam();
				break;
			case "4":
				EditPlayer.updateDeleted();
				break;
			case "5":
				EditPlayer.editPlayerScores();
				break;
			case "6":
				ListPlayers.listBestScorePlayers();
				break;
			case "7":
				ListPlayers.listBestGoalKeeper();
				break;
			case "8":
				PurgeFile.purge();
				break;
			default:
				if(!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.format("%s %n %s %n %s %n %s %n %s %n %s %n %s %n %s %n %s %n %s %n", "Que desea hacer?", "[1] Registrar jugador", "[2] Listar jugadores", "[3] Fichar jugador", "[4] Borrar jugador", "[5] Registrar goles", "[6] Clasificacion goleadores", "[7] Clasificacion porteros", "[8] Purgar archivo" ,"[Salir] para salir del programa");
				}
			}
		} while(!mainMenuOption.equalsIgnoreCase("salir"));
		
		input.close();
		System.out.printf("%n%n[!] Saliendo... %n");
	}

}

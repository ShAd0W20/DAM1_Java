package mainapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import models.*;

public class MainApp {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<RegisterPlayer> players = new ArrayList<RegisterPlayer>();
		addPlayerToArray("Pepe", LocalDate.now(), "Lateral", "My team", "Futbol", 5, players);
		addPlayerToArray("Guille", LocalDate.now(), "Base", "Your team", "Baloncesto", 10, players);
		addPlayerToArray("Irene", LocalDate.now(), "Pivot", "Your team", "Baloncesto", 1, players);
		addPlayerToArray("Marta", LocalDate.now(), "Central", "My team", "Futbol", 0, players);
		addPlayerToArray("Pol", LocalDate.now(), "Central", "Our team", "Balonmano", 2, players);
		addPlayerToArray("Pablo", LocalDate.now(), "Lateral", "Our team", "Balonmano", 13, players);
		addPlayerToArray("Sara", LocalDate.now(), "Lateral", "My team", "Futbol", 8, players);
		addPlayerToArray("Sandra", LocalDate.now(), "Lateral", "My team", "Futbol", 7, players);
		addPlayerToArray("Laura", LocalDate.now(), "Lateral", "Our team", "Balonmano", 6, players);
		addPlayerToArray("Pepa", LocalDate.now(), "Lateral", "Our team", "Balonmano", 25, players);
		addPlayerToArray("Jordi", LocalDate.now(), "Lateral", "Your team", "Baloncesto", 30, players);
		addPlayerToArray("Arnau", LocalDate.now(), "Lateral", "Your team", "Baloncesto", 5, players);
		addPlayerToArray("Richard", LocalDate.now(), "Lateral", "Wee team", "Hockey", 4, players);
		addPlayerToArray("Mireia", LocalDate.now(), "Lateral", "Wea team", "Hockey", 1, players);
		addPlayerToArray("Gabi", LocalDate.now(), "Lateral", "Wee team", "Hockey", 2, players);

		// mainMenu(players);
		printPlayersInSameSportOrderByTeam("Hockey", players);
	}

	static void mainMenu(ArrayList<RegisterPlayer> players) {
		String mainMenuOption = "";
		System.out.println(
				"Que desea hacer? \n[1] Registrar jugador. \n[2] Actualizar jugador. \n[3] Borrar jugador. \n[4] Listar jugadores de un equipo. \n[5] Listar jugadores de un deporte ordenados por equipo \n[6] Listar jugadores de un deporte ordenador por puntos. \n[7] Listar jugador con mas puntos de un deporte. \n[Salir] para salir del programa");
		do {
			mainMenuOption = input.nextLine();
			switch (mainMenuOption) {
			case "1":
				addPlayerMenu(players);
				break;
			case "2":
				updatePlayerInfoMenu(players);
				break;
			case "3":
				String playerNameToDelete = "";
				print("Introduce el nombre del jugador a eliminar");
				playerNameToDelete = input.nextLine();
				deletePlayerFromArray(playerNameToDelete, players);
				print("Jugador eliminado con exito. Pulse enter para volver al menu");
				break;
			case "4":
				String teamToDisplay = "";
				print("Que equipo desea listar? Introduce el nombre del equipo.");
				printAvailableTeams(players);
				teamToDisplay = input.nextLine();
				printPlayersInTeam(teamToDisplay, players);
				break;
			case "5":
				String sportToDisplay = "";
				print("Que deporte desea listar? Introduce el nombre del deporte.");
				printAvailableSports(players);
				sportToDisplay = input.nextLine();
				printPlayersInSameSportOrderByTeam(sportToDisplay, players);
				break;
			default:
				if (!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.println(
							"Que desea hacer? \n[1] Registrar jugador. \n[2] Actualizar jugador. \n[3] Borrar jugador. \n[4] Listar jugadores de un equipo. \n[5] Listar jugadores de un deporte ordenados por equipo \n[6] Listar jugadores de un deporte ordenador por puntos. \n[7] Listar jugador con mas puntos de un deporte. \n[Salir] para salir del programa");
				}
			}

		} while (!mainMenuOption.equalsIgnoreCase("salir"));
	}

	static void addPlayerMenu(ArrayList<RegisterPlayer> players) {
		String playerName = "";
		LocalDate playerBirthDay = LocalDate.of(0, 0, 0);
		String playerPosition = "";
		String playerTeam = "";
		String playerSport = "";
		int playerPoints = 0;

		print("Introduce el nombre del jugador");
		playerName = input.nextLine();

		print("Introduce la fecha de nacimiento con el formato 'dd/mm/yyyy'");
		playerBirthDay = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));

		print("Introduce la posicion del jugador");
		playerPosition = input.nextLine();

		print("Introduce el equipo del jugador");
		playerTeam = input.nextLine();

		print("Introduce el deporte al que juega");
		playerSport = input.nextLine();

		print("Introduce la cantidad de puntos que tiene");
		playerPoints = Integer.parseInt(input.nextLine());

		addPlayerToArray(playerName, playerBirthDay, playerPosition, playerTeam, playerSport, playerPoints, players);

		print("Jugador añadido correctamente");

	}

	static void addPlayerToArray(String playerName, LocalDate playerBirthDay, String playerPosition, String playerTeam,
			String playerSport, int playerPoints, ArrayList<RegisterPlayer> players) {
		RegisterPlayer player = new RegisterPlayer();
		player.playerName = playerName;
		player.playerBirthDay = playerBirthDay;
		player.playerPosition = playerPosition;
		player.playerTeam = playerTeam;
		player.playerSport = playerSport;
		player.playerPoints = playerPoints;
		players.add(player);
	}

	static void updatePlayerInfoMenu(ArrayList<RegisterPlayer> players) {
		String playerName = "";
		String dataToUpdate = "";
		String dataValueToUpdate = "";

		System.out.println("Introduce el nombre del jugador a modificar");
		playerName = input.nextLine();

		System.out.println(
				"Que campo desea modificar? \n[1] Nombre. \n[2] Fecha de nacimiento. \n[3] Posicion. \n[4] Equipo. \n[5] Deporte. \n[6] Puntos");
		dataToUpdate = input.nextLine();

		System.out.println(
				"Introduce el valor del campo a modificar. \nEn el caso modificar la fecha de nacimiento siga el formato (dd/mm/yyyy)");
		dataValueToUpdate = input.nextLine();

		updatePlayerInfo(playerName, dataToUpdate, dataValueToUpdate, players);
	}

	static void updatePlayerInfo(String playerNameToSearch, String dataToUpdate, String dataValueToUpdate,
			ArrayList<RegisterPlayer> players) {
		int arrayPost = searchPlayerByName(playerNameToSearch, players);

		switch (dataToUpdate) {
		case "1":
			players.get(arrayPost).playerName = dataValueToUpdate;
			break;
		case "2":
			players.get(arrayPost).playerBirthDay = LocalDate.parse(dataValueToUpdate,
					DateTimeFormatter.ofPattern("d/M/y"));
			break;
		case "3":
			players.get(arrayPost).playerPosition = dataValueToUpdate;
			break;
		case "4":
			players.get(arrayPost).playerTeam = dataValueToUpdate;
			break;
		case "5":
			players.get(arrayPost).playerSport = dataValueToUpdate;
			break;
		case "6":
			players.get(arrayPost).playerPoints = Integer.parseInt(dataValueToUpdate);
			break;
		}

		System.out.println("Jugador actualizado. Pulsa enter para volver al menu");
	}

	static void deletePlayerFromArray(String playerNameToDelete, ArrayList<RegisterPlayer> players) {
		players.remove(searchPlayerByName(playerNameToDelete, players));
	}

	static int searchPlayerByName(String playerNameToSearch, ArrayList<RegisterPlayer> players) {
		int arrayPos = 0;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).playerName == playerNameToSearch) {
				arrayPos = i;
			}
		}
		return arrayPos;
	}

	static void printAvailableTeams(ArrayList<RegisterPlayer> players) {
		ArrayList<String> teams = new ArrayList<String>();

		for (int i = 0; i < players.size(); i++) {
			if (!teams.contains(players.get(i).playerTeam)) {
				teams.add(players.get(i).playerTeam);
			}
		}

		for (int i = 0; i < teams.size(); i++) {
			print("[" + (i + 1) + "] " + teams.get(i));
		}
	}

	static void printAvailableSports(ArrayList<RegisterPlayer> players) {
		ArrayList<String> sports = new ArrayList<String>();

		for (int i = 0; i < players.size(); i++) {
			if (!sports.contains(players.get(i).playerSport)) {
				sports.add(players.get(i).playerSport);
			}
		}

		for (int i = 0; i < sports.size(); i++) {
			print("[" + (i + 1) + "] " + sports.get(i));
		}
	}

	static void printPlayersInTeam(String team, ArrayList<RegisterPlayer> players) {
		print(team + "\n");
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).playerTeam.equals(team)) {
				print(players.get(i).playerName);
			}
		}
	}

	static void printPlayersInSameSportOrderByTeam(String sport, ArrayList<RegisterPlayer> players) {
		ArrayList<String> teams = new ArrayList<String>();

		for (int i = 0; i < players.size(); i++) {
			if (!teams.contains(players.get(i).playerTeam)) {
				teams.add(players.get(i).playerTeam);
			}
		}
		print(sport);

		for (int j = 0; j < teams.size(); j++) {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).playerSport.equals(sport)) {
					if (players.get(i).playerTeam.equals(teams.get(j))) {
						print(players.get(i).playerName);
					}
				}
			}
			print("");
		}

	}

	static void print(String data) {
		System.out.println(data);
	}
}

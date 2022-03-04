import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class JugadoresFutbol {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Players.txt");
		Scanner input = new Scanner(System.in);

		String mainMenuOption = "";

		String[][] players = getDataFromFile(file);

		System.out.printf("Que desea hacer? %n[1] Registrar jugador %n[2] Exportar a CSV %n[3] Listar por posicion %n[Salir] para salir%n");

		do {
			mainMenuOption = input.nextLine();
			switch (mainMenuOption) {
			case "1":
				registerPlayers(players);
				saveDataToFile(file, players);
				break;
			case "2":
				exportToCSV(players);
				break;
			case "3":
				showPlayersByPos(players);
				break;
			default:
				if(!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.printf("Que desea hacer? %n[1] Registrar jugador %n[2] Exportar a CSV %n[3] Listar por posicion %n[Salir] para salir%n");
				}
			}
		} while(!mainMenuOption.equalsIgnoreCase("salir"));

		saveDataToFile(file, players);
		
		System.out.printf("%n%n[!] Saliendo... %n");

	}

	static String[][] getDataFromFile(File file) throws FileNotFoundException {
		String[][] players = new String[10][3];
		try (Scanner fileData = new Scanner(file)) {
			int i = 0;
			while (fileData.hasNextLine()) {
				players[i] = fileData.nextLine().split(",");
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

		return players;
	}

	static void saveDataToFile(File file, String[][] users) throws FileNotFoundException {
		PrintStream output = new PrintStream(file);
		for (int i = 0; i < users.length; i++) {
			if (users[i][0] != null) {
				output.printf("%s,%s,%s%n", users[i][0], users[i][1], users[i][2]);
			}
		}
		output.close();
	}
	
	static void exportToCSV(String[][] players) throws FileNotFoundException {
		File exportToCSV = new File("players.csv");
		PrintStream output = new PrintStream(exportToCSV);
		output.printf("%s;%s;%s%n", "Nombre", "Posicion", "Equipo");
		for (int i = 0; i < players.length; i++) {
			if (players[i][0] != null) {
				output.printf("%s;%s;%s%n", players[i][0], players[i][1], players[i][2]);
			}
		}
		output.close();
		
	}

	static void registerPlayers(String[][] players) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		String playerName = "";
		String playerPos = "";
		String playerTeam = "";

		System.out.println("Introduce el nombre del jugador");
		playerName = input.nextLine();

		do {
			System.out.println("Introduce la posicion");
			playerPos = input.nextLine();
		} while(!checkForPlayerPos(playerPos));

		do {
			System.out.println("Introduce el equipo");
			playerTeam = input.nextLine();
		} while(!checkForPlayerTeam(playerTeam));
		

		input.close();

		int i = 0;
		while (players[i][0] != null && i < players.length) {
			i++;
		}

		players[i][0] = playerName;
		players[i][1] = playerPos;
		players[i][2] = playerTeam;
	}

	static void showPlayersByPos(String[][] players) {
		ArrayList<String> position = new ArrayList<String>();
		ArrayList<String> teams = new ArrayList<String>();
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < players.length; i++) {
			if (players[i][0] != null) {
				if (!position.contains(players[i][1])) {
					position.add(players[i][1]);
				}
			}
		}
		
		for (int i = 0; i < players.length; i++) {
			if (players[i][0] != null) {
				if (!teams.contains(players[i][2])) {
					teams.add(players[i][2]);
				}
			}
		}

		System.out.println("Introduce nombre equipo");
		String teamName = input.nextLine();
		input.close();
		
		if(teams.contains(teamName)) {
			System.out.printf("%-20s %-10s %10s%n", "Nombre", "Posicion", "Equipo");
			for (String s : position) {
				System.out.printf("%n%s%n", s);
				for (int i = 0; i < players.length; i++) {
					if (players[i][0] != null) {
						if (players[i][1].equals(s) && players[i][2].equals(teamName)) {
							System.out.printf("%-20s %-10s %10s%n", "[+] " + players[i][0], players[i][1], players[i][2]);
						}
					}
				}
			}
		}
	}

	static boolean checkForPlayerTeam(String team) {
		if(!team.equals("Barcelona") && !team.equals("Madrid") && !team.equals("Palamos")) {
			return false;
		}
		return true;
	}
	
	static boolean checkForPlayerPos(String pos) {
		if(!pos.equals("Portero") && !pos.equals("Defensa") && !pos.equals("Medio") && !pos.equals("Delantero")) {
			return false;
		}
		return true;
	}
}

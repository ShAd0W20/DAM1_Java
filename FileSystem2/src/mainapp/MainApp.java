package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import modules.Player;
import modules.Team;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("data.txt");
		Scanner fileData = new Scanner(data);
		ArrayList<Player> playersInFile = new ArrayList<Player>();

		while (fileData.hasNextLine()) {
			String[] mainPlayerData = fileData.nextLine().split("-");
			String[] playerTeamsHistory = new String[0];
			String[][] playerTeamsHistoryData = new String[0][0];
			int lineLength = mainPlayerData.length;
			Player player = new Player();

			player.playerID = mainPlayerData[0];
			player.playerName = mainPlayerData[1];
			player.playerTeam = mainPlayerData[2];

			if (lineLength > 3) {
				playerTeamsHistory = mainPlayerData[3].split("#");
				playerTeamsHistoryData = new String[playerTeamsHistory.length][2];
				for (int i = 0; i < playerTeamsHistory.length; i++) {
					playerTeamsHistoryData[i] = playerTeamsHistory[i].split(",");
				}
				for (int i = 3; i < lineLength; i++) {
					for (int k = 0; k < playerTeamsHistoryData.length; k++) {
						Team team = new Team();
						team.teamID = Integer.parseInt(playerTeamsHistoryData[k][0]);
						team.teamName = playerTeamsHistoryData[k][1];
						player.playerTeams.add(team);
					}
				}
			}

			playersInFile.add(player);

		}

		for (Player p : playersInFile) {
			System.out.printf("%s %s %s || ", p.playerID, p.playerName, p.playerTeam);
			for (Team j : p.playerTeams) {
				System.out.printf(" %s %s ", j.teamID, j.teamName);
			}
			System.out.println();
		}

		fileData.close();
	}

}

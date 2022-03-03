package views.lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import models.Player;

public class ListPlayers {
	public static void listAllPlayersByTeam() throws FileNotFoundException, IOException {
		ArrayList<Player> players = getPlayersFromFile();
		ArrayList<String> teams = new ArrayList<String>();
		
		for(Player p: players) {
			if(!teams.contains(p.getPlayerTeam())) {
				teams.add(p.getPlayerTeam());
			}
		}
		
		for(String s : teams) {
			System.out.printf("%n%s%n", s);
			System.out.printf("%-20s %-10s %-10s %10s%n", "Nombre", "Dorsal", "Posicion", "Goles");
			for(Player p : players) {
				if(!p.isDeleted() && s.equals(p.getPlayerTeam())) {
					System.out.printf("%-20s %-10d %-10s %10d%n", "[+] " + p.getPlayerName(), p.getPlayerNum(), p.getPlayerPosition(), p.getPlayerScores());
				}
			}
		}
		System.out.printf("%nPulse enter para volver al menu%n");		
	}
	
	public static void listBestScorePlayers() throws FileNotFoundException, IOException {
		ArrayList<Player> players = getPlayersFromFile();
		
		players.sort((o1, o2) -> (o2.getPlayerScores() - o1.getPlayerScores()));
		
		System.out.printf("%-20s %-10s %-10s %10s%n", "Nombre", "Dorsal", "Posicion", "Goles");
		for(Player p : players) {
			if(!p.isDeleted() && !p.getPlayerPosition().equals("Portero")) {
				System.out.printf("%-20s %-10d %-10s %10d%n", "[+] " + p.getPlayerName(), p.getPlayerNum(), p.getPlayerPosition(), p.getPlayerScores());
			}
		}
		System.out.printf("%nPulse enter para volver al menu%n");		
	}
	
	public static void listBestGoalKeeper() throws FileNotFoundException, IOException {
		ArrayList<Player> players = getPlayersFromFile();
		
		players.sort((o1, o2) -> (o1.getPlayerScores() - o2.getPlayerScores()));
		
		System.out.printf("%-20s %-10s %-10s %10s%n", "Nombre", "Dorsal", "Posicion", "Goles");
		for(Player p : players) {
			if(p.getPlayerPosition().equals("Portero")) {
				System.out.printf("%-20s %-10d %-10s %10d%n", "[+] " + p.getPlayerName(), p.getPlayerNum(), p.getPlayerPosition(), p.getPlayerScores());
			}
		}
		System.out.printf("%nPulse enter para volver al menu%n");		
	}
	
	private static ArrayList<Player> getPlayersFromFile() throws FileNotFoundException, IOException {
		File file = new File("Players.bin");
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		long fileLength = file.length();
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		while (raf.getFilePointer() < fileLength) {
			Player player = new Player();
			player.setDeleted(raf.readBoolean());
			player.setPlayerName(raf.readUTF().trim());
			player.setPlayerPosition(raf.readUTF().trim());
			player.setPlayerNum(raf.readInt());
			player.setPlayerTeam(raf.readUTF().trim());
			player.setPlayerScores(raf.readInt());
			players.add(player);
		}
		
		raf.close();
		
		return players;
	}
}

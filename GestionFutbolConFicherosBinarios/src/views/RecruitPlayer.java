package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import models.Player;

public class RecruitPlayer {
	public static void editPlayerTeam() throws FileNotFoundException, IOException {
		File file = new File("Players.bin");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		Scanner input = new Scanner(System.in);
		String playerNameToSearch = "";
		String playerNewTeam = "";		

		ArrayList<Player> players = new ArrayList<Player>();

		while (raf.getFilePointer() < file.length()) {
			Player player = new Player();
			player.setDeleted(raf.readBoolean());
			player.setPlayerName(raf.readUTF().trim());
			player.setPlayerPosition(raf.readUTF().trim());
			player.setPlayerNum(raf.readInt());
			player.setPlayerTeam(raf.readUTF().trim());
			player.setPlayerScores(raf.readInt());
			players.add(player);
		}
		
		System.out.println("A que jugador desea modificar el equipo | [Salir] para salir");
		do {
			playerNameToSearch = input.nextLine();
			
			System.out.println("Introduce el nuevo equipo");
			playerNewTeam = input.nextLine();			
			
			int i = 0;
			while(!playerNameToSearch.equals(players.get(i).getPlayerName()) && i < players.size() - 1) {
				i++;
			}
			if(playerNameToSearch.equals(players.get(i).getPlayerName())) {
				raf.seek(0);
				raf.skipBytes((i * 73) + 37);
				if(playerNewTeam.length() < 30) {
					raf.writeUTF(String.format("%-30s", playerNewTeam));
				} else {
					raf.writeUTF(playerNewTeam.substring(0, 29));
				}
			}
			System.out.println("A que jugador desea modificar los goles | [Salir] para salir");
		} while(!playerNameToSearch.equalsIgnoreCase("salir"));

		raf.close();
	}
}

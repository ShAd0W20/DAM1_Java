package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import models.Player;

public class EditPlayerScores {

	public static void editPlayerScores() throws FileNotFoundException, IOException {
		File file = new File("Players.bin");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		Scanner input = new Scanner(System.in);
		String playerNameToSearch = "";
		int playerScores = 0;		

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
		
		System.out.println("A que jugador desea modificar los goles | [Salir] para salir");
		do {
			playerNameToSearch = input.nextLine();
			
			System.out.println("Introduce los goles anotados");
			playerScores = input.nextInt();
			input.nextLine();
			
			int i = 0;
			while(!playerNameToSearch.equals(players.get(i).getPlayerName()) && i < players.size() - 1) {
				i++;
			}
			if(playerNameToSearch.equals(players.get(i).getPlayerName())) {
				raf.seek(0);
				raf.skipBytes((i * 73) + 69);
				raf.writeInt((players.get(i).getPlayerScores() + playerScores));
			}
			System.out.println("A que jugador desea modificar los goles | [Salir] para salir");
		} while(!playerNameToSearch.equalsIgnoreCase("salir"));

		raf.close();
	}

}

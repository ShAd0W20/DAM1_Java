package views.lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import models.Player;

public class ListPlayers {
	public static void listPlayers() throws FileNotFoundException, IOException {
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
		
		players.sort((o1, o2) -> o1.getPlayerTeam().compareTo(o2.getPlayerTeam()));
		
		for(Player p : players) {
			if(!p.isDeleted()) {
				System.out.println(p.isDeleted() + " " + p.getPlayerName() + " " + p.getPlayerPosition() + " " + p.getPlayerNum() + " " + p.getPlayerTeam() + " " + p.getPlayerScores());
			}
		}
		
	}
}

package views.lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import models.Player;

public class BestGoalKeeper {
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
		
		players.sort((o1, o2) -> (o1.getPlayerScores() - o2.getPlayerScores()));
		
		for(Player p : players) {
			if(p.getPlayerPosition().equals("Portero")) {
				System.out.println(p.isDeleted() + " " + p.getPlayerName() + " " + p.getPlayerPosition() + " " + p.getPlayerNum() + " " + p.getPlayerTeam() + " " + p.getPlayerScores());
			}
		}
		
	}
}

package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import models.Player;

public class AddPlayer {
	public static void registerPlayer() throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		File file = new File("Players.bin");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		
		Player player = new Player();
		player.setDeleted(false);
		
		System.out.println("Introduce el nombre del jugador");
		String playerName = input.nextLine();
		if(playerName.length() < 20) {
			player.setPlayerName(String.format("%-20s", playerName));
		} else {
			player.setPlayerName(playerName.substring(0, 19));
		}
		
		System.out.println("Introduce la posicion del jugador (Portero, defensa, Medio, Delantero)");
		String playerPos = input.nextLine();
		if(playerPos.length() < 8) {
			player.setPlayerPosition(String.format("%-8s", playerPos));
		} else {
			player.setPlayerPosition(playerPos.substring(0, 7));
		}
		
		System.out.println("Introduce el numero del jugador");
		player.setPlayerNum(input.nextInt());
		input.nextLine();
		
		System.out.println("Introduce el equipo del jugador");
		String playerTeam = input.nextLine();
		if(playerTeam.length() < 30) {
			player.setPlayerTeam(String.format("%-30s", playerTeam));
		} else {
			player.setPlayerTeam(playerTeam.substring(0, 29));
		}
		
		System.out.println("Introduce los goles del jugador");
		player.setPlayerScores(input.nextInt());
		input.nextLine();
		
		raf.seek(file.length());
		raf.writeBoolean(player.isDeleted());
		raf.writeUTF(player.getPlayerName());
		raf.writeUTF(player.getPlayerPosition());
		raf.writeInt(player.getPlayerNum());
		raf.writeUTF(player.getPlayerTeam());
		raf.writeInt(player.getPlayerScores());
		
		raf.close();
	}
}

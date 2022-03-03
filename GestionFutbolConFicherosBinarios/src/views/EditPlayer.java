package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import models.Player;

public class EditPlayer {

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
			
			
			int i = 0;
			while(!playerNameToSearch.equals(players.get(i).getPlayerName()) && i < players.size() - 1) {
				i++;
			}
			if(playerNameToSearch.equals(players.get(i).getPlayerName()) && !players.get(i).isDeleted()) {
				if(players.get(i).getPlayerPosition().equals("Portero")) {
					System.out.println("Introduce los goles no parados");
					playerScores = input.nextInt();
					input.nextLine();
					
					raf.seek(0);
					raf.skipBytes((i * 73) + 69);
					raf.writeInt((players.get(i).getPlayerScores() + playerScores));
				} else if(!players.get(i).getPlayerPosition().equals("Portero")) {
					System.out.println("Introduce los goles anotados");
					playerScores = input.nextInt();
					input.nextLine();
					
					raf.seek(0);
					raf.skipBytes((i * 73) + 69);
					raf.writeInt((players.get(i).getPlayerScores() + playerScores));
				}
			}
			if(!playerNameToSearch.equalsIgnoreCase("salir")) {
				System.out.println("A que jugador desea modificar los goles | [Salir] para salir");
			}
		} while(!playerNameToSearch.equalsIgnoreCase("salir"));

		raf.close();
		System.out.printf("%nPulse enter para volver al menu%n");
	}
	
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
			if(!playerNameToSearch.equalsIgnoreCase("salir")) {
				System.out.println("A que jugador desea modificar los goles | [Salir] para salir");
			}
		} while(!playerNameToSearch.equalsIgnoreCase("salir"));

		raf.close();
		System.out.printf("%nPulse enter para volver al menu%n");
	}
	
	public static void updateDeleted() throws FileNotFoundException, IOException {
		File file = new File("Players.bin");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		Scanner input = new Scanner(System.in);
		String playerNameToSearch = "";	

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
		
		System.out.println("Que jugador desea eliminar | [Salir] para salir");
		do {
			playerNameToSearch = input.nextLine();			
			
			int i = 0;
			while(!playerNameToSearch.equals(players.get(i).getPlayerName()) && i < players.size() - 1) {
				i++;
			}
			if(playerNameToSearch.equals(players.get(i).getPlayerName())) {
				System.out.println("Desea eliminarlo? Si / No");	
				if(input.nextLine().equalsIgnoreCase("si")) {
					raf.seek(0);
					raf.skipBytes((i * 73));
					raf.writeBoolean(true);
					System.out.println(playerNameToSearch + " eliminado");
				}
			}
			if(!playerNameToSearch.equalsIgnoreCase("salir")) {
				System.out.println("Que jugador desea eliminar | [Salir] para salir");
			}
		} while(!playerNameToSearch.equalsIgnoreCase("salir"));
		
		raf.close();
		System.out.printf("%nPulse enter para volver al menu%n");
	}

}

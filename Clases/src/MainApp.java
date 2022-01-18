import java.time.LocalDate;
import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<Player>();
		Player[] playersData = new Player[2];
		
		Player first = new Player();
		first.__constructor("Pepe", LocalDate.now(), "My Team", 3);
		players.add(first);
		players.add(first);
		
		for(Player p: players) {
			System.out.println(p.getPlayerData());
		}
		
		
		Player second = new Player();
		second.__constructor("Pepa", LocalDate.now(), "Their team", 0);
		
		Player third = new Player();
		third.__constructor("Pepito", LocalDate.now(), "Our team", 5);
		
		playersData[0] = second;
		playersData[1] = third;
		
		for(Player p: playersData) {
			System.out.println(p.getPlayerData());
		}
		
		
	}

}

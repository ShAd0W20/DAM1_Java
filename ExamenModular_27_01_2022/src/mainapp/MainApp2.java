package mainapp;

public class MainApp2 {

	public static void main(String[] args) {

		final int MAX_PLAYERS = 6;
		final int MAX_PLAYER_DATA = 4;

		String[][] jugadors = new String[MAX_PLAYERS][MAX_PLAYER_DATA];

		entrarJugador("Pepe", "Pivot", "Mi Equipo", 80, jugadors);
		entrarJugador("Pepa", "Aler", "Mi Equipo", 20, jugadors);
		entrarJugador("Maria", "Base", "Team", 15, jugadors);
		entrarJugador("Juan", "Pivot", "Barcelona", 90, jugadors);
		entrarJugador("Pablo", "Base", "Barcelona", 30, jugadors);
		entrarJugador("Irene", "Aler", "Team", 40, jugadors);

		System.out.println("Maxim anotador: " + maximAnotador(jugadors));
		System.out.println("Posicio: " + posicio(maximAnotador(jugadors), jugadors));
		System.out.println("Equip: " + equip(maximAnotador(jugadors), jugadors));
		System.out.println("Punts: " + punts(maximAnotador(jugadors), jugadors));
	}

	static void entrarJugador(String nom, String posicio, String equip, int punts, String[][] jugadors) {
		int i = 0;
		while (jugadors[i][0] != null) {
			i++;
		}
		if (jugadors[i][0] == null) {
			jugadors[i][0] = nom;
			jugadors[i][1] = posicio;
			jugadors[i][2] = equip;
			jugadors[i][3] = String.valueOf(punts);
		}
	}

	static String maximAnotador(String[][] jugadors) {
		String jugadorSort = "";
		for (int i = 0; i < jugadors.length - 1; i++) {

			for (int j = i + 1; j < jugadors.length; j++) {

					if(Integer.parseInt(jugadors[i][3]) < Integer.parseInt(jugadors[j][3])) {
						jugadorSort = jugadors[i][0];

						jugadors[i][0] = jugadors[j][0];

						jugadors[j][0] = jugadorSort;

						jugadorSort = jugadors[i][1];

						jugadors[i][1] = jugadors[j][1];

						jugadors[j][1] = jugadorSort;

						jugadorSort = jugadors[i][2];

						jugadors[i][2] = jugadors[j][2];

						jugadors[j][2] = jugadorSort;

						jugadorSort = jugadors[i][3];

						jugadors[i][3] = jugadors[j][3];

						jugadors[j][3] = jugadorSort;
					}
			}
		}

		return jugadors[0][0];
	}
	
	static String posicio(String nom, String[][] jugadors) {
		int i = 0;

		while (!nom.equalsIgnoreCase(jugadors[i][0]) && i < jugadors.length) {
			i++;
		}

		if (!nom.equalsIgnoreCase(jugadors[i][0])) {
			return "";
		}
		return jugadors[i][1];
	}
	
	static String equip(String nom, String[][] jugadors) {
		int i = 0;

		while (!nom.equalsIgnoreCase(jugadors[i][0]) && i < jugadors.length) {
			i++;
		}

		if (!nom.equalsIgnoreCase(jugadors[i][0])) {
			return "";
		}
		return jugadors[i][2];
	}
	
	static int punts(String nom, String[][] jugadors) {
		int i = 0;

		while (!nom.equalsIgnoreCase(jugadors[i][0]) && i < jugadors.length) {
			i++;
		}

		if (!nom.equalsIgnoreCase(jugadors[i][0])) {
			return 0;
		}
		return Integer.parseInt(jugadors[i][3]);
	}

}

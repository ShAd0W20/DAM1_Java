import java.util.Random;

public class JuegoDados {

	public static void main(String[] args) {
		int puntsJugador = 0;
		int puntsOrdinador = 0;
		
		puntsJugador = tirarDau();
		puntsOrdinador = tirarDau();
		
		System.out.println(resultatActualTirada(puntsJugador, puntsOrdinador));
		System.out.println(guanyadorTirada(puntsJugador, puntsOrdinador));
		System.out.println(resultatActualPartida(puntsJugador, puntsOrdinador));
		System.out.println(guanyadorPartida(puntsJugador, puntsOrdinador));

	}
	
	static int tirarDau() {
		Random r = new Random();
		return r.nextInt(6 + 1);
	}
	
	static String resultatActualTirada(int puntsJugador, int puntsOrdinador) {
		return "Tirada: Jugador " + puntsJugador + " punts - Ordinador " +  puntsOrdinador + " punts";
	}
	
	static String guanyadorTirada(int valorJugador, int valorOrdinador) {
		String winner = "";
		if(valorJugador > valorOrdinador) {
			winner = "Jugador";
		} else if(valorJugador < valorOrdinador) {
			winner = "Ordinador";			
		} else {
			winner = "Empat";
		}
		return winner;
	}
	
	static String resultatActualPartida(int puntsJugador, int puntsOrdinador) {
		return "Partida: Jugador " + puntsJugador + " punts - Ordinador " +  puntsOrdinador + " punts";
	}
	
	static String guanyadorPartida(int puntsJugador, int puntsOrdinador) {
		String winner = "";
		if(puntsJugador >= 5) {
			winner = "Jugador";			
		} else if(puntsOrdinador >= 5) {
			winner = "Ordinador";			
		} else {
			winner = "Cap";
		}
		return winner;
	}

}

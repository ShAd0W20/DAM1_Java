package mainapp;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import models.Corredor;
import models.Maraton;
import models.Resultado;

public class MainApp {
	public static void main(String[] args) {
		Maraton maraton = new Maraton(1, "Maraton1", 10, LocalDate.now());
		
		Corredor c = new Corredor("19191919L", "Pepe", "Masculino", LocalDate.of(1995, 1, 15), null, null, null);
		Corredor c2 = new Corredor("28282828F", "Maria", "Femenino", LocalDate.of(1970, 1, 15), null, null, null);
		Corredor c3 = new Corredor("37373737F", "Irene", "Femenino", LocalDate.of(2000, 1, 15), null, null, null);
		Corredor c4 = new Corredor("46464646O", "Lolo", "Masculino", LocalDate.of(1994, 1, 15), null, null, null);
		
		Resultado r = new Resultado(c, Duration.ZERO);
		Resultado r2 = new Resultado(c2, Duration.ZERO);
		Resultado r3 = new Resultado(c3, Duration.ZERO);
		Resultado r4 = new Resultado(c4, Duration.ZERO);
		if(maraton.addResultado(r)) {
			System.out.println("[+] OK");
		} else {
			System.out.println("[!] ERROR");
		}
		if(maraton.addResultado(r2)) {
			System.out.println("[+] OK");
		} else {
			System.out.println("[!] ERROR");
		}
		if(maraton.addResultado(r3)) {
			System.out.println("[+] OK");
		} else {
			System.out.println("[!] ERROR");
		}
		if(maraton.addResultado(r4)) {
			System.out.println("[+] OK");
		} else {
			System.out.println("[!] ERROR");
		}
		
		System.out.println(maraton.getAllCorredores());
		System.out.println(maraton.getAllCorredoresFromCategory("Absoluto Femenino"));
		System.out.println(maraton.getAllCorredoresOrderByCategory());
		
		registerResult(r.getDorsalCorredor(), 7421, maraton);
		registerResult(r2.getDorsalCorredor(), 6421, maraton);
		registerResult(r3.getDorsalCorredor(), 8421, maraton);
		registerResult(r4.getDorsalCorredor(), 10421, maraton);
		
		System.out.println(maraton.getAllResults());
		System.out.println(maraton.getAllResultsFromCategory("Absoluto Femenino"));
		System.out.println(maraton.getAllResultsOrderByCategory());
		
	}
	
	private static void registerResult(int dorsal, int time, Maraton maraton) {
		int[][] result = new int[1][2];
		result[0][0] = dorsal;
		result[0][1] = time;
		maraton.editResult(result);
	}
}

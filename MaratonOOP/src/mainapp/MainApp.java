package mainapp;

import java.time.Duration;
import java.time.LocalDate;

import models.Corredor;
import models.Maraton;
import models.Resultado;

public class MainApp {
	public static void main(String[] args) {
		Maraton maraton = new Maraton(1, "Maraton1", 10, LocalDate.now());
		
		Corredor c = new Corredor("19191919L", "Pepe", LocalDate.of(1999, 1, 15), null, null, null);
		
		Resultado r = new Resultado(c, Duration.ZERO);
		Resultado r2 = new Resultado(c, Duration.ZERO);
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
	}
}

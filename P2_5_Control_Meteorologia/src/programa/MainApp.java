package programa;

import java.time.LocalDate;
import java.util.Random;

import biblioteca.meteorologia.Pluja;

public class MainApp {

	public static void main(String[] args) {
		DiaMeteo[] dias = new DiaMeteo[365];
		Random rnd = new Random();

		for (int i = 0; i < dias.length; i++) {
			DiaMeteo dia = new DiaMeteo();
			
			dia.tempMax = rnd.nextInt((30 - 10)) + 10;
			dia.tempMin = rnd.nextInt(10);
			dia.pluja = rnd.nextInt(100);
			dia.ventMax = rnd.nextInt(80);
			dia.dia = LocalDate.of(2021, (rnd.nextInt(12) + 1), (rnd.nextInt(28) + 1));
			
			dias[i] = dia;
		}
		
		System.out.println(Pluja.mitjanaMensualPluja("Febrer", dias));
		
	}

}

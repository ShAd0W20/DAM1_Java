package mainapp;

import java.time.LocalDate;

import models.Alumno;
import models.Futbolista;

public class MainApp {

	public static void main(String[] args) {
		Alumno a = new Alumno("Pepe", LocalDate.now(), "49381127F", "DAM", 1);
		Futbolista f = new Futbolista("Irene", LocalDate.now(), "69823432E", "Delantero", "Barcelona", 1);
		
		System.out.println(a.toString());
		
		a.setName("Irene");
		
		System.out.println(a.toString());
		
		System.out.println("\n" + f.getName() + " " + f.getDni());
	}

}

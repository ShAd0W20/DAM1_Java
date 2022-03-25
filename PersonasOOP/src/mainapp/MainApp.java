package mainapp;

import java.time.LocalDate;

import models.Alumno;
import models.Futbolista;
import models.Persona;

public class MainApp {

	public static void main(String[] args) {
		Alumno a = new Alumno("Pepe", LocalDate.now(), "49381127F", "DAM", 1);
		Futbolista f = new Futbolista("Irene", LocalDate.now(), "69823432E", "Delantero", "Barcelona", 1);
		
		System.out.println(a.toString() + "\n");

		System.out.println(f.toString() + "\n");
		
		System.out.println(Alumno.getTotalStudents());
		System.out.println(Futbolista.getTotalPlayers());
		
		
		
	}

}

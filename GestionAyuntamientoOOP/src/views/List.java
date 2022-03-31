package views;

import models.Alumno;
import models.Ayuntamiento;
import models.Baloncesto;
import models.CF;
import models.Deportista;
import models.ESO;
import models.Futbolista;
import models.Persona;

public class List {
	public static void ListAllESO(Ayuntamiento townHall) {
		for(ESO e : townHall.getEsoStudents()) {
			System.out.println(e.toString());
		}
	}
	
	public static void ListAllCF(Ayuntamiento townHall) {
		for(CF c : townHall.getCfStudents()) {
			System.out.println(c.toString());
		}
	}
	
	public static void ListAllFootBallPlayers(Ayuntamiento townHall) {
		for(Futbolista f : townHall.getFutbolPlayers()) {
			System.out.println(f.toString());
		}
	}
	
	public static void ListAllBasketBallPlayers(Ayuntamiento townHall) {
		for(Baloncesto b : townHall.getBasketballPlayers()) {
			System.out.println(b.toString());
		}
	}
	
	public static void ListAllStudents(Ayuntamiento townHall) {
		for(Alumno a : townHall.getAllStudents()) {
			System.out.println(a.toString());
		}
	}
	
	public static void ListAllSports(Ayuntamiento townHall) {
		for(Deportista d : townHall.getAllDeportUsers()) {
			System.out.println(d.toString());
		}
	}
	
	public static void ListAllPersons(Ayuntamiento townHall) {
		for(Persona p : townHall.getAllPersons()) {
			System.out.println(p.toString());
		}
	}
}

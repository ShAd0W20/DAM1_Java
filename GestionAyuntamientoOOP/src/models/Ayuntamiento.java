package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Ayuntamiento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3187740531915233618L;
	private String townHallName;
	private ArrayList<ESO> esoStudents;
	private ArrayList<CF> cfStudents;
	private ArrayList<Futbolista> futbolPlayers;
	private ArrayList<Baloncesto> basketballPlayers;

	public Ayuntamiento(String townHallName) {
		super();
		this.townHallName = townHallName;
		this.esoStudents = new ArrayList<ESO>();
		this.cfStudents = new ArrayList<CF>();
		this.futbolPlayers = new ArrayList<Futbolista>();
		this.basketballPlayers = new ArrayList<Baloncesto>();
	}

	public String getTownHallName() {
		return townHallName;
	}

	public void setTownHallName(String townHallName) {
		this.townHallName = townHallName;
	}

	public ArrayList<ESO> getEsoStudents() {
		return esoStudents;
	}

	public void addEsoStudent(ESO esoStudents) {
		this.esoStudents.add(esoStudents);
	}

	public ArrayList<CF> getCfStudents() {
		return cfStudents;
	}

	public void addCfStudents(CF cfStudents) {
		this.cfStudents.add(cfStudents);
	}

	public ArrayList<Futbolista> getFutbolPlayers() {
		return futbolPlayers;
	}

	public void addFutbolPlayers(Futbolista futbolPlayers) {
		this.futbolPlayers.add(futbolPlayers);
	}

	public ArrayList<Baloncesto> getBasketballPlayers() {
		return basketballPlayers;
	}

	public void addBasketballPlayers(Baloncesto basketballPlayers) {
		this.basketballPlayers.add(basketballPlayers);
	}

	public ArrayList<Deportista> getAllDeportUsers() {
		ArrayList<Deportista> allDeportUsers = new ArrayList<>();

		for (Futbolista f : this.getFutbolPlayers()) {
			allDeportUsers.add(f);
		}

		for (Baloncesto b : this.getBasketballPlayers()) {
			allDeportUsers.add(b);
		}

		return allDeportUsers;
	}

	public ArrayList<Alumno> getAllStudents() {
		ArrayList<Alumno> allUsers = new ArrayList<>();

		for (ESO e : this.getEsoStudents()) {
			allUsers.add(e);
		}

		for (CF c : this.getCfStudents()) {
			allUsers.add(c);
		}

		return allUsers;
	}
	
	public ArrayList<Persona> getAllPersons() {
		ArrayList<Persona> allPersons = new ArrayList<>();
		
		for(Alumno a : this.getAllStudents()) {
			allPersons.add(a);
		}
		
		for(Deportista d : this.getAllDeportUsers()) {
			allPersons.add(d);
		}
		
		return allPersons;
	}

}

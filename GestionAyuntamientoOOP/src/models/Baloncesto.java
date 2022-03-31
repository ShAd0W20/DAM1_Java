package models;

import java.io.Serializable;
import java.time.LocalDate;

public class Baloncesto extends Deportista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1645949011264466290L;
	private String teamName;
	private String position;
	private int scores;
	private int fails;

	public Baloncesto(String DNI, String name, LocalDate birthDay, String id, String sportType, String teamName,
			String position, int scores, int fails) {
		super(DNI, name, birthDay, id, sportType);
		this.teamName = teamName;
		this.position = position;
		this.scores = scores;
		this.fails = fails;
	}

	public String getTeamName() {
		return teamName;
	}

	public String getPosition() {
		return position;
	}

	public int getScores() {
		return scores;
	}

	public int getFails() {
		return fails;
	}

	@Override
	public String toString() {
		return "[+] DNI: " + this.getDNI() + " [+] Nombre: " + this.getName() + " [+] Fecha nacimiento: " + this.getBirthDay() + " [+] Codigo: " + this.getId() + " [+] Deporte: " + this.getSportType() + " [+] Equipo: " + this.teamName + " [+] Posicion: " + this.position + " [+] Puntos: " + this.scores + " [+] Faltas: " + this.fails;
	}
	
}

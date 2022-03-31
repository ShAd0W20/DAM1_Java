package models;

import java.io.Serializable;
import java.time.LocalDate;

public class Futbolista extends Deportista implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5302120023518841723L;
	private String teamName;
	private String position;
	private int scores;
	private int cards;

	public Futbolista(String DNI, String name, LocalDate birthDay, String id, String sportType, String teamName,
			String position, int scores, int cards) {
		super(DNI, name, birthDay, id, sportType);
		this.teamName = teamName;
		this.position = position;
		this.scores = scores;
		this.cards = cards;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}

	public int getCards() {
		return cards;
	}

	public void setCards(int cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "[+] DNI: " + this.getDNI() + " [+] Nombre: " + this.getName() + " [+] Fecha nacimiento: " + this.getBirthDay() + " [+] Codigo: " + this.getId() + " [+] Deporte: " + this.getSportType() + " [+] Equipo: " + this.teamName + " [+] Posicion: " + this.position + " [+] Puntos: " + this.scores + " [+] Faltas: " + this.cards;
	}
	
}

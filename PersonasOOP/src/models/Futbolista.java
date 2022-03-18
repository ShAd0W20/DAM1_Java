package models;

import java.time.LocalDate;

public class Futbolista extends Persona {
	
	private String position;
	private String team;
	private int scores;

	public Futbolista(String name, LocalDate birthDay, String dni, String position, String team, int scores) {
		super(name, birthDay, dni);
		this.position = position;
		this.team = team;
		this.scores = scores;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int scores) {
		this.scores = scores;
	}

}

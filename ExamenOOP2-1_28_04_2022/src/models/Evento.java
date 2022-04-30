package models;

import java.time.LocalDate;

public abstract class Evento {
	private LocalDate date;

	public Evento(LocalDate date) {
		super();
		this.date = date;
	}

	public abstract String descripcion();

	public LocalDate getDate() {
		return this.date;
	}
}

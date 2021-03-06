package models;

import java.time.LocalDate;
import java.time.Period;

public class Cumpleaņos extends Evento {
	private String name;
	private LocalDate birthDate;

	public Cumpleaņos(LocalDate date, String name, LocalDate birthDate) {
		super(date);
		this.name = name;
		this.birthDate = birthDate;
	}

	@Override
	public String descripcion() {
		return String.format("Cumpleaņos de %s que hace %d %n", this.name, Period.between(birthDate, LocalDate.now()).getYears());
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

}

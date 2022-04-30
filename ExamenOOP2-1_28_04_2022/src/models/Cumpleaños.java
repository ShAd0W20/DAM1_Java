package models;

import java.time.LocalDate;
import java.time.Period;

public class Cumplea�os extends Evento {
	private String name;
	private LocalDate birthDate;

	public Cumplea�os(LocalDate date, String name, LocalDate birthDate) {
		super(date);
		this.name = name;
		this.birthDate = birthDate;
	}

	@Override
	public String descripcion() {
		return String.format("Cumplea�os de %s que hace %d %n", this.name, Period.between(birthDate, LocalDate.now()).getYears());
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

}

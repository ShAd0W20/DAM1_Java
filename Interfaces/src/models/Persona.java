package models;

import java.time.LocalDate;

public abstract class Persona {
	private final String DNI;
	private String name;
	private LocalDate birthDate;

	public Persona(String dNI, String name, LocalDate birthDate) {
		super();
		DNI = dNI;
		this.name = name;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getDNI() {
		return DNI;
	}

}

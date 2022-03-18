package models;

import java.time.LocalDate;

public class Persona {
	protected String name;
	private LocalDate birthDate;
	private String dni;

	public Persona(String name, LocalDate birthDay, String dni) {
		this.name = name;
		this.birthDate = birthDay;
		this.dni = dni;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}

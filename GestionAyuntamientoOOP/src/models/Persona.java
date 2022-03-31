package models;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4219377829289331027L;
	private String DNI;
	private String name;
	private LocalDate birthDay;

	public Persona(String DNI, String name, LocalDate birthDay) {
		super();
		this.DNI = DNI;
		this.name = name;
		this.birthDay = birthDay;
	}

	public String getDNI() {
		return DNI;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}
	
	@Override
	public String toString() {
		return "[+] DNI: " + this.DNI + " [+] Nombre: " + this.name + " [+] Fecha nacimiento: " + this.birthDay;
	}

}

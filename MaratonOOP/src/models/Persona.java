package models;

import java.time.LocalDate;

public abstract class Persona {
	private String DNI;
	private String nombre;
	private LocalDate fechaNacimiento;

	public Persona(String dNI, String nombre, LocalDate fechaNacimiento) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

}

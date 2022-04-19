package models;

import java.time.LocalDate;
import java.time.Period;

public abstract class Persona {
	private String DNI;
	private String nombre;
	private String sexo;
	private LocalDate fechaNacimiento;

	public Persona(String dNI, String nombre, String sexo, LocalDate fechaNacimiento) {
		super();
		this.DNI = dNI;
		this.nombre = nombre;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getSexo() {
		return sexo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getAge() {
		if ((this.fechaNacimiento != null) && (LocalDate.now() != null)) {
			return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
		}
		return 0;
	}

}

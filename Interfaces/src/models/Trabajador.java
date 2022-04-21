package models;

import java.time.LocalDate;

public class Trabajador extends Persona implements Trabajo {

	private int salarioTrabajo;
	private String nombreTrabajo;

	public Trabajador(String dNI, String name, LocalDate birthDate, int salarioTrabajo, String nombreTrabajo) {
		super(dNI, name, birthDate);
		this.salarioTrabajo = salarioTrabajo;
		this.nombreTrabajo = nombreTrabajo;
	}

	@Override
	public String getNombreTrabajo() {
		return this.nombreTrabajo;
	}

	@Override
	public void setNombreTrabajo(String trabajo) {
		this.nombreTrabajo = trabajo;

	}

	@Override
	public int getSalarioTrabajo() {
		return this.salarioTrabajo;
	}

	@Override
	public void setSalarioTrabajo(int salario) {
		this.salarioTrabajo = salario;

	}

}

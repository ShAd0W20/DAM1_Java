package models;

import java.time.LocalDate;
import java.time.LocalTime;

import models.enums.ModulesDAM;

public class Examen extends Evento {
	private ModulesDAM modulo;
	private LocalTime horaInicio;
	private LocalTime horaFinal;

	public Examen(LocalDate date, ModulesDAM modulo, LocalTime horaInicio, LocalTime horaFinal) {
		super(date);
		this.modulo = modulo;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}

	@Override
	public String descripcion() {
		return String.format("Examen de %s de %s a %s %n", modulo.getModuleName(), this.horaInicio, this.horaFinal);
	}

	public String getModulo() {
		return modulo.getModuleName();
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

}

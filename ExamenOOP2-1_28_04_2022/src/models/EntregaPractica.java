package models;

import java.time.LocalDate;
import java.time.LocalTime;

import models.enums.ModulesDAM;

public class EntregaPractica extends Evento {
	private ModulesDAM modulo;
	private LocalTime horaFinal;

	public EntregaPractica(LocalDate date, ModulesDAM modulo, LocalTime horaFinal) {
		super(date);
		this.modulo = modulo;
		this.horaFinal = horaFinal;
	}

	@Override
	public String descripcion() {
		return String.format("Entrega de la practica de %s antes de %s%n", modulo.getModuleName(), this.horaFinal);
	}

	public String getModulo() {
		return modulo.getModuleName();
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

}

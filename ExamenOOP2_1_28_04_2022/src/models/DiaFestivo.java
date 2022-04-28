package models;

import java.time.LocalDate;

public class DiaFestivo extends Evento {
	private String nombreFesitvo;

	public DiaFestivo(LocalDate date, String nombreFesitvo) {
		super(date);
		this.nombreFesitvo = nombreFesitvo;
	}

	@Override
	public String descripcion() {
		return String.format("Fiesta de %s%n", this.nombreFesitvo);
	}

	public String getNombreFesitvo() {
		return nombreFesitvo;
	}

}

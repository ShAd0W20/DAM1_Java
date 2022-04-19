package models;

import java.time.LocalDate;

public class Corredor extends Persona implements Correr {
	private String marcaBambas;

	public Corredor(String dNI, String name, LocalDate birthDate, String marcaBambas) {
		super(dNI, name, birthDate);
		this.marcaBambas = marcaBambas;
	}

	public String getMarcaBambas() {
		return marcaBambas;
	}

	public void setMarcaBambas(String marcaBambas) {
		this.marcaBambas = marcaBambas;
	}

}

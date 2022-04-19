package models;

import java.time.LocalDate;

public class Triatleta extends Persona implements Correr, Ciclismo, Natacion {

	private String marcaBici;
	private String marcaBambas;
	private String marcaNeopreno;

	public Triatleta(String dNI, String name, LocalDate birthDate, String marcaBici, String marcaBambas, String marcaNeopreno) {
		super(dNI, name, birthDate);
		this.marcaBici = marcaBici;
		this.marcaBambas = marcaBambas;
		this.marcaNeopreno = marcaNeopreno;
	}

	@Override
	public String getMarcaBici() {
		return this.marcaBici;
	}

	@Override
	public void setMarcaBici(String value) {
		this.marcaBici = value;
	}

	@Override
	public String getMarcaBambas() {
		return this.marcaBambas;
	}

	@Override
	public void setMarcaBambas(String marca) {
		this.marcaBambas = marca;
	}

	@Override
	public String getMarcaNeopreno() {
		return this.marcaNeopreno;
	}

	@Override
	public void setMarcaNeopreno(String value) {
		this.marcaNeopreno = value;

	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s %s %s", this.getDNI(), this.getName(), this.marcaBambas, this.marcaBici, this.marcaNeopreno);
	}

}

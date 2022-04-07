package models;

public class Vehiculo {
	private String matricula;
	private String tipo;

	public Vehiculo(String matricula, String tipo) {
		super();
		this.matricula = matricula;
		this.tipo = tipo;
	}

	public String getMatricula() {
		return matricula;
	}

	public String info() {
		return this.tipo + " con matricula: " + this.matricula;
	}
}

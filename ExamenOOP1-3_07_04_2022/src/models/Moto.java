package models;

public class Moto extends Vehiculo {
	private String tipoMoto;

	public Moto(String matricula, String tipo, String tipoMoto) {
		super(matricula, tipo);
		this.tipoMoto = tipoMoto;
	}
	
	public String info() {
		return "Moto de " + this.tipoMoto + " con matricula: " + super.getMatricula();
	}
}

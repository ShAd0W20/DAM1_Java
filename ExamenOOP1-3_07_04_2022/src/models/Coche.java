package models;

public class Coche extends Vehiculo {
	private String tipoCoche;

	public Coche(String matricula, String tipo, String tipoCoche) {
		super(matricula, tipo);
		this.tipoCoche = tipoCoche;
	}
	
	public String info() {
		return "Coche " + this.tipoCoche + " con matricula: " + super.getMatricula();
	}
}

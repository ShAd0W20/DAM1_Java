package models;

public class Ordenador extends Equipo {

	private int ram;
	private String procesador;
	private String discoDuro;

	public Ordenador(String codigo, String marca, String modelo, String ubicacion, String estado, int ram, String procesador, String discoDuro) {
		super(codigo, marca, modelo, ubicacion, estado);
		this.ram = ram;
		this.procesador = procesador;
		this.discoDuro = discoDuro;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getProcesador() {
		return procesador;
	}

	public String getDiscoDuro() {
		return discoDuro;
	}

	public void setDiscoDuro(String discoDuro) {
		this.discoDuro = discoDuro;
	}

}

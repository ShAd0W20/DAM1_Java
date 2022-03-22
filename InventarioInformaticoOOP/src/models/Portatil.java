package models;

public class Portatil extends Ordenador {

	private int pulgadasPantalla;
	private String conexionExterna;
	
	public Portatil(String codigo, String marca, String modelo, String ubicacion, String estado, int ram, String procesador, String discoDuro, int pulgadasPantalla, String conexionExterna) {
		super(codigo, marca, modelo, ubicacion, estado, ram, procesador, discoDuro);
		this.pulgadasPantalla = pulgadasPantalla;
		this.conexionExterna = conexionExterna;
	}

	public int getPulgadasPantalla() {
		return pulgadasPantalla;
	}

	public String getConexionExterna() {
		return conexionExterna;
	}	
	
}

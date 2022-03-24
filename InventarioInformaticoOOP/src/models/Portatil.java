package models;

import java.io.Serializable;

public class Portatil extends Ordenador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3532678287391484792L;
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

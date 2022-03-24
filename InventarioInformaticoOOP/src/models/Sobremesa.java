package models;

import java.io.Serializable;

public class Sobremesa extends Ordenador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2533016223682275074L;
	private String pantalla;
	private String tipoPerifericos;
	
	public Sobremesa(String codigo, String marca, String modelo, String ubicacion, String estado, int ram, String procesador, String discoDuro, String pantalla, String tipoPerifericos) {
		super(codigo, marca, modelo, ubicacion, estado, ram, procesador, discoDuro);
		this.pantalla = pantalla;
		this.tipoPerifericos = tipoPerifericos;
	}

	public String getPantalla() {
		return pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}

	public String getTipoPerifericos() {
		return tipoPerifericos;
	}

	public void setTipoPerifericos(String tipoPerifericos) {
		this.tipoPerifericos = tipoPerifericos;
	}
}

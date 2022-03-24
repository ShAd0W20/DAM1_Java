package models;

import java.io.Serializable;

public class Proyector extends Equipo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8594552372132921636L;
	private String conectorActual;
	private int lumnes;
	private String resolucion;
	
	public Proyector(String codigo, String marca, String modelo, String ubicacion, String estado, String conectorActual, int lumnes, String resolucion) {
		super(codigo, marca, modelo, ubicacion, estado);
		this.conectorActual = conectorActual;
		this.lumnes = lumnes;
		this.resolucion = resolucion;
	}

	public String getConectorActual() {
		return conectorActual;
	}

	public void setConectorActual(String conectorActual) {
		this.conectorActual = conectorActual;
	}

	public int getLumnes() {
		return lumnes;
	}

	public String getResolucion() {
		return resolucion;
	}

}

package models;

import java.io.Serializable;

public abstract class Equipo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8538299009632123585L;
	private String codigo;
	private String marca;
	private String modelo;
	private String ubicacion;
	private String estado;
	
	public Equipo(String codigo, String marca, String modelo, String ubicacion, String estado) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.ubicacion = ubicacion;
		this.estado = estado;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}

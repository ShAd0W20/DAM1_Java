package models;

public class Impresora extends Equipo {

	private String tipo;
	private String conexionActual;
	
	public Impresora(String codigo, String marca, String modelo, String ubicacion, String estado, String tipo, String conexionActual) {
		super(codigo, marca, modelo, ubicacion, estado);
		this.tipo = tipo;
		this.conexionActual = conexionActual;
	}

	public String getTipo() {
		return tipo;
	}

	public String getConexionActual() {
		return conexionActual;
	}

	public void setConexionActual(String conexionActual) {
		this.conexionActual = conexionActual;
	}

	
}

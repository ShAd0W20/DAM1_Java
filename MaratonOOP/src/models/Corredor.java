package models;

import java.time.Duration;
import java.time.LocalDate;

public class Corredor extends Persona {

	private String categoria;
	private Duration MejorTiempo10KM;
	private Duration MejorTiempo21KM;
	private Duration MejorTiempo42KM;

	public Corredor(String dNI, String nombre, LocalDate fechaNacimiento, Duration mejorTiempo10KM, Duration mejorTiempo21KM, Duration mejorTiempo42KM) {
		super(dNI, nombre, fechaNacimiento);
		MejorTiempo10KM = mejorTiempo10KM;
		MejorTiempo21KM = mejorTiempo21KM;
		MejorTiempo42KM = mejorTiempo42KM;
	}

	public String getCategoria() {
		return categoria;
	}

	public Duration getMejorTiempo10KM() {
		return MejorTiempo10KM;
	}

	public void setMejorTiempo10KM(Duration mejorTiempo10KM) {
		MejorTiempo10KM = mejorTiempo10KM;
	}

	public Duration getMejorTiempo21KM() {
		return MejorTiempo21KM;
	}

	public void setMejorTiempo21KM(Duration mejorTiempo21KM) {
		MejorTiempo21KM = mejorTiempo21KM;
	}

	public Duration getMejorTiempo42KM() {
		return MejorTiempo42KM;
	}

	public void setMejorTiempo42KM(Duration mejorTiempo41KM) {
		MejorTiempo42KM = mejorTiempo41KM;
	}
}

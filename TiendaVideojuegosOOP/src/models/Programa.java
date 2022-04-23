package models;

import models.enums.ProgramTypes;

import java.io.Serializable;

import models.enums.OSTypes;

public class Programa extends Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3080829333241378548L;
	private ProgramTypes type;
	private OSTypes osType;

	public Programa(String code, String name, double price, int stock, int sells, ProgramTypes type, OSTypes osType) {
		super(code, name, price, stock, sells);
		this.type = type;
		this.osType = osType;
	}

	public String getType() {
		return this.type.getProgramType();
	}

	public String getOsType() {
		return osType.getOsType();
	}

	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10s %-10s %-10s %n", this.getCode(), this.getName(), this.getPrice(), this.getSells(), this.getStock());
	}
}

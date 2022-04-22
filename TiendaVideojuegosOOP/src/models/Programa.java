package models;

import enums.OSTypes;
import enums.ProgramTypes;

public class Programa extends Producto {

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

}

package modules;

import java.util.ArrayList;

import modules.enums.Oficina;

public class Cliente extends Persona {
	private Oficina oficina;
	private ArrayList<Cuenta> cuentas;

	public Cliente(String dNI, String name, Oficina oficina) {
		super(dNI, name);
		this.oficina = oficina;
		this.cuentas = new ArrayList<>();
	}

	public Oficina getOficina() {
		return oficina;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public void addCuenta(Cuenta c) {
		this.cuentas.add(c);
	}

}

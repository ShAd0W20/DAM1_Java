package modules;

import java.time.LocalDateTime;
import java.util.ArrayList;

import modules.enums.TipoOperacion;

public class Cuenta {
	private int numeroCuenta;
	private Cliente due�o;
	private int saldo;
	private ArrayList<Operacion> operaciones;

	public Cuenta(int numeroCuenta, Cliente due�o, int saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.due�o = due�o;
		this.saldo = saldo;
		this.operaciones = new ArrayList<>();
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public Cliente getDue�o() {
		return due�o;
	}

	public int getSaldo() {
		return saldo;
	}

	public ArrayList<Operacion> getOperaciones() {
		return operaciones;
	}
	
	public void ingreso(int cantidad) {
		this.saldo += cantidad;
		
		Operacion o = new Operacion(LocalDateTime.now(), TipoOperacion.INGRESO, cantidad, this.saldo);
		
		this.operaciones.add(o);
	}
	
	public boolean reintegro(int cantidad) {
		if (this.saldo >= cantidad) {
			this.saldo -= cantidad;
			Operacion o = new Operacion(LocalDateTime.now(), TipoOperacion.REINTEGRO, cantidad, this.saldo);			
			this.operaciones.add(o);
			return true;
		}
		
		return false;
	}
	
	public boolean transferencia(int cantidad, Cuenta other) {
		if (this.saldo >= cantidad) {
			this.saldo -= cantidad;
			other.ingreso(cantidad);
			Operacion o = new Operacion(LocalDateTime.now(), TipoOperacion.TRANSFER, cantidad, this.saldo);			
			this.operaciones.add(o);
			return true;
		}		
		
		return false;
	}
}

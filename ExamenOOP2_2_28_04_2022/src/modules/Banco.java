package modules;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Banco {
	private ArrayList<Cliente> clientes;
	private ArrayList<Cuenta> cuentas;
	private static int numeroCuenta = 1;

	public Banco() {
		super();
		this.clientes = new ArrayList<Cliente>();
		this.cuentas = new ArrayList<Cuenta>();
	}

	public void addCliente(Cliente c) {
		this.clientes.add(c);
	}

	public boolean addCuenta(String dni, int salario) {
		if (findCliente(dni) != null) {
			Cuenta c = new Cuenta(numeroCuenta, findCliente(dni), salario);
			this.cuentas.add(c);
			findCliente(dni).addCuenta(c);
			Banco.numeroCuenta++;
			return true;
		}
		return false;
	}

	public void ingreso(int numeroCuenta, int cantidad) {
		if (findCuentaID(numeroCuenta) != null) {
			findCuentaID(numeroCuenta).ingreso(cantidad);
		}
	}

	public void reintegramiento(int numeroCuenta, int cantidad) {
		if (findCuentaID(numeroCuenta) != null) {
			findCuentaID(numeroCuenta).reintegro(cantidad);
		}
	}

	public String transferencia(int numeroCuentaEmisor, int numeroCuentaReceptor, int cantidad) {
		if (findCuentaID(numeroCuentaEmisor) != null && findCuentaID(numeroCuentaReceptor) != null) {
			Cuenta emisor = findCuentaID(numeroCuentaEmisor);
			Cuenta receptor = findCuentaID(numeroCuentaReceptor);
			if (!emisor.transferencia(cantidad, receptor)) {
				return "Dinero emisor insuficiente";
			} else {
				return "";
			}
		} else {
			return "Cuenta no encontrada";
		}
	}

	public String informeCuenta(int numeroCuenta) {
		String data = "";
		if (findCuentaID(numeroCuenta) != null) {
			Cuenta cuenta = findCuentaID(numeroCuenta);
			for (Operacion o : cuenta.getOperaciones()) {
				data += String.format("Tiempo: %s  Tipo: %s  Importe: %d  Saldo: %d%n", o.momentoOperacion.format(DateTimeFormatter.ofPattern("d/M/Y hh:m:ss")), o.tipo.getName(), o.importe, o.importeAfter);
			}
			return data;
		} else {
			return "Cuenta no encontrada";
		}
	}

	public String informeCliente(String dni) {
		String data = "";
		if (findCliente(dni) != null) {
			Cliente cliente = findCliente(dni);

			if (!cliente.getCuentas().isEmpty()) {
				for (Cuenta c : cliente.getCuentas()) {
					data += String.format("Cuenta: %s%n", c.getNumeroCuenta());
					for (Operacion o : c.getOperaciones()) {
						data += String.format("Tiempo: %s  Tipo: %s  Importe: %d  Saldo: %d%n", o.momentoOperacion.format(DateTimeFormatter.ofPattern("d/M/Y hh:m:ss")), o.tipo.getName(), o.importe, o.importeAfter);
					}
				}
				return data;
			} else {
				return "Cliente sin cuentas";
			}
		} else {
			return "Cliente no encontrado";
		}
	}

	private Cliente findCliente(String dni) {
		int i = 0;
		if (!this.clientes.isEmpty()) {
			while (!dni.equalsIgnoreCase(this.clientes.get(i).getDNI()) && i < (this.clientes.size() - 1)) {
				i++;
			}
		} else {
			return null;
		}

		if (dni.equalsIgnoreCase(this.clientes.get(i).getDNI())) {
			return this.clientes.get(i);
		}

		return null;
	}

	private Cuenta findCuentaID(int id) {
		int i = 0;
		if (!this.cuentas.isEmpty()) {
			while (i < (this.cuentas.size() - 1) && id != this.cuentas.get(i).getNumeroCuenta()) {
				i++;
			}
		} else {
			return null;
		}

		if (id == this.cuentas.get(i).getNumeroCuenta()) {
			return this.cuentas.get(i);
		}

		return null;
	}
}

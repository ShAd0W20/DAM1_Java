package models;

public class Impresora extends Equipo {
	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String getCodigo() {
		return String.valueOf(this.codigo);
	}
}

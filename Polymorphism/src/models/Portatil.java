package models;

public class Portatil extends Equipo {
	private String disco;

	public String getDisco() {
		return disco;
	}

	public void setDisco(String disco) {
		this.disco = disco;
	}

	@Override
	public String getCodigo() {
		return String.valueOf(this.codigo);
	}
}

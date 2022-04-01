package models;

public abstract class Equipo {
	protected int codigo;
	private String nombre;

	public abstract String getCodigo();

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

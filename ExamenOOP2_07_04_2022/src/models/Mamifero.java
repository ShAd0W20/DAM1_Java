package models;

public class Mamifero extends Animal {

	private String alimentacion;
	private int diasGestacion;
	private boolean aquatico;

	public Mamifero() {
		super();
	}

	public Mamifero(String nombre, String alimentacion, int diasGestacion, boolean aquatico) {
		super(nombre);
		this.alimentacion = alimentacion;
		this.diasGestacion = diasGestacion;
		this.aquatico = aquatico;
	}

	public String getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}

	public int getDiasGestacion() {
		return diasGestacion;
	}

	public void setDiasGestacion(int diasGestacion) {
		this.diasGestacion = diasGestacion;
	}

	public boolean isAquatico() {
		return aquatico;
	}

	public void setAquatico(boolean aquatico) {
		this.aquatico = aquatico;
	}

	@Override
	public String getFamilyType() {
		return "Mamifero";
	}

	@Override
	public String getFoodType() {
		return this.alimentacion;
	}

}

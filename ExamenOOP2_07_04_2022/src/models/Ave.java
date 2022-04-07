package models;

public class Ave extends Animal {

	private String alimentacion;
	private int diasIncubacion;
	private boolean vuela;

	public Ave() {
		super();
	}

	public Ave(String nombre, String alimentacion, int diasIncubacion, boolean vuela) {
		super(nombre);
		this.alimentacion = alimentacion;
		this.diasIncubacion = diasIncubacion;
		this.vuela = vuela;
	}

	public String getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}

	public int getDiasIncubacion() {
		return diasIncubacion;
	}

	public void setDiasIncubacion(int diasIncubacion) {
		this.diasIncubacion = diasIncubacion;
	}

	public boolean isVuela() {
		return vuela;
	}

	public void setVuela(boolean vuela) {
		this.vuela = vuela;
	}

	@Override
	public String getFamilyType() {
		return "Ave";
	}

	@Override
	public String getFoodType() {
		return this.alimentacion;
	}

}

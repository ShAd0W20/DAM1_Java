package models;

public abstract class Animal {
	private String nombre;

	public Animal() {
		super();
	}
	
	public Animal(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract String getFamilyType();
	
	public abstract String getFoodType();
}

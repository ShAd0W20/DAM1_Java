package models;

public class Persona {
	public static final int MAX_PERSONAS = 10;

	private static int totalPersonas;

	private String nombre;
	private String DNI;
	
	public Persona(String nombre, String DNI) {
		this.nombre = nombre;
		this.DNI = DNI;
		totalPersonas++;
	}

	public static void setTotalPersonas(int totalPersonas) {
		totalPersonas += totalPersonas;
	}

	public static int getTotalPersonas() {
		return totalPersonas;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return this.DNI;
	}

	public void setDNI(String dNI) {
		this.DNI = dNI;
	}

}

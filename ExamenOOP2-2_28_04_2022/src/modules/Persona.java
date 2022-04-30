package modules;

public class Persona {
	private String DNI;
	private String name;

	public Persona(String dNI, String name) {
		super();
		DNI = dNI;
		this.name = name;
	}

	public String getDNI() {
		return DNI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

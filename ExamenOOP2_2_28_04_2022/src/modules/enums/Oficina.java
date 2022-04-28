package modules.enums;

public enum Oficina {
	GERONA("Gerona", "Pepe"), BARCELONA("Barcela", "Maria"), TARRAGONA("Tarragona", "Irene"), LLEIDA("Lleida", "Jose");

	private String location, director;

	Oficina(String location, String director) {
		this.location = location;
		this.director = director;
	}

	public String getLocation() {
		return this.location;
	}
	
	public String getDirector() {
		return this.director;
	}
	
}

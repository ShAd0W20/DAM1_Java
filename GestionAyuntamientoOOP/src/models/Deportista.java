package models;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Deportista extends Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6018090535501481701L;
	private String id;
	private String sportType;

	public Deportista(String DNI, String name, LocalDate birthDay, String id, String sportType) {
		super(DNI, name, birthDay);
		this.id = id;
		this.sportType = sportType;
	}

	public String getId() {
		return id;
	}

	public String getSportType() {
		return sportType;
	}

	@Override
	public String toString() {
		return "[+] DNI: " + this.getDNI() + " [+] Nombre: " + this.getName() + " [+] Fecha nacimiento: " + this.getBirthDay() + " [+] Codigo: " + this.id + " [+] Deporte: " + this.sportType;
	}
}

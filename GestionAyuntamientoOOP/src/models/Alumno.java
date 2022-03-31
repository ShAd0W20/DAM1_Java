package models;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Alumno extends Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -715399717150996451L;
	private String studentID;
	private String studiesType;

	public Alumno(String DNI, String name, LocalDate birthDay, String studentID, String studiesType) {
		super(DNI, name, birthDay);
		this.studentID = studentID;
		this.studiesType = studiesType;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getStudiesType() {
		return studiesType;
	}

	@Override
	public String toString() {
		return "[+] DNI: " + this.getDNI() + " [+] Nombre: " + this.getName() + " [+] Fecha nacimiento: " + this.getBirthDay() + " [+] Codigo alumno: " + this.studentID + " [+] Estudios: " + this.studiesType;
	}
	
}

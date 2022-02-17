package models;

import java.time.LocalDate;

public class Alumno {

	private String dni;
	private String name;
	private LocalDate birthDate;
	private int gradeID;
	
	
	public void __construct(String dni, String name, LocalDate birthDate, int gradeID) {
		this.dni = dni;
		this.name = name;
		this.birthDate = birthDate;
		this.gradeID = gradeID;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public int getGradeID() {
		return gradeID;
	}
	
	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}
}

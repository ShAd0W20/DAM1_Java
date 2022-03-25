package models;

import java.time.LocalDate;

public class Alumno extends Persona {
	private String studentStudies;
	private int studentGrade;
	private static int totalStudents;

	public Alumno(String name, LocalDate birthDay, String dni, String studentStudies, int studentGrade) {
		super(name, birthDay, dni);
		this.studentStudies = studentStudies;
		this.studentGrade = studentGrade;
		totalStudents++;
	}

	public String getStudentStudies() {
		return studentStudies;
	}

	public void setStudentStudies(String studentStudies) {
		this.studentStudies = studentStudies;
	}

	public int getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(int studentGrade) {
		this.studentGrade = studentGrade;
	}
	
	@Override
	public String toString() {
		return "\nAlumno \n[Nombre] : " + this.getName() + " \n[Fecha nacimiento] : " + this.getBirthDate() + " \n[Studies] : " + this.studentStudies;
	}

	public static int getTotalStudents() {
		return totalStudents;
	}
}

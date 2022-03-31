package models;

import java.io.Serializable;
import java.time.LocalDate;

public class CF extends Alumno implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 751760072546737549L;
	private String institute;
	private String nameCF;
	private int firstGrade;
	private int secondGrade;

	public CF(String DNI, String name, LocalDate birthDay, String studentID, String studiesType, String institute,
			String nameCF, int firstGrade, int secondGrade) {
		super(DNI, name, birthDay, studentID, studiesType);
		this.institute = institute;
		this.nameCF = nameCF;
		this.firstGrade = firstGrade;
		this.secondGrade = secondGrade;
	}

	public String getInstitute() {
		return institute;
	}

	public String getNameCF() {
		return nameCF;
	}

	public int getFirstGrade() {
		return firstGrade;
	}

	public int getSecondGrade() {
		return secondGrade;
	}
	
	@Override
	public String toString() {
		return "[+] DNI: " + this.getDNI() + " [+] Nombre: " + this.getName() + " [+] Fecha nacimiento: " + this.getBirthDay() + " [+] Codigo alumno: " + this.getStudentID() + " [+] Estudios: " + this.getStudiesType() + " [+] Instituto: " + this.institute + " [+] Nota primero: " + this.firstGrade + " [+] Nota segundo: " + this.secondGrade;
	}

}

package models;

import java.io.Serializable;
import java.time.LocalDate;

public class ESO extends Alumno implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -442903491067394025L;
	private String institute;
	private int firstGrade;
	private int secondGrade;
	private int thirdGrade;
	private int fourthGrade;

	public ESO(String DNI, String name, LocalDate birthDay, String studentID, String studiesType, String institute,
			int firstGrade, int secondGrade, int thirdGrade, int fourthGrade) {
		super(DNI, name, birthDay, studentID, studiesType);
		this.institute = institute;
		this.firstGrade = firstGrade;
		this.secondGrade = secondGrade;
		this.thirdGrade = thirdGrade;
		this.fourthGrade = fourthGrade;
	}

	public String getInstitute() {
		return institute;
	}

	public int getFirstGrade() {
		return firstGrade;
	}

	public int getSecondGrade() {
		return secondGrade;
	}

	public int getThirdGrade() {
		return thirdGrade;
	}

	public int getFourthGrade() {
		return fourthGrade;
	}

	@Override
	public String toString() {
		return "[+] DNI: " + this.getDNI() + " [+] Nombre: " + this.getName() + " [+] Fecha nacimiento: " + this.getBirthDay() + " [+] Codigo alumno: " + this.getStudentID() + " [+] Estudios: " + this.getStudiesType() + " [+] Instituto: " + this.institute + " [+] Nota primero: " + this.firstGrade + " [+] Nota segundo: " + this.secondGrade + " [+] Nota tercero: " + this.thirdGrade + " [+] Nota cuarto: " + this.fourthGrade;
	}
	
}

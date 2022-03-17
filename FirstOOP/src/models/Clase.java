package models;

import java.util.ArrayList;

public class Clase {
	private ArrayList<Alumno> alumnos;
	private String nombreClase;
	
	private static int totalAlumnos;
	
	public Clase(String nombreClase) {
		this.nombreClase = nombreClase;
		alumnos = new ArrayList<Alumno>();
	}

	public String getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
		Clase.totalAlumnos = alumnos.size();
	}	

	public void removeAlumno(int alumno) {
		this.alumnos.remove(alumno);
		Clase.totalAlumnos = alumnos.size();
	}

	public static int getTotalAlumnos() {
		return totalAlumnos;
	}
	
}

package models.enums;

public enum ModulesDAM {
	PROGRAMACION("Programacion", "DAM1", 50), DB("Bases de datos", "DAM1", 60), SISTEMAS("Sistemas Operativos", "DAM1", 80);
	
	private String nombre, curso;
	private int horas;
	
	ModulesDAM(String nombre, String curso, int horas) {
		this.nombre = nombre;
		this.curso = curso;
		this.horas = horas;
	}
	
	public String getModuleName() {
		return this.nombre;
	}
	
	public String getModuleCurso() {
		return this.curso;
	}
	
	public int getModuleHoras() {
		return this.horas;
	}
	
}

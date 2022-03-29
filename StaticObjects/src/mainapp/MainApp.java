package mainapp;

import models.Persona;

public class MainApp {
	public static void main(String[] args) {
		
		Persona p = new Persona("Pepe", "39842398E");
		Persona i = new Persona("Irene", "53369108I");
		
		System.out.println(p.getNombre() + " " + p.getDNI());
		System.out.println(i.getNombre() + " " + i.getDNI());
		
		System.out.println(Persona.getTotalPersonas());
	}
}

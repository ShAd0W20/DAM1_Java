package mainapp;

import models.Equipo;
import models.Impresora;
import models.Portatil;

public class MainApp {

	public static void main(String[] args) {
		//Equipo e = new Equipo(); Can not be instantiated because of it's an abstract class
		
		Portatil p = new Portatil();
		p.setCodigo(23);
		p.setNombre("AORUS");
		p.setDisco("512tb");
		
		Impresora i = new Impresora();
		i.setCodigo(32);
		i.setNombre("HP");
		i.setTipo("Laser");
		
		Equipo e = p; // Can not be instantiated but can be equaled to a child class (But we lose information from the child class)
		Equipo e2 = i;
		
		System.out.println(p.getCodigo() + " " + p.getNombre() + " " + p.getDisco());
		System.out.println(i.getCodigo() + " " + i.getNombre() + " " + i.getTipo());
		System.out.println(e.getCodigo() + " " + e.getNombre());
		System.out.println(e2.getCodigo() + " " + e2.getNombre());
	}

}

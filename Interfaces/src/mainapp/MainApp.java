package mainapp;

import java.time.LocalDate;
import java.util.ArrayList;

import models.Corredor;
import models.Correr;
import models.Triatleta;

public class MainApp {

	public static void main(String[] args) {
		
		ArrayList<Correr> corredores = new ArrayList<>();
		
		Corredor c = new Corredor("123ABC", "Pepe", LocalDate.now(), "Nike");
		Corredor c1 = new Corredor("123ABC", "Pepe", LocalDate.now(), "Puma");
		Triatleta t = new Triatleta("123ABC", "Pepe", LocalDate.now(), "Marca Bici", "Nike", "Neopreno");
		
		corredores.add(c);
		corredores.add(c1);
		
		System.out.println(t.toString());
		
		for(Correr co : corredores) {
			System.out.println(co.getMarcaBambas());
		}
		
	}

}

package mainapp;

import models.Ave;
import models.Mamifero;
import models.Zoo;

public class MainApp {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		Mamifero mamifero1 = new Mamifero("Mamifero1", "Comida", 10, false);
		Ave ave1 = new Ave("Ave1", "Gusanos", 3, true);
		
		Mamifero mamifero2 = new Mamifero();		
		mamifero2.setName("Mamifero2");
		mamifero2.setAlimentacion("Carne");
		mamifero2.setDiasGestacion(90);
		mamifero2.setAquatico(true);
		
		Ave ave2 = new Ave();
		ave2.setName("Ave2");
		ave2.setAlimentacion("Pipas");
		ave2.setDiasIncubacion(20);
		ave2.setVuela(false);
		
		System.out.println(mamifero1.getName() + " " + mamifero1.getAlimentacion() + " " + mamifero1.getDiasGestacion() + " " + mamifero1.isAquatico());
		System.out.println(mamifero2.getName() + " " + mamifero2.getAlimentacion() + " " + mamifero2.getDiasGestacion() + " " + mamifero2.isAquatico());
		System.out.println(ave1.getName() + " " + ave1.getAlimentacion() + " " + ave1.getDiasIncubacion() + " " + ave1.isVuela());
		System.out.println(ave2.getName() + " " + ave2.getAlimentacion() + " " + ave2.getDiasIncubacion() + " " + ave2.isVuela());
		
		zoo.addAnimal(mamifero1);
		zoo.addAnimal(mamifero2);
		zoo.addAnimal(ave1);
		zoo.addAnimal(ave2);
		
		System.out.println("\n\nTOTAL ANIMALES: " + Zoo.totalAnimalsInZoo() + "\n");
		System.out.println("Listado de animales: \n" + zoo.listAllAnimals());
		System.out.println("Listado mamiferos: \n" + zoo.listAllAnimals("Mamifero"));
		System.out.println("\n\nListado ordenado: ");
		System.out.println(zoo.listAnimalsByFamily());
	}
}

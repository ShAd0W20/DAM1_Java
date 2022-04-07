package models;

import java.util.ArrayList;

public class Zoo {
	private static int totalAnimals;
	private ArrayList<Animal> animals;

	public Zoo() {
		super();
		animals = new ArrayList<>();
	}

	public void addAnimal(Animal a) {
		this.animals.add(a);
		totalAnimals++;
	}

	public String listAllAnimals() {

		String stringToReturn = "";

		for (Animal a : this.animals) {
			stringToReturn += String.format("%-10s %-10s %-10s %n", a.getName(), a.getFamilyType(), a.getFoodType());
		}

		return stringToReturn;
	}

	public String listAllAnimals(String family) {

		String stringToReturn = "";

		for (Animal a : this.animals) {
			if(a.getFamilyType().equals(family)) {
				stringToReturn += String.format("%-10s %-10s %n", a.getName(), a.getFoodType());
			}
		}

		return stringToReturn;
	}
	
	public String listAnimalsByFamily() {
		ArrayList<String> family = new ArrayList<>();
		String stringToReturn = "";
		for (Animal a : this.animals) {
			if(!family.contains(a.getFamilyType())) {
				family.add(a.getFamilyType());
			}
		}
		
		for (String f : family) {
			stringToReturn += String.format("%n%-10s %-10s  %-10s%n", "Nombre", "Tipo animal", "Alimnetacion");
			stringToReturn += String.format("\t%s %n", f);
			for (Animal a : this.animals) {
				if(a.getFamilyType().equals(f)) {
					stringToReturn += String.format("%-10s %-10s %-10s %n", a.getName(), a.getFamilyType(), a.getFoodType());
				}
			}
		}
		
		return stringToReturn;
	}
	
	public static int totalAnimalsInZoo() {
		return totalAnimals;
	}

}

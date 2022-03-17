package mainapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import models.Alumno;

public class MainApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name;
		LocalDate date;
		
		for(int i = 0; i < 2; i++) {
			System.out.println("Introduce el nombre del alumno");
			name = input.nextLine();
			
			System.out.println("Introduce la fecha de nacimiento");
			date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));
			
			Alumno a = new Alumno(name, date);
			
			System.out.println(a.getNombre());
			System.out.println(a.getFechaNacimiento());
		}
		
		input.close();
	}

}

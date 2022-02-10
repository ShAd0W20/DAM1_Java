package mainapp;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import models.*;

public class MainApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<RegistreAlumne> alumnes = new ArrayList<RegistreAlumne>();
		RegistreCicle[] registreCicles = new RegistreCicle[3];
		
		RegistreCicle cicle1 = new RegistreCicle();
		cicle1.codiCicle = 1;
		cicle1.nomCicle = "DAM";
		registreCicles[0] = cicle1;
		
		RegistreCicle cicle2 = new RegistreCicle();
		cicle2.codiCicle = 2;
		cicle2.nomCicle = "DAW";
		registreCicles[1] = cicle2;
		
		RegistreCicle cicle3 = new RegistreCicle();
		cicle3.codiCicle = 3;
		cicle3.nomCicle = "SMX";
		registreCicles[2] = cicle3;
		
		
		String mainMenuOption = "";
		
		
		matricularAlumne("44885567E", "Pepe", LocalDate.of(2002, 1, 3), "DAM", alumnes, registreCicles);
		matricularAlumne("33445566L", "Maria", LocalDate.of(2002, 4, 19), "DAW", alumnes, registreCicles);
		matricularAlumne("11223344G", "Irene", LocalDate.of(2000, 1, 15), "DAM", alumnes, registreCicles);
		matricularAlumne("22334455H", "Laura", LocalDate.of(1999, 1, 26), "SMX", alumnes, registreCicles);
		matricularAlumne("66778899J", "Jordi", LocalDate.of(1965, 6, 23), "DAM", alumnes, registreCicles);
		
		System.out.println("Que desea hacer? \n[1] Matricula alumno \n[2] Baixa alumne \n[3] Llistat alumnes per curs \n[4] Llistat alumnes per edat \n[Salir] para salir");
		do {
			mainMenuOption = input.nextLine();
			
			switch(mainMenuOption) {
			case "1":
				String dni = "";
				String name = "";
				String grade = "";
				System.out.println("Dni alumno");
				dni = input.nextLine();
				
				System.out.println("Nombre alumno");
				name = input.nextLine();
				
				System.out.println("Fecha nacimiento alumno");
				LocalDate ok = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));
				
				System.out.println("Grado alumno");
				grade = input.nextLine();
				matricularAlumne(dni, name, ok, grade, alumnes, registreCicles);
				break;
			case "2":
				String dniToDelete = "";
				System.out.println("Dni a eliminar");
				dniToDelete = input.nextLine();
				baixaAlumne(dniToDelete, alumnes);
				break;
			case "3":
				String gradeToSearch = "";
				gradeToSearch = input.nextLine();
				alumnesAgrupatsPerCurs(gradeToSearch, alumnes, registreCicles);
				break;
			case "4":
				llistarAlumnesOrdenatsPerEdat(alumnes, registreCicles);
				break;
			default: 
				if(!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.println("Que desea hacer? \n[1] Matricula alumno \n[2] Baixa alumne \n[3] Llistat alumnes per curs \n[4] Llistat alumnes per edat \n[Salir] para salir");					
				}
			}
		} while(!mainMenuOption.equalsIgnoreCase("salir"));
		
		input.close();
		System.out.println("[-] Has salido del programa");
	}
	
	public static void matricularAlumne(String dni, String nom, LocalDate dataNaixement, String cicle, ArrayList<RegistreAlumne> alumnes, RegistreCicle[] cicles) {
		if(!existeixAlumne(dni, alumnes) && existeixCicle(cicle, cicles)) {
			RegistreAlumne alumne = new RegistreAlumne();
			alumne.dni = dni;
			alumne.nom = nom;
			alumne.dataNaixement = dataNaixement;
			for(int i = 0; i < cicles.length; i++) {
				if(cicles[i].nomCicle.equalsIgnoreCase(cicle)) {
					alumne.codiCicle = cicles[i].codiCicle;
				}
			}
			
			alumnes.add(alumne);
			
			System.out.println(dadesAlumne(dni, alumnes));
			
			System.out.println("Enter per torar al menu");
		}
	}
	
	public static boolean existeixAlumne(String dni, ArrayList<RegistreAlumne> alumnes) {
		int i = 0;
		if(!alumnes.isEmpty()) {
			while(i < alumnes.size() - 1 && !alumnes.get(i).dni.equalsIgnoreCase(dni)) {
				i++;
			}
			if(alumnes.get(i).dni.equalsIgnoreCase(dni)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean existeixCicle(String nomCicle, RegistreCicle[] cicles) {
		int i = 0;
		while(!nomCicle.equalsIgnoreCase(cicles[i].nomCicle) && i < cicles.length) {
			i++;
		}
		if(!nomCicle.equalsIgnoreCase(cicles[i].nomCicle)) {
			return false;
		}
		return true;
	}
	
	public static String dadesAlumne(String dni, ArrayList<RegistreAlumne> alumnes) {
		String json = "";
		int i = 0;
		while(!dni.equalsIgnoreCase(alumnes.get(i).dni) && i < alumnes.size() - 1) {
			i++;
		}
		if(dni.equalsIgnoreCase(alumnes.get(i).dni)) {
			json += alumnes.get(i).dni + " " + alumnes.get(i).nom + " " + alumnes.get(i).dataNaixement.toString();
		}
		
		return json;
	}
	
	public static void baixaAlumne(String dni, ArrayList<RegistreAlumne> alumnes) {
		if(!existeixAlumne(dni, alumnes)) {
			System.out.println("Alumne no existent");
			return;
		}
		
		System.out.println(dadesAlumne(dni, alumnes));
		
		desmatricularAlumne(dni, alumnes);
		
		System.out.println("Alumne borrat.");
	}
	
	public static void desmatricularAlumne(String dni, ArrayList<RegistreAlumne> alumnes) {
		int i = 0;
		while(!dni.equalsIgnoreCase(alumnes.get(i).dni) && i < alumnes.size()) {
			i++;
		}
		if(dni.equalsIgnoreCase(alumnes.get(i).dni)) {
			alumnes.remove(i);
		}
	}
	
	
	public static void alumnesAgrupatsPerCurs(String nomCicle, ArrayList<RegistreAlumne> alumnes, RegistreCicle[] cicles) {
		System.out.println(llistarAlumnes(alumnesCicle(nomCicle, alumnes, cicles)));
	}
	
	public static ArrayList<RegistreAlumne> alumnesCicle(String nomCicle, ArrayList<RegistreAlumne> alumnes, RegistreCicle[] cicles) {
		int i = 0;
		ArrayList<RegistreAlumne> studentsInSameGrade = new ArrayList<RegistreAlumne>();
		
		while(!nomCicle.equalsIgnoreCase(cicles[i].nomCicle) && i < cicles.length) {
			i++;
		}
		
		if(nomCicle.equalsIgnoreCase(cicles[i].nomCicle)) {
			for(int j = 0; j < alumnes.size(); j++) {
				if(alumnes.get(j).codiCicle == (i + 1)) {
					RegistreAlumne student = new RegistreAlumne();
					student.dni = alumnes.get(j).dni;
					student.nom = alumnes.get(j).nom;
					student.dataNaixement = alumnes.get(j).dataNaixement;
					student.codiCicle = alumnes.get(j).codiCicle;
					studentsInSameGrade.add(student);
				}
			}
		}
		
		return studentsInSameGrade;
		
	}
	
	public static String llistarAlumnes(ArrayList<RegistreAlumne> alumnes) {
		String json = "";
		for(RegistreAlumne a: alumnes) {
			json += "\n" + dadesAlumne(a.dni, alumnes);
		}
		
		return json;
	}
	
	public static void llistarAlumnesOrdenatsPerEdat(ArrayList<RegistreAlumne> alumnes, RegistreCicle[] cicles) {
		ArrayList<RegistreAlumne> students = new ArrayList<RegistreAlumne>();
		
		for(int i = 0; i < alumnes.size(); i++) {
			RegistreAlumne auxAlumne = new RegistreAlumne();
			auxAlumne.dni = alumnes.get(i).dni;
			auxAlumne.nom = alumnes.get(i).nom;
			auxAlumne.dataNaixement = alumnes.get(i).dataNaixement;
			auxAlumne.codiCicle = alumnes.get(i).codiCicle;
			students.add(auxAlumne);
		}
		
		students.sort((o1, o2) -> o1.dataNaixement.compareTo(o2.dataNaixement));
		
		for(RegistreAlumne a: students) {
			System.out.println(nomCicle(a.codiCicle, cicles) + " " + majorEdat(a.dataNaixement) + " " + a.nom);
		}
	}
	
	public static String nomCicle(int codiCicle, RegistreCicle[] cicles) {
		int i = 0;
		while(codiCicle != cicles[i].codiCicle && i < cicles.length) {
			i++;
		}
		
		if(codiCicle == cicles[i].codiCicle) {
			return cicles[i].nomCicle;
		}
		return "";
	}
	
	public static boolean majorEdat(LocalDate dataNaixement) {
		Period periodo = Period.between(dataNaixement, LocalDate.now());
		if(periodo.getYears() >= 18) {
			return true;
		}
		return false;
	}

}

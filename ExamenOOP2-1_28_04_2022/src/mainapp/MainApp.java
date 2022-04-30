package mainapp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import models.Agenda;
import models.Cumpleaños;
import models.DiaFestivo;
import models.EntregaPractica;
import models.Examen;
import models.enums.ModulesDAM;

public class MainApp {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		String mainMenuOpt = "";
		System.out.println("Que desea hacer? \n[1] Añadir evento \n[2] Ver ventos dia \n[3] Ver agenda \n[Salir] para salir");

		do {
			mainMenuOpt = input.nextLine();

			switch (mainMenuOpt) {
			case "1":
				addEvent(agenda);
				break;
			case "2":
				viewDayEvent(agenda);
				System.out.println("\n\n[+] Pulse enter para volver al menu\n");
				break;
			case "3":
				viewEvent(agenda);
				System.out.println("\n\n[+] Pulse enter para volver al menu\n");
				break;
			default:
				if(!mainMenuOpt.equalsIgnoreCase("salir")) {
					System.out.println("Que desea hacer? \n[1] Añadir evento \n[2] Ver ventos dia \n[3] Ver agenda \n[Salir] para salir");
				}
			}
		} while (!mainMenuOpt.equalsIgnoreCase("salir"));

		input.close();
		System.out.println("\n\n[+] Saliendo... \n");
	}

	private static void addEvent(Agenda agenda) {
		System.out.println("Que tipo de evento desea registrar? \n[1] Cumpleaños \n[2] Dia fesitvo \n[3] Examen \n[4] Entrega practica");
		String subMenuOption = input.nextLine();

		switch (subMenuOption) {
		case "1":
			registerBirthDay(agenda);
			System.out.println("\n\n[+] Pulse enter para volver al menu\n");
			break;
		case "2":
			registerFestive(agenda);
			System.out.println("\n\n[+] Pulse enter para volver al menu\n");
			break;
		case "3":
			registerExam(agenda);
			System.out.println("\n\n[+] Pulse enter para volver al menu\n");
			break;
		case "4":
			registarPractica(agenda);
			System.out.println("\n\n[+] Pulse enter para volver al menu\n");
			break;
		}
	}
	
	private static void viewDayEvent(Agenda agenda) {
		LocalDate date = null;
		
		System.out.println("Introduce la fecha que quiere visualizar:");
		date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));
		
		System.out.println(agenda.getEventosDia(date));
	}
	
	private static void viewEvent(Agenda agenda) {
		System.out.println(agenda.getEventos());
	}
	
	private static void registerBirthDay(Agenda agenda) {
		LocalDate date = null;
		String name = "";
		LocalDate birthDate = null;
		
		System.out.println("Que dia es el cumple?");
		date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));
		
		System.out.println("Como se llama la persona?");
		name = input.nextLine();

		System.out.println("Que dia nacio?");
		birthDate = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));
		
		Cumpleaños c = new Cumpleaños(date, name, birthDate);
		agenda.addEvento(c);
	}
	
	private static void registerFestive(Agenda agenda) {
		LocalDate date = null;
		String name = "";
		
		System.out.println("Que dia es el festivo?");
		date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));
		
		System.out.println("Como se el festivo?");
		name = input.nextLine();
		
		DiaFestivo df = new DiaFestivo(date, name);
		agenda.addEvento(df);
	}
	
	private static void registerExam(Agenda agenda) {
		LocalDate date = null;
		ModulesDAM modulo = null;
		LocalTime startExam = null;
		LocalTime endExam = null;
		
		
		System.out.println("Que dia es el examen?");
		date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));
		
		System.out.println("Que hora empieza es el examen?");
		startExam = LocalTime.parse(input.nextLine());
		
		System.out.println("Que hora acaba el examen?");
		endExam = LocalTime.parse(input.nextLine());
		
		for(ModulesDAM m : ModulesDAM.values()) {
			System.out.println(m.getModuleName());
		}
		
		System.out.println("Introduce el nombre del modulo exacto");
		String moduleName = input.nextLine();
		
		modulo = getModuleByName(moduleName);
		
		Examen e = new Examen(date, modulo, startExam, endExam);
		
		agenda.addEvento(e);
	}
	
	private static void registarPractica(Agenda agenda) {
		LocalDate date = null;
		ModulesDAM modulo = null;
		LocalTime endExam = null;
		
		
		System.out.println("Que dia es el examen?");
		date = LocalDate.parse(input.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));
		
		System.out.println("Que dia es el cumple?");
		endExam = LocalTime.parse(input.nextLine(), DateTimeFormatter.ofPattern("h:m:s"));
		
		for(ModulesDAM m : ModulesDAM.values()) {
			System.out.println(m.getModuleName());
		}
		
		System.out.println("Introduce el nombre del modulo exacto");
		String moduleName = input.nextLine();
		
		modulo = getModuleByName(moduleName);
		
		EntregaPractica ep = new EntregaPractica(date, modulo, endExam);
		
		agenda.addEvento(ep);
	}
	
	private static ModulesDAM getModuleByName(String name) {
		switch(name) {
		case "Programacion":
			return ModulesDAM.PROGRAMACION;
		case "Bases de datos":
			return ModulesDAM.DB;
		case "Sistemas Operativos":
			return ModulesDAM.SISTEMAS;
		}
		return null;
	}
}

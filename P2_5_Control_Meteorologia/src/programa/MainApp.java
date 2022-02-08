package programa;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import biblioteca.meteorologia.Pluja;
import biblioteca.meteorologia.Temperatura;
import biblioteca.meteorologia.Vent;

public class MainApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DiaMeteo[] dias = new DiaMeteo[365];
		Random rnd = new Random();
		String mainMenuOption = "";
		String subMenuOption = "";
		String monthToSearch = "";

		for (int i = 0; i < dias.length; i++) {
			DiaMeteo dia = new DiaMeteo();

			dia.tempMax = rnd.nextInt((30 - 10)) + 10;
			dia.tempMin = rnd.nextInt(15) - 5;
			dia.pluja = rnd.nextInt(100);
			dia.ventMax = rnd.nextInt(80);
			dia.dia = LocalDate.of(2021, (rnd.nextInt(12) + 1), (rnd.nextInt(28) + 1));

			dias[i] = dia;
		}
		
		System.out.println("Que desea hacer? \n[1] Pluja \n[2] Temperatura \n[3] Vent \n[Salir] para salir");
		
		do {
			mainMenuOption = input.nextLine();
			
			switch (mainMenuOption) {
			case "1":
				System.out.println("Que desea hacer? \n[1] Mitjana mensual pluja \n[2] Mitjana anual pluja \n[3] Dies mes pluja mensual \n[4] Dies mes pluja anual");
				subMenuOption = input.nextLine();
				switch (subMenuOption) {
				case "1":
					System.out.println("Introduce el mes que desea buscar");
					monthToSearch = input.nextLine();
					System.out.println("\nMitjana mensual");
					System.out.println(Pluja.mitjanaMensualPluja(monthToSearch, dias));
					break;
				case "2":
					System.out.println("\nMitjana anual");
					System.out.println(Pluja.mitjanaAnualPluja(dias));
					break;
				case "3":
					System.out.println("Introduce el mes que desea buscar");
					monthToSearch = input.nextLine();
					System.out.println("\nDies mes pluja mensual");
					for(DiaMeteo d: Pluja.diesMesPlujaMensual(monthToSearch, dias)) {
						System.out.println("[+] " + d.dia.toString());
					}
					break;
				case "4":
					System.out.println("\nDies mes pluja anual");
					for(DiaMeteo d: Pluja.diasMesPlujaAnual(dias)) {
						System.out.println("[+] " + d.dia.toString());
					}
					break;
				}
				break;
			case "2":
				System.out.println("Que desea hacer? \n[1] Dies mes amplitud mensual \n[2] Dies mes amplitud anual \n[3] Dies mes calor mensual \n[4] Dies mes calor anual \n[5] Dies mes fred mensual \n[6] Dies mes fred anual");
				subMenuOption = input.nextLine();
				switch (subMenuOption) {
				case "1":
					System.out.println("Introduce el mes que desea buscar");
					monthToSearch = input.nextLine();
					System.out.println("\nDies mes amplitud mensual");
					for(DiaMeteo d: Temperatura.diesMesAmplitudMensual(monthToSearch, dias)) {
						System.out.println("[+] " + d.dia.toString());					
					}
					break;
				case "2":
					System.out.println("\nDies mes amplitud anual");
					for(DiaMeteo d: Temperatura.diesMesAmplitudAnual(dias)) {
						System.out.println("[+] " + d.dia.toString());					
					}
					break;
				case "3":
					System.out.println("Introduce el mes que desea buscar");
					monthToSearch = input.nextLine();
					System.out.println("\nDies mes calor mensual");
					for(DiaMeteo d: Temperatura.diesMesCalorMensual(monthToSearch, dias)) {
						System.out.println("[+] " + d.dia.toString());					
					}
					break;
				case "4":
					System.out.println("\nDies mes calor anual");
					for(DiaMeteo d: Temperatura.diesMesCalorAnual(dias)) {
						System.out.println("[+] " + d.dia.toString());					
					}
					break;
				case "5":
					System.out.println("Introduce el mes que desea buscar");
					monthToSearch = input.nextLine();
					System.out.println("\nDies mes fred mensual");
					for(DiaMeteo d: Temperatura.diesMesFredMensual(monthToSearch, dias)) {
						System.out.println("[+] " + d.dia.toString());					
					}
					break;
				case "6":
					System.out.println("\nDies mes fred anual");
					for(DiaMeteo d: Temperatura.diesMesFredAnual(dias)) {
						System.out.println("[+] " + d.dia.toString());					
					}
					break;
				}
				break;
			case "3":
				System.out.println("Que desea hacer? \n[1] Dies poc vent mensual \n[2] Dies poc vent anual \n[3] Nombre dies poc vent mensual \n[4] Nombre dies poc vent anual");
				subMenuOption = input.nextLine();
				switch (subMenuOption) {
				case "1":
					System.out.println("Introduce el mes que desea buscar");
					monthToSearch = input.nextLine();
					System.out.println("\nDies poc vent mensual");
					for(DiaMeteo d: Vent.diesPocVentMensual(monthToSearch, dias)) {
						System.out.println("[+] " + d.dia.toString());					
					}
					break;
				case "2":
					System.out.println("\nDies poc vent anual");
					for(DiaMeteo d: Vent.diesPocVentAnual(dias)) {
						System.out.println("[+] " + d.dia.toString());					
					}
					break;
				case "3":
					System.out.println("Introduce el mes que desea buscar");
					monthToSearch = input.nextLine();
					System.out.println("\nNombre dies poc vent mensual");
					System.out.println(Vent.nombreDiesPocVentMensual(monthToSearch, dias));
					break;
				case "4":
					System.out.println("\nNombre dies poc vent anual");
					System.out.println(Vent.nombreDiesPocVentAnual(dias));
					break;
				}
				break;
			default:
				if(!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.println("Que desea hacer? \n[1] Pluja \n[2] Temperatura \n[3] Vent \n[Salir] para salir");
				}
			}
		} while(!mainMenuOption.equalsIgnoreCase("salir"));

		System.out.println("\n[-] Has salido del programa");
		input.close();
	}

}

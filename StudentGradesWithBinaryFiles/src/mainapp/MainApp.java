package mainapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import views.DisplayResults;
import views.Recuperation;
import views.RegisterDeleteStudent;
import views.RegisterFirstGrades;
import views.RegisterSecondGrades;
import views.RegisterThirdGrades;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner input = new Scanner(System.in);
		String mainMenuOption = "";
		System.out.printf("Que desea hacer? %n[1] Registrar/Eliminar usuario %n[2] Registrar notas primer trimestre %n[3] Registrar notas segundo trimestre %n[4] Registrar notas tecer trimestre %n[5] Mostrar notas entradas %n[6] Recuperaciones %n[Salir] para salir %n");
		
		do {
			mainMenuOption = input.nextLine();
			switch (mainMenuOption) {
			case "1":
				RegisterDeleteStudent.main();
				break;
			case "2":
				RegisterFirstGrades.main();
				break;
			case "3":
				RegisterSecondGrades.main();
				break;
			case "4":
				RegisterThirdGrades.main();
				break;
			case "5":
				DisplayResults.main();
				break;
			case "6":
				Recuperation.main();
				break;
			default:
				if (!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.printf("Que desea hacer? %n[1] Registrar/Eliminar usuario %n[2] Registrar notas primer trimestre %n[3] Registrar notas segundo trimestre %n[4] Registrar notas tecer trimestre %n[5] Mostrar notas entradas %n[6] Recuperaciones %n[Salir] para salir %n");
				}
			}
		} while (!mainMenuOption.equalsIgnoreCase("salir"));
		input.close();
		
		System.out.printf("%n%n[!] Saliendo... %n");
	}

}

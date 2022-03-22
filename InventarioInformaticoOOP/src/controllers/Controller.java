package controllers;

import models.Inventario;
import utils.ConsoleHelper;
import views.Delete;
import views.Register;

public class Controller {
	static Inventario inventario = new Inventario("", "");
	
	public void run() {
		mainMenu();
	}
	
	private void mainMenu() {
		int opt;
		do {
			ConsoleHelper.printMainMenu();
			opt = ConsoleHelper.choseMenuOption(0, 4);
			switch (opt) {
			case 1:
				ConsoleHelper.printRegisterMenu();
				int registerOpt = ConsoleHelper.choseOption(0, 4);
				switch (registerOpt) {
				case 1:
					Register.RegisterNewLapTop(inventario);
					break;
				case 2:
					Register.RegisterNewComputer(inventario);
					break;
				case 3:
					Register.RegisterNewProjector(inventario);
					break;
				case 4:
					Register.RegisterNewPrinter(inventario);
					break;
				case 0:
					break;
				}
				break;
			case 2:
				ConsoleHelper.printEditMenu();
				int editOpt = ConsoleHelper.choseOption(0, 4);
				switch (editOpt) {
				case 1:
					
					break;
				case 0:
					break;
				}
				break;
			case 3:
				ConsoleHelper.printListMenu();
				int listOpt = ConsoleHelper.choseOption(0, 4);
				switch (listOpt) {
				case 1:
					
					break;
				case 0:
					break;
				}
				break;
			case 4:
				ConsoleHelper.printDeleteMenu();
				int deleteOpt = ConsoleHelper.choseOption(0, 4);
				switch (deleteOpt) {
				case 1:
					Delete.deleteLapTop(inventario);
					break;
				case 2:
					Delete.deleteComputer(inventario);
					break;
				case 3:
					Delete.deleteProjector(inventario);
					break;
				case 4:
					Delete.deletePrinter(inventario);
					break;
				case 0:
					break;
				}
				break;

			}
		} while (opt != 0);

		System.out.printf("%n%n[!] Saliendo... %n");
	}
	
}

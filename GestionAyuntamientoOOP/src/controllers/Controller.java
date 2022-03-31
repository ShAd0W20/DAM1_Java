package controllers;

import models.Ayuntamiento;
import utils.ConsoleHelper;
import utils.SaveLoadData;
import views.List;
import views.Register;

public class Controller {

	private static Ayuntamiento townHall = null;

	public void run() {
		townHall = SaveLoadData.loadData(townHall);
		mainMenu();
	}

	private void mainMenu() {
		int opt;
		do {
			ConsoleHelper.printMainMenu();
			opt = ConsoleHelper.choseMenuOption(0, 2);

			switch (opt) {
			case 1:
				registerMenu();
				break;
			case 2:
				listMenu();
				break;
			}

		} while (opt != 0);
		
		SaveLoadData.saveData(townHall);
		ConsoleHelper.printError("Saliendo...");
		
	}
	
	private void registerMenu() {
		int registerOpt;
		do {
			ConsoleHelper.printRegisterMenu();
			registerOpt = ConsoleHelper.choseOption(0, 2);
			switch (registerOpt) {
			case 1:
				int studentTypeToRegister;
				do {
					ConsoleHelper.printTypeStudentToRegister();
					studentTypeToRegister = ConsoleHelper.choseOption(0, 2);

					switch (studentTypeToRegister) {
					case 1:
						townHall.addEsoStudent(Register.RegisterESOStudent());
						break;
					case 2:
						townHall.addCfStudents(Register.RegisterCFStudent());
						break;
					}

				} while (studentTypeToRegister != 0);
				break;
			case 2:
				int sportTypeToRegister;
				do {
					ConsoleHelper.printTypeSportToRegister();
					sportTypeToRegister = ConsoleHelper.choseOption(0, 2);

					switch (sportTypeToRegister) {
					case 1:
						townHall.addFutbolPlayers(Register.RegisterFootballPlayer());
						break;
					case 2:
						townHall.addBasketballPlayers(Register.RegisterBasketBallPlayer());
						break;
					}

				} while (sportTypeToRegister != 0);
				break;
			}
		} while (registerOpt != 0);
	}
	
	private void listMenu() {
		int registerOpt;
		do {
			ConsoleHelper.printListMenu();
			registerOpt = ConsoleHelper.choseOption(0, 7);
			switch (registerOpt) {
			case 1:
				List.ListAllESO(townHall);
				break;
			case 2:
				List.ListAllCF(townHall);
				break;
			case 3:
				List.ListAllFootBallPlayers(townHall);
				break;
			case 4:
				List.ListAllBasketBallPlayers(townHall);
				break;
			case 5:
				List.ListAllStudents(townHall);
				break;
			case 6:
				List.ListAllSports(townHall);
				break;
			case 7:
				List.ListAllPersons(townHall);
				break;
			}
		} while (registerOpt != 0);
	}
}

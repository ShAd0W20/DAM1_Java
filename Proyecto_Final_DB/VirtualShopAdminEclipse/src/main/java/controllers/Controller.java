package main.java.controllers;

import main.java.utils.ConsoleHelper;
import main.java.views.ProductView;
import main.java.views.SellsView;
import main.java.views.UserView;

public class Controller {
	public void run() {
		mainMenu();
	}

	private void mainMenu() {
		int opt;
		do {
			ConsoleHelper.printMainMenu();
			opt = ConsoleHelper.choseMenuOption(0, 3);
			switch (opt) {
			case 1 -> this.userMenu();
			case 2 -> this.productMenu();
			case 3 -> this.sellsMenu();
			}
		} while (opt != 0);

		System.out.printf("%n%n[+] Saliendo... %n");
	}

	private void userMenu() {
		int userOpt;
		do {
			ConsoleHelper.printUserMenu();
			userOpt = ConsoleHelper.choseMenuOption(0, 2);
			switch (userOpt) {
			case 1 -> UserView.viewUserInfo();
			case 2 -> UserView.viewAllUsers();
			}
		} while (userOpt != 0);
	}

	private void productMenu() {
		int productOpt;
		do {
			ConsoleHelper.printProductMenu();
			productOpt = ConsoleHelper.choseMenuOption(0, 3);
			switch (productOpt) {
			case 1 -> ProductView.registerProduct();
			case 2 -> ProductView.updateProduct();
			case 3 -> ProductView.deleteProduct();
			}
		} while (productOpt != 0);
	}

	private void sellsMenu() {
		int sellsOpt;
		do {
			ConsoleHelper.printSellsMenu();
			sellsOpt = ConsoleHelper.choseMenuOption(0, 5);
			switch (sellsOpt) {
			case 1 -> SellsView.viewUserBill();
			case 2 -> SellsView.viewAllBillsFromUser();
			case 3 -> SellsView.viewAllBillsBetweenDates();
			case 4 -> SellsView.viewProductStatistics();
			case 5 -> SellsView.viewAllProductStatistics();
			}
		} while (sellsOpt != 0);
	}

}

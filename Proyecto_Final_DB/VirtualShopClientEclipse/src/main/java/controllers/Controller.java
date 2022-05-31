package main.java.controllers;

import main.java.utils.ConsoleHelper;
import main.java.views.ShopView;
import main.java.views.UserView;

public class Controller {

	public void run() {
		mainMenu();
	}

	private void mainMenu() {
		int opt;
		do {
			ConsoleHelper.printMainMenu();
			opt = ConsoleHelper.choseMenuOption(0, 2);
			switch (opt) {
			case 1 -> this.clientMenu();
			case 2 -> this.shopMenu();
			}
		} while (opt != 0);

		System.out.printf("%n%n[+] Saliendo... %n");
	}

	private void clientMenu() {
		int clientOpt;
		do {
			ConsoleHelper.printClientMenu();
			clientOpt = ConsoleHelper.choseOption(0, 3);

			switch (clientOpt) {
			case 1 -> UserView.registerUser();
			case 2 -> UserView.modifyUserInfo();
			case 3 -> UserView.deleteUser();
			}

		} while (clientOpt != 0);
	}

	private void shopMenu() {
		int shopOpt;
		if (!ShopView.mainShopMenu()) {
			ConsoleHelper.printShopNotRegistered();
			shopOpt = ConsoleHelper.choseOption(0, 1);

			if (shopOpt == 1)
				UserView.registerUser();
		}
	}
}

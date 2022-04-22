package Controllers;

import models.Tienda;
import utils.ConsoleHelper;
import views.Login;

public class Controller {
	static Tienda tienda = new Tienda();
	
	private static final String PASSWORD = "123456";

	public void run() {
		mainMenu();
	}

	private void mainMenu() {
		int opt;
		do {
			ConsoleHelper.printMainMenu();
			opt = ConsoleHelper.choseMenuOption(0, 2);
			switch (opt) {
			case 1:
				int registerOpt;
				do {
					ConsoleHelper.printRegisterMenu();
					registerOpt = ConsoleHelper.choseOption(0, 4);
					switch (registerOpt) {
					case 1:

						break;
					case 2:

						break;
					case 3:

						break;
					case 4:

						break;
					}
				} while (registerOpt != 0);
				break;
			case 2:
				if(Login.doLogin(PASSWORD)) {
					int editOpt;
					do {
						ConsoleHelper.printEditMenu();
						editOpt = ConsoleHelper.choseOption(0, 4);
						switch (editOpt) {
						case 1:

							break;
						case 2:

							break;
						case 3:

							break;
						case 4:

							break;
						}
					} while (editOpt != 0);
				}
				break;
			}
		} while (opt != 0);

		System.out.printf("%n%n[!] Saliendo... %n");
	}
}

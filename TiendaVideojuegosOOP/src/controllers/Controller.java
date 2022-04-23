package controllers;

import models.Tienda;
import utils.ConsoleHelper;
import utils.SaveLoadData;
import views.Buy;
import views.Edit;
import views.Login;

public class Controller {
	static Tienda tienda = null;
	
	private static final String PASSWORD = "123456";

	public void run() {
		tienda = SaveLoadData.loadData(tienda);
		mainMenu();
	}

	private void mainMenu() {
		int opt;
		do {
			ConsoleHelper.printMainMenu();
			opt = ConsoleHelper.choseMenuOption(0, 2);
			switch (opt) {
			case 1:
				Buy.buyProduct(tienda);				
				break;
			case 2:
				if(Login.doLogin(PASSWORD)) {
					int editOpt;
					do {
						ConsoleHelper.printEditMenu();
						editOpt = ConsoleHelper.choseOption(0, 5);
						switch (editOpt) {
						case 1:
							Edit.addProduct(tienda);
							break;
						case 2:
							Edit.addStockToProduct(tienda);
							break;
						case 3:
							Edit.deleteProduct(tienda);
							break;
						case 4:
							Edit.listAllProducts(tienda);
							break;
						case 5:
							Edit.listSoltProducts(tienda);
							break;
						}
					} while (editOpt != 0);
				}
				break;
			}
		} while (opt != 0);
		
		SaveLoadData.saveData(tienda);
		System.out.printf("%n%n[!] Saliendo... %n");
	}
}

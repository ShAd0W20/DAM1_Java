package mainapp;

import models.CuentaBanco;

public class MainApp {
	public static void main(String[] args) {
		CuentaBanco banco1 = new CuentaBanco("Pepe", 1234, 1000);
		CuentaBanco banco2 = new CuentaBanco("Maria", 4567, 2000);
		
		banco1.addMoneyToAccount(500);
		
		System.out.println("Cuenta de " + banco1.getClientName() + " tiene " + banco1.getAccountMoney() + "€");
		
		if(banco2.reintegramiento(1000)) {
			System.out.println("Cuenta de " + banco2.getClientName() + " tiene " + banco2.getAccountMoney() + "€");			
		} else {
			System.out.println("[!] ERROR: no tiene suficiente dinero");
		}
		
		if(!banco1.reintegramiento(50000)) {
			System.out.println("[!] No hay suficiente dinero en la cuenta de " + banco1.getClientName() + ", actualmente hay " + banco1.getAccountMoney() + "€ y ha intentado retirar 50.000€");
		} else {
			System.out.println("Cuenta de " + banco1.getClientName() + " tiene " + banco1.getAccountMoney() + "€");			
		}
		
		if(banco2.transferMoney(200, banco1)) {
			System.out.println("Cuenta de " + banco1.getClientName() + " tiene " + banco1.getAccountMoney() + "€");
			System.out.println("Cuenta de " + banco2.getClientName() + " tiene " + banco2.getAccountMoney() + "€");	
		} else {
			System.out.println("[!] No hay suficiente dinero en la cuenta de " + banco2.getClientName() + ", actualmente hay " + banco2.getAccountMoney() + "€ y ha intentado transferir 50.000€");			
		}
		
		if(banco1.transferMoney(50000, banco2)) {
			System.out.println("Cuenta de " + banco1.getClientName() + " tiene " + banco1.getAccountMoney() + "€");
			System.out.println("Cuenta de " + banco2.getClientName() + " tiene " + banco2.getAccountMoney() + "€");	
		} else {
			System.out.println("[!] No hay suficiente dinero en la cuenta de " + banco1.getClientName() + ", actualmente hay " + banco1.getAccountMoney() + "€ y ha intentado transferir 50.000€");			
		}
	}
}

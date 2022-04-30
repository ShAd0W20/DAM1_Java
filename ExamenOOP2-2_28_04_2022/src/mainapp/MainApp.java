package mainapp;

import java.util.Scanner;

import modules.Banco;
import modules.Cliente;
import modules.enums.Oficina;

public class MainApp {
	private static Banco banco = new Banco();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String mainMenuOpt = "";

		System.out.println("Que desea hacer? \n[1] Añadir cliente \n[2] Crear cuenta \n[3] Hacer ingreso \n[4] Hacer reintegro \n[5] Hacer  transferencia \n[6] Informe cuenta \n[7] Informe cliente \n[Salir] para salir");

		do {
			mainMenuOpt = input.nextLine();

			switch (mainMenuOpt) {
			case "1":
				registerClient(banco);
				break;
			case "2":
				registerCuenta(banco);
				break;
			case "3":
				doIngreso(banco);
				break;
			case "4":
				doReintegro(banco);
				break;
			case "5":
				doTransferencia(banco);
				break;
			case "6":
				getInfoCuenta(banco);
				break;
			case "7":
				getInfoClient(banco);
				break;
			default:
				if (!mainMenuOpt.equalsIgnoreCase("salir")) {
					System.out.println("Que desea hacer? \n[1] Añadir cliente \n[2] Crear cuenta \n[3] Hacer ingreso \n[4] Hacer reintegro \n[5] Hacer  transferencia \n[6] Informe cuenta \n[7] Informe cliente \n[Salir] para salir");
				}
			}

		} while (!mainMenuOpt.equalsIgnoreCase("salir"));
		
		System.out.println("\n\n[+] Saliendo... \n");
	}
	
	private static void registerClient(Banco banco) {
		String dni = "";
		String name = "";
		
		System.out.println("Introduce el dni del cliente");
		dni = input.nextLine();
		
		System.out.println("Introduce el nombre del cliente");
		name = input.nextLine();
		
		Cliente c = new Cliente(dni, name, getOficinas());
		banco.addCliente(c);
	}
	
	private static void registerCuenta(Banco banco) {
		String dni = "";
		int saldo = 0;
		System.out.println("Introduce el dni del cliente");
		dni = input.nextLine();
		
		System.out.println("Introduce el saldo del cliente");
		saldo = input.nextInt();
		input.nextLine();
		
		banco.addCuenta(dni, saldo);
	}
	
	private static void doIngreso(Banco banco) {
		int cuenta = 0;
		int money = 0;
		
		System.out.println("Introduce el numero de cuenta");
		cuenta = input.nextInt();
		input.nextLine();
		

		System.out.println("Introduce la cantidad a ingresar");
		money = input.nextInt();
		input.nextLine();
		
		banco.ingreso(cuenta, money);
	}
	
	private static void doReintegro(Banco banco) {
		int cuenta = 0;
		int money = 0;
		
		System.out.println("Introduce el numero de cuenta");
		cuenta = input.nextInt();
		input.nextLine();
		

		System.out.println("Introduce la cantidad a reintegrar");
		money = input.nextInt();
		input.nextLine();
		
		banco.reintegramiento(cuenta, money);
	}
	
	private static void doTransferencia(Banco banco) {
		int emisor = 0;
		int receptor = 0;
		int money = 0;
		
		System.out.println("Introduce el numero de cuenta emisor");
		emisor = input.nextInt();
		input.nextLine();
		
		System.out.println("Introduce el numero de cuenta receptor");
		receptor = input.nextInt();
		input.nextLine();

		System.out.println("Introduce la cantidad a transferir");
		money = input.nextInt();
		input.nextLine();
		
		banco.transferencia(emisor, receptor, money);
	}
	
	private static void getInfoCuenta(Banco banco) {
		int cuenta = 0;
		
		System.out.println("Introduce el numero de cuenta emisor");
		cuenta = input.nextInt();
		input.nextLine();
		
		System.out.println(banco.informeCuenta(cuenta));
	}
	
	private static void getInfoClient(Banco banco) {
		String dni = "";
		System.out.println("Introduce el dni del cliente");
		dni = input.nextLine();
		
		System.out.println(banco.informeCliente(dni));
	}
	
	private static Oficina getOficinas() {
		for(Oficina o : Oficina.values()) {
			System.out.println("[+] " + o.getLocation());
		}
		
		System.out.println("Introduce el nombre de la oficina");
		String oficina = input.nextLine();
		
		switch (oficina) {
		case "Gerona":
			return Oficina.GERONA;
		case "Barcelona":
			return Oficina.BARCELONA;
		case "Tarragona":
			return Oficina.TARRAGONA;
		case "Lleida":
			return Oficina.LLEIDA;
		}
		return null;
	}
}

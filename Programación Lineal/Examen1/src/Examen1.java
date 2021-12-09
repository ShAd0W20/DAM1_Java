import java.util.Scanner;

public class Examen1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		final int maxVeh = 10;
		
		String[] vehPatent = new String[maxVeh];
		String[] vehName = new String[maxVeh];
		double[] vehPrice = new double[maxVeh];
		boolean[] vehType = new boolean[maxVeh]; 

		int totalVehInArray = 0; 

		String menuOption = "";
		String subMenuOption = "";
		String insertCarType = ""; 
		String listCarType = "";
		String menuModifyOption = "";
		
		/*vehPatent[0] = "00001X"; vehName[0] = "Volvo"; vehPrice[0] = 15000.00; vehType[0] = false;
		vehPatent[1] = "00002X"; vehName[1] = "BMW"; vehPrice[1] = 20000.00; vehType[1] = true;
		vehPatent[2] = "00003X"; vehName[2] = "Audi"; vehPrice[2] = 25000.00; vehType[2] = false;
		vehPatent[3] = "00004X"; vehName[3] = "Proche"; vehPrice[3] = 35000.00; vehType[3] = true;
		vehPatent[4] = "00005X"; vehName[4] = "Proche"; vehPrice[4] = 35000.00; vehType[4] = true;
		vehPatent[5] = "00006X"; vehName[5] = "Proche"; vehPrice[5] = 35000.00; vehType[5] = true;
		vehPatent[6] = "00007X"; vehName[6] = "Proche"; vehPrice[6] = 35000.00; vehType[6] = true;
		vehPatent[7] = "00008X"; vehName[7] = "Proche"; vehPrice[7] = 35000.00; vehType[7] = true;
		vehPatent[8] = "00009X"; vehName[8] = "Proche"; vehPrice[8] = 35000.00; vehType[8] = true;
		vehPatent[9] = "00010X"; vehName[9] = "Proche"; vehPrice[9] = 35000.00; vehType[9] = true;*/
		
		System.out.println("Que desea hacer? \n 1: Registrar vehiculo \n 2: Modificar vehiculo \n 3: Listar vehiculos \n 'Salir': para salir del programa");
		do {
			menuOption = input.nextLine();
			
			switch (menuOption) {
			case "1":
				if(totalVehInArray == maxVeh) {
					System.out.println("No puedes registrar mas vehiculos \n Pulse enter para salir al menu");
				} else {
					System.out.println("Introduce la matricula del vehiculo");
					vehPatent[totalVehInArray] = input.nextLine();
					
					System.out.println("Itroduce el modelo del vehiculo");
					vehName[totalVehInArray] = input.nextLine();
					
					System.out.println("Introduce el precio del vehiculo");
					vehPrice[totalVehInArray] = input.nextDouble();
					input.nextLine();
					
					System.out.println("Es un coche o una moto? \n 1: Moto \n 2: Coche");
					insertCarType = input.nextLine();
					vehType[totalVehInArray] = (insertCarType.equals("1")) ? true : false;
					
					listCarType = (vehType[totalVehInArray] == true) ? "Moto" : "Coche";
					
					System.out.println(vehPatent[totalVehInArray] + " " + vehName[totalVehInArray] + " " + vehPrice[totalVehInArray] + " " + listCarType + "\n");
					totalVehInArray++;
					System.out.println("Actualmente tienes: " + totalVehInArray + " coches registrados. \n Pulse enter para salir al menu");
				}
				break;
			case "2":
				System.out.println("Introduce la matricula del vehiculo a modificar");
				menuModifyOption = input.nextLine();
				
				int k = 0;
				while(!menuModifyOption.equals(vehPatent[k]) && k < totalVehInArray) {
					k++;
				}
				
				if(menuModifyOption.equals(vehPatent[k])) {
					System.out.println("Que desea modificar? \n 1: Modelo \n 2: Precio");
					subMenuOption = input.nextLine();
					switch(subMenuOption) {
						case "1":
							System.out.println("Actualmente el vehiculo " + vehPatent[k] + " tiene el modelo de " + vehName[k] + "\n Introduce el nuevo modelo");
							vehName[k] = input.nextLine();
							break;
						case "2":
							System.out.println("Actualmente el vehiculo " + vehPatent[k] + " tiene el precio de " + vehPrice[k] + "\n Introduce el nuevo precio");
							vehPrice[k] = input.nextDouble();
							input.nextLine();
							break;
					}
					System.out.println("Vehiculo actualizado \n Los nuevos datos son: " + vehPatent[k] + " " + vehName[k] + " " + vehPrice[k]);
					System.out.println("\n Pulse enter para salir al menu");
				} else {
					System.out.println("El vehiculo con matricula " + menuModifyOption + " no está registrado. \n Pulse enter para salir al menu");
				}
				break;
			case "3":
				for(int j = 0; j < totalVehInArray; j++) {
					listCarType = (vehType[j] == true) ? "Moto" : "Coche"; 
					System.out.println(vehPatent[j] + " - " + vehName[j] + " - " + vehPrice[j] + " - " + listCarType);
				}
				System.out.println("\n Pulse enter para salir al menu");
				break;
			default:
				if(!menuOption.toLowerCase().equals("salir")) {
					System.out.println("Que desea hacer? \n 1: Registrar vehiculo \n 2: Modificar vehiculo \n 3: Listar vehiculos \n 'Salir': para salir del programa");
				}
			}
			
		} while(!menuOption.toLowerCase().equals("salir"));
		System.out.println("Has salido del programa");
		input.close();
	}

}

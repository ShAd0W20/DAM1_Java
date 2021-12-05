import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Examen2_1_1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String[] carID = new String[100];
		LocalDateTime[] invoiceDate = new LocalDateTime[100];
		int[] carVelocity = new int[100];
		
		String mainMenuOption = "";
		String carIDToRegiser = "";
		String[] textCarInfractionHour = new String[3];
		int[] carInfractionHour = new int[3];
		String[] textCarInfractionDate = new String[3];
		int[] carInfractionDate = new int[3];
		
		int totalCarsRegistered = 0;
		
		System.out.println("E) Para registrar multa \nL) Para listar multas \n'Salir' para salir del programa");
		
		do {
			mainMenuOption = input.nextLine();
			switch (mainMenuOption) {
			case "E":
				System.out.println("Introduce la matricula del vehiculo. Ejemplo: 1234BCD");
				do {
					carIDToRegiser = input.nextLine();
										
					if(!Pattern.matches("[0-9]{4}[BCDFG]{3}", carIDToRegiser)) {
						System.out.println("Introduce la matricula del vehiculo. Ejemplo: 1234BCD");
					}
				} while (!Pattern.matches("[0-9]{4}[BCDFG]{3}", carIDToRegiser));
				
				carID[totalCarsRegistered] = carIDToRegiser;
				
				System.out.println("Introduce la fecha de la infracción: h:m:s");
				textCarInfractionHour = input.nextLine().split(":");
				for (int i = 0; i < textCarInfractionHour.length; i++) { 
					carInfractionHour[i] = Integer.parseInt(textCarInfractionHour[i]);
				}
				
				System.out.println("Introduce la fecha de la infracción: DD/MM/AA");
				textCarInfractionDate = input.nextLine().split("/");
				for (int i = 0; i < textCarInfractionDate.length; i++) { 
					carInfractionDate[i] = Integer.parseInt(textCarInfractionDate[i]);
				}				
				invoiceDate[totalCarsRegistered] = LocalDateTime.of(carInfractionDate[2], carInfractionDate[1], carInfractionDate[0], carInfractionHour[0], carInfractionHour[1], carInfractionHour[2]);
				
				System.out.println("A que velocidad ha sido captado?");
				carVelocity[totalCarsRegistered] = input.nextInt();
				input.nextLine();
				
				totalCarsRegistered++;
				System.out.println("Pulsa enter para volver al menu");
				break;
			case "L":
				for(int i = 0; i < totalCarsRegistered; i++) {
					System.out.println(carID[i] + " " + invoiceDate[i].getDayOfMonth() + "/" + invoiceDate[i].getMonthValue() + "/" + invoiceDate[i].getYear() + " " + invoiceDate[i].getHour() + ":" + invoiceDate[i].getMinute() + ":" + invoiceDate[i].getSecond() + " " + carVelocity[i] + " Km/hora");
				}
				
				System.out.println("\nPulsa enter para volver al menu");
				break;
			default:
				if(!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.println("E) Para registrar multa \nL) Para listar multas \n'Salir' para salir del programa");
				}
			}
		} while (!mainMenuOption.equalsIgnoreCase("salir"));
		
		input.close();
	}

}

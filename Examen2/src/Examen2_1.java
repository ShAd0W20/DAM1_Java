import java.time.LocalDate;
import java.util.Scanner;

public class Examen2_1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		final int MAX_COMPUTERS = 10;

		String[] computerID = new String[MAX_COMPUTERS];
		String[] computerModel = new String[MAX_COMPUTERS];
		String[] computerType = new String[MAX_COMPUTERS];
		LocalDate[] computerDate = new LocalDate[MAX_COMPUTERS];
		LocalDate computerWarranty = LocalDate.of(1970,1,1);
		
		String[] computerTypes = {"Sobretaula", "Portatil", "Impressora", "Router"};

		int totalComputersStored = 8;

		computerID[0] = "AA01";	computerModel[0] = "Lenovo V510"; computerType[0] = "Sobretaula"; computerDate[0] = LocalDate.of(2019, 2, 1);
		computerID[1] = "AB02";	computerModel[1] = "AORUS 15";	computerType[1] = "Portatil"; computerDate[1] = LocalDate.of(2020, 5, 1);
		computerID[2] = "AC03";	computerModel[2] = "MSI 57"; computerType[2] = "Portatil"; computerDate[2] = LocalDate.of(2021, 6, 1);
		computerID[3] = "AD04";	computerModel[3] = "Acer G501"; computerType[3] = "Impressora"; computerDate[3] = LocalDate.of(2018, 7, 1);
		computerID[4] = "AE05"; computerModel[4] = "Dell Su"; computerType[4] = "Router"; computerDate[4] = LocalDate.of(2017, 2, 1);
		computerID[5] = "AF06"; computerModel[5] = "Corsair V510"; computerType[5] = "Router"; computerDate[5] = LocalDate.of(2018, 4, 1);
		computerID[6] = "AG07"; computerModel[6] = "HP 250"; computerType[6] = "Impressora"; computerDate[6] = LocalDate.of(2015, 5, 1);
		computerID[7] = "AH01";	computerModel[7] = "AOC G982"; computerType[7] = "Sobretaula"; computerDate[7] = LocalDate.of(2021, 9, 1);

		String mainMenuOption = "";
		
		String computerCodeToDelete = "";
		
		String computerIDToSort = "";
		String computerModelToSort = "";
		String computerTypeToSort = "";
		LocalDate computerDateToSort = LocalDate.of(3000, 1, 1);
		

		System.out.println("Que desea hacer? \n1) Listar los equipos por tipo \n2) Borrar 1 equipo \n3) Listar los equipos por fecha de garantia \n'Salir' para salir del porgrama");

		do {
			mainMenuOption = input.nextLine();
			switch (mainMenuOption) {
			case "1":
				
				for(int i = 0; i < computerTypes.length; i++) {
					System.out.println("\n" + computerTypes[i]);
					for(int j = 0; j < totalComputersStored; j++) {
						if(computerType[j].equals(computerTypes[i])) {
							System.out.println(computerID[j] + " - " + computerModel[j] + " - " + computerDate[j].getDayOfMonth() + "/" + computerDate[j].getMonthValue() + "/" + computerDate[j].getYear());
						}
					}					
				}
				
				System.out.println("Presiona Enter para volver al menu");

				break;
			case "2":
				System.out.println("Introduce el codigo del ordenador a eliminar");
				computerCodeToDelete = input.nextLine();

				int arrayPositoinToDelete = 0;
				while (!computerCodeToDelete.equals(computerID[arrayPositoinToDelete]) && arrayPositoinToDelete < totalComputersStored) {
					arrayPositoinToDelete++;
				}
				
				if (computerCodeToDelete.equals(computerID[arrayPositoinToDelete])) {
					for (int j = arrayPositoinToDelete; j < totalComputersStored - 1; j++) {
						computerID[j] = computerID[j + 1];
						computerModel[j] = computerModel[j + 1];
						computerType[j] = computerType[j + 1];
						computerDate[j] = computerDate[j + 1];
					}
					totalComputersStored--;
					
					for (int k = 0; k < totalComputersStored; k++) {
						System.out.println(computerID[k] + " " + computerModel[k] + " " + computerType[k] + " " + computerDate[k].getDayOfMonth() + "/" + computerDate[k].getMonthValue() + "/" + computerDate[k].getYear() + "\n Presiona enter para volver al menu");
					}
				} else {
					System.out.println("El ordenador: " + computerCodeToDelete + " no existe \n Presiona enter para volver al menu");
				}
				
				break;
			case "3":
				
				 for (int i = 0; i < totalComputersStored - 1; i++) {
					  
					  for (int j = i + 1; j < totalComputersStored; j++) {
					  
						  if (computerDate[i].compareTo(computerDate[j]) > 0) {
						  
							  computerIDToSort = computerID[i];
							  
							  computerID[i] = computerID[j];
							  
							  computerID[j] = computerIDToSort;
							  
							  computerModelToSort = computerModel[i];
							  
							  computerModel[i] = computerModel[j];
							  
							  computerModel[j] = computerModelToSort;
							  
							  computerTypeToSort = computerType[i];
							  
							  computerType[i] = computerType[j];
							  
							  computerType[j] = computerTypeToSort;
							  
							  computerDateToSort = computerDate[i];
							  
							  computerDate[i] = computerDate[j];
							  
							  computerDate[j] = computerDateToSort;
						  } 
					  }
				 }
				 
				 for (int k = 0; k < totalComputersStored; k++) {
					 computerWarranty = computerDate[k].plusYears(2);
					 if((computerWarranty.compareTo(LocalDate.now())) < 0) {
						 System.out.println(computerID[k] + " - " + computerModel[k] + " - " + computerType[k] + " - Garantia Finaliazada ");
					 } else {
						 System.out.println(computerID[k] + " - " + computerModel[k] + " - " + computerType[k] + " - " + computerWarranty.getDayOfMonth() + "/" + computerWarranty.getMonthValue() + "/" + computerWarranty.getYear());
					 }
				 }
				 
				 System.out.println("\n Presiona enter para volver al menu");
				
				break;
			default:
				if (!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.println(	"Que desea hacer? \n1) Listar los equipos por tipo \n2) Borrar 1 equipo \n3) Listar los equipos por fecha de garantia \n'Salir' para salir del porgrama");
				}
			}
		} while (!mainMenuOption.equalsIgnoreCase("salir"));
		
		System.out.println("Has salido del programa");
		input.close();
	}

}

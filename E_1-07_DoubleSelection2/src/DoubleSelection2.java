import java.util.Scanner;

public class DoubleSelection2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String userName = "";
		int userAge = 0;
		String userCity = "";
		String userTransport = "";
		
		System.out.println("Introdueix el teu nom");
		
		userName = input.nextLine();
		
		System.out.println("Introdueix la teva edat");
		
		userAge = input.nextInt();
		input.nextLine();
		
		System.out.println("On vius?");
		
		userCity = input.nextLine();
		
		if(userCity.toLowerCase().equals("palam�s") || userCity.toLowerCase().equals("palamos")) {
			System.out.println("Et dius " + userName +  ", tens " + userAge + "anys i vius a Palam�s.");
		}
		else {
			System.out.println("Amb quin transport vens a Palam�s?");
			userTransport = input.nextLine();
			
			System.out.println("Et dius " + userName +  ", tens " + userAge + " anys i per venir a Palam�s utilitzes " + userTransport + ".");
		}

		input.close();

	}

}

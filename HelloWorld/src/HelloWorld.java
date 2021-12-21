import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalTimeToLoop = 0;
		
		do {
			System.out.println("Cuantas veces desea imprimir la palabra");
			totalTimeToLoop = input.nextInt();
			input.nextLine();	
		} while(totalTimeToLoop < 0 || totalTimeToLoop > 5);
		
		for (int i = 0; i < totalTimeToLoop; i++) {
			System.out.println("Hola mundo.");
		}
		
		input.close();
	}

}

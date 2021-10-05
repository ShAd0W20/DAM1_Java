import java.util.Scanner;

public class SwitchCase1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double firstNumber = 0;
		double secondNumber = 0;
		char operacion = '0';
		double finalResult = 0;
		double divisionReminder = 0;
		String hasReminder = "";
		
		System.out.println("Entra el primer numero");
		firstNumber = input.nextInt();
		input.nextLine();
		
		System.out.println("Entra el segundo numero");
		secondNumber = input.nextInt();
		input.nextLine();
		
		System.out.println("Que operación desea hacer?");
		operacion = input.nextLine().charAt(0);
		
		input.close();
		
		switch (operacion) {
			case '-':
				finalResult = firstNumber - secondNumber;
				break;
			case '+':
				finalResult = firstNumber + secondNumber;
				break;
			case '*':
				finalResult = firstNumber * secondNumber;
				break;
			case '/':
				finalResult = firstNumber / secondNumber;
				if((firstNumber % secondNumber) != 0.00) {
					divisionReminder = firstNumber % secondNumber;
					hasReminder = " y el resto es: " + divisionReminder;
				}
				break;
			default:
				System.out.println("Operación no valida");
		}
		
		System.out.println("El resultado es: " + finalResult + hasReminder);
	}

}

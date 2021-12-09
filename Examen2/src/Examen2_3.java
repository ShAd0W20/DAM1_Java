import java.util.Random;
import java.util.Scanner;

public class Examen2_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final int TOTAL_ROWS = 4;
		final int TOTA_COLUMNS = 5;
		
		Random rnd = new Random();
		
		int[][] numbers = new int[TOTAL_ROWS][TOTA_COLUMNS];
		String[] availableOperations = {"+", "-", "*"};
		String[] operations = new String[10];
		
		int oprationResult = 0;
		int totalOperations = 0;
		String isCorrect = "";
		int correctOperations = 0;
		
		for(int i = 0; i < TOTAL_ROWS; i++) {
			for(int j = 0; j < TOTA_COLUMNS; j++) {
				numbers[i][j] = rnd.nextInt(30);
			}			
		}
		
		do {
			int randomRow = rnd.nextInt(TOTAL_ROWS);
			int randomColumn = rnd.nextInt(TOTA_COLUMNS);
			int randomRow2 = rnd.nextInt(TOTAL_ROWS);
			int randomColumn2 = rnd.nextInt(TOTA_COLUMNS);
			int randomOperation = rnd.nextInt(3);
			System.out.println("Introduce el resultado");
			System.out.print(numbers[randomRow][randomColumn] + " " + availableOperations[randomOperation] + " " + numbers[randomRow2][randomColumn2] + " = ");
			oprationResult = input.nextInt();
			input.nextLine();
			
			if((numbers[randomRow][randomColumn] + numbers[randomRow2][randomColumn2]) == oprationResult || (numbers[randomRow][randomColumn] - numbers[randomRow2][randomColumn2]) == oprationResult || (numbers[randomRow][randomColumn] * numbers[randomRow2][randomColumn2]) == oprationResult) {
				isCorrect = "Correcto";
				correctOperations++;
			} else {
				isCorrect = "Error";
			}
			
			operations[totalOperations] = (numbers[randomRow][randomColumn] + " " + availableOperations[randomOperation] + " " + numbers[randomRow2][randomColumn2] + " = " + oprationResult + " " + isCorrect);
			
			totalOperations++;
		} while (totalOperations < 10);
		
		System.out.println("\n RESULTADOS");
		for(int i = 0; i < operations.length; i++) {
			System.out.println(operations[i]);
		}
		System.out.println("Has sacado un: " + correctOperations);
		
		input.close();
		
	}

}

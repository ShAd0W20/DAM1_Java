package mainapp;
import java.util.Scanner;
import math.*;

public class MainApp {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int firstInteger = 0;
		int segondInteger = 0;
		double firstDouble = 0;
		double segondDouble = 0;
		
		System.out.println("Introduce dos numeros enteros");
		firstInteger = input.nextInt();
		segondInteger = input.nextInt();
		input.nextLine();
		
		System.out.println("Introduce dos numeros decimales");
		firstDouble = input.nextDouble();
		segondDouble = input.nextDouble();
		input.nextLine();
		
		System.out.println(calculateIntegers.plusNumbers(firstInteger, segondInteger));
		System.out.println(calculateIntegers.minusNumbers(firstInteger, segondInteger));
		System.out.println(calculateDoubles.plusNumbers(firstDouble, segondDouble));
		System.out.println(calculateDoubles.minusNumbers(firstDouble, segondDouble));
		
		input.close();
	}

}

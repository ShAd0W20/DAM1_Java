import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Functions {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce la fecha de nacimiento DD/MM/AAAA");
		
		System.out.println("Tienes " + userAge(userBirthDay(input.nextLine())) + " años");
		
		input.close();
	}
	
	static LocalDate userBirthDay(String inputBirthDay) {		
		return LocalDate.parse(inputBirthDay, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	static int userAge(LocalDate userBirthDay) {		
		return Period.between(userBirthDay, LocalDate.now()).getYears();
	}

}

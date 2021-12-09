import java.time.YearMonth;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class doWhile2 {

	public static String getMonth(int month) {
		try {
			if (month < 1 || month > 12) {
				throw new Exception("Numero del mes invalido");
			}
			return new DateFormatSymbols(new Locale("es")).getMonths()[month - 1];
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int monthNumber = 0;

		do {
			System.out.println("Introduce el numero del mes");
			monthNumber = input.nextInt();
			input.nextLine();

			if (monthNumber < 1 || monthNumber > 12) {
				System.out.println("Numero del mes invalido");
			}

		} while (monthNumber < 1 || monthNumber > 12);

		input.close();

		YearMonth yearMonthObject = YearMonth.of(Calendar.YEAR, monthNumber);
		int daysInMonth = yearMonthObject.lengthOfMonth();

		System.out.println("El nombe del mes es " + getMonth(monthNumber) + " y tiene " + daysInMonth + " dias");
	}
}
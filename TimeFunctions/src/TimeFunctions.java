import java.time.*;
import java.util.Scanner;

public class TimeFunctions {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String[] textLeave = new String[3];
		String[] textArribal = new String[3];
		int[] timeLeave = new int[3];
		int[] timeArribal = new int[3];

		LocalTime houseLeave = LocalTime.of(0, 0, 0);
		LocalTime schoolArribal = LocalTime.of(0, 0, 0);
		Duration timeBetweenLeaveArribal = Duration.between(houseLeave, schoolArribal);

		System.out.println("A que hora has salido de casa? h:m:s");
		textLeave = input.nextLine().split(":");

		System.out.println("A que hora has llegado al insti? h:m:s");
		textArribal = input.nextLine().split(":");

		for (int i = 0; i < textLeave.length; i++) {
			timeLeave[i] = Integer.parseInt(textLeave[i]);
			timeArribal[i] = Integer.parseInt(textArribal[i]);
		}

		houseLeave = LocalTime.of(timeLeave[0], timeLeave[1], timeLeave[2]);
		schoolArribal = LocalTime.of(timeArribal[0], timeArribal[1], timeArribal[2]);
		timeBetweenLeaveArribal = Duration.between(houseLeave, schoolArribal);

		System.out.println("Has tardado: " + timeBetweenLeaveArribal.toHoursPart() + "h " + timeBetweenLeaveArribal.toMinutesPart() + "m " + timeBetweenLeaveArribal.toSecondsPart() + "s");

		input.close();
	}
}

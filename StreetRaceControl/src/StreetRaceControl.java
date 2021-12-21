import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StreetRaceControl {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		final int MAX_RACERS = 10;

		String[] racerName = new String[MAX_RACERS];
		int[] racerID = new int[MAX_RACERS];
		LocalTime[] racerStartTime = new LocalTime[MAX_RACERS];
		LocalTime[] racerEndTime = new LocalTime[MAX_RACERS];

		/*racerName[0] = "a"; racerID[0] = 1; 
		racerName[1] = "b"; racerID[1] = 2; 
		racerName[2] = "c"; racerID[2] = 3;
		racerName[3] = "d"; racerID[3] = 4; 
		racerName[4] = "f"; racerID[4] = 5;
		racerName[5] = "g"; racerID[5] = 6;
		racerName[6] = "h"; racerID[6] = 7;
		racerName[7] = "i"; racerID[7] = 8;
		racerName[8] = "j"; racerID[8] = 9;
		racerName[9] = "k"; racerID[9] = 10;*/

		registerNewRacers(racerID, racerName);
		registerRacersTimes(racerID, racerStartTime, racerEndTime);
		printRaceResults(racerID, racerName, racerStartTime, racerEndTime);
	}

	static void registerNewRacers(int[] racerID, String[] racerName) { //method to register new racers
		int racerIDToCheck = 0;
		for (int i = 0; i < racerID.length; i++) { //for loop to register racers 
			System.out.println("Introduce tu nombre");
			racerName[i] = input.nextLine();

			do {
				System.out.println("Introduce el dorsal deseado");
				racerIDToCheck = input.nextInt();
				input.nextLine();
			} while (isRacerIDRegistered(racerID, racerIDToCheck)); //call the function to check if it's a valid racerID

			racerID[i] = racerIDToCheck;
		}

	}

	static void registerRacersTimes(int[] racerID, LocalTime[] racerStartTime, LocalTime[] racerEndTime) { // method to register racers start and end times
		int searchReacerID = 0;
		int racersTimeRegistered = 0;

		do {
			System.out.println("A que dorsal le quieres asignar la hora de salida y llegada?");
			for (int i = 0; i < racerID.length; i++) { // for loop to know racers id in order to save the start and end
														// time
				if (racerStartTime[i] == null && racerEndTime[i] == null) {
					System.out.print(racerID[i] + " ");
				}
			}

			searchReacerID = input.nextInt(); // select runner ID to search in array
			input.nextLine();

			int k = 0; // integer used to know array index equals to user input
			while (searchReacerID != racerID[k] && k < racerID.length - 1) {// loop throw total racers in array while
																			// user input not equals racer id
				k++;
			}

			if (searchReacerID == racerID[k]) { // if while loop finds 1 runner with the searched value
				System.out.println("Introduce la hora de salida del corredor: " + racerID[k]
						+ " con el siguiente formato -> h:m:s");
				racerStartTime[k] = stringToLocalTime(input.nextLine());

				System.out.println("Introduce la hora de llegada del corredor: " + racerID[k]
						+ " con el siguiente formato -> h:m:s");
				racerEndTime[k] = stringToLocalTime(input.nextLine());

				racersTimeRegistered++; // plus 1 to 'racersTimeRegistered' in order to control the while loop
			} else {
				System.out.println("El dorsal " + searchReacerID + " no esta registrado");
			}
		} while (racersTimeRegistered < 10);

	}

	static void printRaceResults(int[] racerID, String[] racerName, LocalTime[] racerStartTime, LocalTime[] racerEndTime) { //method to print the results of the race

		int changeRacerID = 0;
		String changeRacerName = "";
		LocalTime changeRacerStartTime = LocalTime.of(0, 0, 0);
		LocalTime changeRacerEndTime = LocalTime.of(0, 0, 0);
		
		for (int i = 0; i < racerStartTime.length - 1; i++) { // For loop to order by race duration

			for (int j = i + 1; j < racerStartTime.length; j++) {

				if (durationBetween(racerStartTime[i], racerEndTime[i]).compareTo(durationBetween(racerStartTime[j], racerEndTime[j])) > 0) {

					changeRacerID = racerID[i];

					racerID[i] = racerID[j];

					racerID[j] = changeRacerID;

					changeRacerName = racerName[i];

					racerName[i] = racerName[j];

					racerName[j] = changeRacerName;

					changeRacerStartTime = racerStartTime[i];

					racerStartTime[i] = racerStartTime[j];

					racerStartTime[j] = changeRacerStartTime;

					changeRacerEndTime = racerEndTime[i];

					racerEndTime[i] = racerEndTime[j];

					racerEndTime[j] = changeRacerEndTime;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("[" + (i + 1) + "] " + racerID[i] + " - " + racerName[i] + " - "
					+ durationBetween(racerStartTime[i], racerEndTime[i]).toHoursPart() + ":"
					+ durationBetween(racerStartTime[i], racerEndTime[i]).toMinutesPart() + ":"
					+ durationBetween(racerStartTime[i], racerEndTime[i]).toSecondsPart());
		}
		
		System.out.println("Ha ganado: " + racerID[0]);
	}

	static boolean isRacerIDRegistered(int[] arrayRacersID, int racerIDToCheck) { // function to know if racer id is already registered
		int i = 0;
		while ((racerIDToCheck != arrayRacersID[i]) && (i < arrayRacersID.length - 1)) { // search if racerIDToCheck exists in the array 'arrayRacersID'
			i++;
		}
		if (racerIDToCheck == arrayRacersID[i]) { // if exists return true
			return true;
		} else {
			return false;
		}
	}

	static Duration durationBetween(LocalTime endTime, LocalTime startTime) { //function to calculate the duration between the end time and the start time
		return Duration.between(endTime, startTime);
	}

	static LocalTime stringToLocalTime(String time) { // function to parse the start and the end time to a valid LocalTime in order to save it into the array
		return LocalTime.parse(time, DateTimeFormatter.ofPattern("H:mm:ss"));
	}

}

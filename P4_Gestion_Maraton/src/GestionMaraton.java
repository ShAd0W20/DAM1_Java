import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class GestionMaraton {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

        final int MAX_RUNNERS = 5;

        String[] runnerName = new String[MAX_RUNNERS];
        int[] runnerID = new int[MAX_RUNNERS];
        LocalTime[] startTime = new LocalTime[MAX_RUNNERS];
        LocalTime[] endTime = new LocalTime[MAX_RUNNERS];
        Duration[] raceTotalTime = new Duration[MAX_RUNNERS];

        int totalRunnersTimeEntered = 0;
        String[] textStartRace = new String[3];
        String[] textEndRace = new String[3];
        int[] timeStartRace = new int[3];
        int[] timeEndRace = new int[3];

        int searchReacerID = 0;

        Duration totalTimeOrder;
		LocalTime starTimeOrder;
		LocalTime endTimeOrder;
		String runnerNameOrder;
		int runnerIDOrder;

        runnerName[0] = "Irene"; runnerID[0] = 2;
        runnerName[1] = "Maria"; runnerID[1] = 43;
        runnerName[2] = "Guille"; runnerID[2] = 3;
        runnerName[3] = "Pol"; runnerID[3] = 67;
        runnerName[4] = "Pablo"; runnerID[4] = 23;

        do {
            System.out.println("A que dorsal le quieres asignar la hora de salida y llegada?"); 
            for(int i = 0; i < MAX_RUNNERS; i++) { // for loop to know racers id in order to save the start and end time
                if(startTime[i] == null) {
                    System.out.println(runnerID[i] + "   -> " + runnerName[i]);
                }
            }

            searchReacerID = input.nextInt(); // select runner ID to searhc in array
            input.nextLine();

            int k = 0; // integer used to know array index equals to user input
            while(searchReacerID != runnerID[k] && k < MAX_RUNNERS - 1) {// loop throw total racers in array while user input not equals racer id					
                k++;
            }

            if(searchReacerID == runnerID[k]) {  // if while loop finds 1 runner with the seached value
                System.out.println("Introduce la hora de salida del corredor: " + runnerName[k] + " con el siguiente formato -> h:m:s"); // ask for runner start time
                textStartRace = input.nextLine().split(":"); // save the start time as String into the array by spliting it

                System.out.println("Introduce la hora de llegada del corredor: " + runnerName[k] + " con el siguiente formato -> h:m:s"); // ask for runner end time
                textEndRace = input.nextLine().split(":"); // save the end time as String into the array by spliting it

                for(int j = 0; j < textStartRace.length; j++) { // for loop to save the start and end time into int array in order to save it later into a LocalTime array
                    timeStartRace[j] = Integer.parseInt(textStartRace[j]);
                    timeEndRace[j] = Integer.parseInt(textEndRace[j]);
                }

                startTime[k] = LocalTime.of(timeStartRace[0], timeStartRace[1], timeStartRace[2]); // save the start time into the startTime array with the values saved before
                endTime[k] = LocalTime.of(timeEndRace[0], timeEndRace[1], timeEndRace[2]);// save the end time into the startTime array with the values saved before

                raceTotalTime[k] = Duration.between(startTime[k], endTime[k]); // calculate de total time spend in the race by comparing the start and the end LocalTime

                totalRunnersTimeEntered++; // plus 1 to total times entered in the array
            } else {
                System.out.println("El dorsal " + searchReacerID + " no esta registrado");
            }   

        } while (totalRunnersTimeEntered < MAX_RUNNERS); // do the same process while total time entered is lower than total racers

        for (int i = 0; i < MAX_RUNNERS; i++) {  // for loop to order the array by total time spend in the race descendent
			for (int j = i + 1; j < MAX_RUNNERS; j++) {
				if (raceTotalTime[i].compareTo(raceTotalTime[j]) > 0) {
					totalTimeOrder = raceTotalTime[i];
					raceTotalTime[i] = raceTotalTime[j];
					raceTotalTime[j] = totalTimeOrder;

					endTimeOrder = endTime[i];
					endTime[i] = endTime[j];
					endTime[j] = endTimeOrder;

					starTimeOrder = startTime[i];
					startTime[i] = startTime[j];
					startTime[j] = starTimeOrder;

					runnerNameOrder = runnerName[i];
					runnerName[i] = runnerName[j];
					runnerName[j] = runnerNameOrder;

					runnerIDOrder = runnerID[i];
					runnerID[i] = runnerID[j];
					runnerID[j] = runnerIDOrder;
				}
			}
		}

        for(int i = 0; i < totalRunnersTimeEntered; i++) {
            System.out.println(runnerID[i] + " " + runnerName[i] + " " + endTime[i] + " " + raceTotalTime[i].toHoursPart() + ":" + raceTotalTime[i].toMinutesPart() + ":" + raceTotalTime[i].toSecondsPart());
        }

        input.close();

	}

}

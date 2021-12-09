import java.time.*;
import java.util.Scanner;

public class TimeFunctions {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String[] textLeave = new String[3]; // definim un array de String per el tems de sortida
		String[] textArribal = new String[3]; // definim un array de String per el tems d'arribada
		int[] timeLeave = new int[3]; // array de Integers que ens servirà per poder guardar el valors al LocalTime amb les dades d'arribada
		int[] timeArribal = new int[3]; // array de Integers que ens servirà per poder guardar el valors al LocalTime amb les dades de sortida

		LocalTime houseLeave = LocalTime.of(0, 0, 0); // inicialitzem la variable localtime d'arribada a 0
		LocalTime schoolArribal = LocalTime.of(0, 0, 0); // inicialitzem la variable localtime de sortida a 0
		Duration timeBetweenLeaveArribal = Duration.between(houseLeave, schoolArribal); // variabe que ens servirà per saver el tems que hem trigat des de que em sortit fins que hem arribat

		System.out.println("A que hora has salido de casa? h:m:s"); //ens pregunta a quina hora hem sortit amb el format hora:minuts:segons
		textLeave = input.nextLine().split(":"); // guardem el text introduit al array 'textLeave' separant els valos per ':'

		System.out.println("A que hora has llegado al insti? h:m:s"); //ens pregunta a quina hora hem arribat amb el format hora:minuts:segons
		textArribal = input.nextLine().split(":"); // guardem el text introduit al array 'textArribal' separant els valos per ':'

		for (int i = 0; i < textLeave.length; i++) { // for per tal de guardar els valos de l'array de Strings pasarlos a Integers
			timeLeave[i] = Integer.parseInt(textLeave[i]); // Assignem els valors de l'array textLeave que es un String els pasem a Integer y els assignem al array timeLeave
			timeArribal[i] = Integer.parseInt(textArribal[i]); // Assignem els valors de l'array timeArribal que es un String els pasem a Integer y els assignem al array timeArribal
		}

		houseLeave = LocalTime.of(timeLeave[0], timeLeave[1], timeLeave[2]); // asignem els valors a la variable 'houseLeave' que es un Localtime amb els valors de l'array timeLeave
		schoolArribal = LocalTime.of(timeArribal[0], timeArribal[1], timeArribal[2]);
		timeBetweenLeaveArribal = Duration.between(houseLeave, schoolArribal); // calculem el temps emprat entre el temps de sortida i el d'arribada

		System.out.println("Has tardado: " + timeBetweenLeaveArribal.toHoursPart() + "h " + timeBetweenLeaveArribal.toMinutesPart() + "m " + timeBetweenLeaveArribal.toSecondsPart() + "s");

		input.close();
	}
}

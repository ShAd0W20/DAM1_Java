package biblioteca.estadistica;

// TODO: Auto-generated Javadoc
/**
 * The Class TaulaEnters.
 */
public class TaulaEnters {

	/**
	 * Max taula.
	 *
	 * @param array the array
	 * @return the int
	 */
	public static int maxTaula(int[] array) {
		int max = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	/**
	 * Min taula.
	 *
	 * @param array the array
	 * @return the int
	 */
	public static int minTaula(int[] array) {
		int min = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	/**
	 * Mitjana taula.
	 *
	 * @param array the array
	 * @return the int
	 */
	public static int mitjanaTaula(int[] array) {
		int n = array.length;
		if (n % 2 == 0) {
			return (array[(n / 2) - 1] + array[n / 2]) / 2;
		} else {
			return array[((n + 1) / 2) - 1];
		}
	}
	
	/**
	 * Month number.
	 *
	 * @param mes the mes
	 * @return the int
	 */
	public static int monthNumber(String mes) {
		int monthNumber = 0;
		switch (mes) {
		case "Gener":
			monthNumber = 1;
			break;
		case "Febrer":
			monthNumber = 2;
			break;
		case "Març":
			monthNumber = 3;
			break;
		case "Abril":
			monthNumber = 4;
			break;
		case "Maig":
			monthNumber = 5;
			break;
		case "Juny":
			monthNumber = 6;
			break;
		case "Juliol":
			monthNumber = 7;
			break;
		case "Agost":
			monthNumber = 8;
			break;
		case "Septembre":
			monthNumber = 9;
			break;
		case "Octubre":
			monthNumber = 10;
			break;
		case "Novembre":
			monthNumber = 11;
			break;
		case "Desembre":
			monthNumber = 12;
			break;
		}

		return monthNumber;
	}

}

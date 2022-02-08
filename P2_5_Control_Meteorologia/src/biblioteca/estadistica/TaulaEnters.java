package biblioteca.estadistica;

/**
 * The Class TaulaEnters.
 */
public class TaulaEnters {

	/**
	 * Max taula.
	 *
	 * @param array the array of integers to get the max value
	 * @return the int max value
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
	 * @param array the array of integers to get the min value
	 * @return the int with the minimum value of the array
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
	 * @param array the array of integers to get the median value
	 * @return the int with the value of the median
	 */
	public static int mitjanaTaula(int[] array) {
		int temp = 0;
		int n = array.length;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
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
		switch (mes.toLowerCase()) {
		case "gener":
			monthNumber = 1;
			break;
		case "febrer":
			monthNumber = 2;
			break;
		case "març":
			monthNumber = 3;
			break;
		case "abril":
			monthNumber = 4;
			break;
		case "maig":
			monthNumber = 5;
			break;
		case "juny":
			monthNumber = 6;
			break;
		case "juliol":
			monthNumber = 7;
			break;
		case "agost":
			monthNumber = 8;
			break;
		case "septembre":
			monthNumber = 9;
			break;
		case "octubre":
			monthNumber = 10;
			break;
		case "novembre":
			monthNumber = 11;
			break;
		case "desembre":
			monthNumber = 12;
			break;
		}

		return monthNumber;
	}

}

package biblioteca.estadistica;

public class TaulaEnters {

	public static int maxTaula(int[] array) {
		int max = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static int minTaula(int[] array) {
		int min = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}

	public static int mitjanaTaula(int[] array) {
		int n = array.length;
		if (n % 2 == 0) {
			return (array[n / 2 - 1] + array[n / 2]) / 2;
		} else {
			return array[(n + 1) / 2 - 1];
		}
	}

}

public class CalculateArrays {

	static double calculateMaximum(double[] array) {

		double max = array[0];

		for (int i = 1; i < array.length; i++) {

			if (max < array[i]) {

				max = array[i];

			}

		}

		return max;

	}

	static double calculateMinimum(double[] array) {

		double min = array[0];

		for (int i = 1; i < array.length; i++) {

			if (min > array[i]) {

				min = array[i];

			}

		}

		return min;

	}

	static double calculateAverage(double[] array) {

		double suma = 0;

		for (int i = 0; i < array.length; i++) {

			suma = suma + array[i];

		}

		return suma / array.length;

	}

}
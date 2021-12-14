
public class Functions2 {

	public static void main(String[] args) {
		int[] numbers = { 3000, 2, 2000, 10, 1, -10, 2001, 54, 40, 907, 7, 1024, 0 };
		
		System.out.println(highValueInArray(numbers) + " " + lowerValueInArray(numbers));
		
	}

	static int highValueInArray(int[] array) {
		int hightValue = 0;

		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				if (array[i] > array[i - 1] && hightValue < array[i]) {
					hightValue = array[i];
				}
			} else {
				hightValue = array[i];
			}
		}

		return hightValue;
	}

	static int lowerValueInArray(int[] array) {

		int[] arrayToSort = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			arrayToSort[i] = array[i];
		}
		
		int lowerValue = 0;

		for (int i = 0; i < arrayToSort.length - 1; i++) {

			for (int j = i + 1; j < arrayToSort.length; j++) {

				if (arrayToSort[i] > arrayToSort[j]) {

					lowerValue = arrayToSort[i];

					arrayToSort[i] = arrayToSort[j];

					arrayToSort[j] = lowerValue;
				}
			}
		}

		return arrayToSort[0];
	}
	
	static void printArrayValues(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}

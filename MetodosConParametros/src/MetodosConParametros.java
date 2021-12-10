
public class MetodosConParametros {

	public static void main(String[] args) {
		int[] numbers = new int[4];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		
		System.out.println(numbers[2]);

		//ChangeArrayPositionValue(numbers, 2);
		OneTimeChangeArrayPositionValue(numbers, 2);
		
		System.out.println(numbers[2]);
	}

	/*static void ChangeArrayPositionValue(int[] array, int position) {
		array[position] = 99;
		System.out.println(array[position]);
	}*/
	
	static void OneTimeChangeArrayPositionValue(int[] array, int position) {
		int[] newArray = new int[4];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		
		newArray[position] = 99;
		System.out.println(newArray[position]);
	}
	
	
}

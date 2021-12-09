
public class ArraySort {

	public static void main(String[] args) {

		int[] numbers = new int[10];
		String[] names = new String[10];
		
		numbers[0] = 6; names[0] = "Pol";
		numbers[1] = 4; names[1] = "Marc";
		numbers[2] = 5; names[2] = "Albaro";
		numbers[3] = 7; names[3] = "Irene";
		numbers[4] = 1; names[4] = "Sara";
		numbers[5] = 8; names[5] = "Martita";
		numbers[6] = 9; names[6] = "Maria";
		numbers[7] = 3; names[7] = "Marta";
		numbers[8] = 2; names[8] = "Guille";
		numbers[9] = 0; names[9] = "Alba";
		
		int canvio;
		String canvio2 = "";
		
		System.out.println("\n Ordered by age");

		for (int i = 0; i < names.length - 1; i++) { //Order by age
			
			for (int j = i + 1; j < numbers.length; j++) {
				
				if (numbers[i] > numbers[j]) {
					
					canvio = numbers[i];
					
					numbers[i] = numbers[j];
					
					numbers[j] = canvio;
					
					canvio2 = names[i];
					
					names[i] = names[j];
					
					names[j] = canvio2;
				}	
			}
		}
		
		for(int j = 0; j < names.length; j++) {
			System.out.println(names[j]+ " - " + numbers[j]);
		}
		System.out.println("\n Ordered by name");
		
		for (int i = 0; i < names.length - 1; i++) { //Order by name
			
			for (int j = i + 1; j < numbers.length; j++) {
				
				int compare = names[i].compareTo(names[j]);
				if (compare > 0) {
					canvio = numbers[i];
					
					numbers[i] = numbers[j];
					
					numbers[j] = canvio;
					
					canvio2 = names[i];
					
					names[i] = names[j];
					
					names[j] = canvio2;
				}
			}
		}
		
		for(int j = 0; j < names.length; j++) {
			System.out.println(names[j]+ " - " + numbers[j]);
		}

	}

}

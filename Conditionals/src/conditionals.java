import java.util.Scanner;

public class conditionals {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		String name = "";
		int age = 0;
		char license = 'n';
		String finalSentence = "";
		
		System.out.println("Digue'm el teu nom");
		
		name = input.nextLine();
		
		System.out.println("Quants anys tens?");
		
		age = input.nextInt();
		input.nextLine();
		
		if(age >= 18) {
			System.out.println("Tens carnet de conduir? (s/n)");
			
			license = input.nextLine().charAt(0);
			
			if(license == 's') {
				finalSentence = "i tens carnet de cotxe.";
			} else {
				finalSentence = "i no tens carnet de cotxe.";
			}
			
		}
		
		System.out.println("Et dius " + name + ", tens " + age + " anys " + finalSentence);
	}

}

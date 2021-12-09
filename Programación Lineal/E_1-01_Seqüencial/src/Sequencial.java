import java.util.Scanner;

public class Sequencial {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Diguem les teves dades");
		
		System.out.println("El teu nom: ");
		
		String name = input.nextLine();
		
		
		System.out.println("La teva edat: ");
		
		int age = input.nextInt();
		String menor = "";

		if(age < 18) {
			menor = ", ets menor d'edat";
		} else if (age > 18) {
			menor = ", ets major d'edat";
		} else {
			menor = "";
		}
		
		input.nextLine();
		
		System.out.println("On vius??");
		
		String address = input.nextLine();
		
		System.out.println("Et dius " + name + ", tens " + age + " anys" + menor + " i vius a " + address + ".");

		input.close();

	}

}


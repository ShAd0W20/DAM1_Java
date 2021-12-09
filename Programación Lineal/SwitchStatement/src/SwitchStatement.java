import java.util.Scanner;

public class SwitchStatement {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String rango = "";
		
		System.out.println("Que rango eres?");
		rango = input.nextLine();
		
		input.close();
		
		switch(rango.toLowerCase()) {
			case "capitan":
				System.out.println("Mandas a los tenientes");
				break;
			case "teniente":
				System.out.println("Mandas a los sargentos");
				break;
			case "sargento":
				System.out.println("Mandas a los soldados rasos");
				break;
			case "soldado":
				System.out.println("Eres la primera mierda");
				break;
			default:
				System.out.println("No pintas nada aquí");
		}
	}

}

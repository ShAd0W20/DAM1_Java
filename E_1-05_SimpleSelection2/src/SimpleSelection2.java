import java.util.Scanner;

public class SimpleSelection2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		float productCost = 0.0f;
		float descompte = 0.10f;
		float finalPrice = 0.0f;
		
		System.out.println("Quants diners costa el producte?");
		
		productCost = input.nextFloat();
		input.nextLine();
		
		input.close();
		
		if(productCost >= 100) {
			finalPrice = productCost - (productCost * descompte);
		}
		else {
			finalPrice = productCost;
		}
		
		System.out.println("Has de pagar " + finalPrice + "�");
	}

}

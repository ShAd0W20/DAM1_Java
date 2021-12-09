import java.util.Scanner;

public class MultipleSelection2 {

	public static void main(String[] args) {
		/*Constantes*/
		Scanner input = new Scanner(System.in);
		double Pi = Math.PI; /*Constante PI para calcular radio*/
		int precioAgua = 25; /*Precio por metro cubico*/

		int tipoPiscina = 0; /*1: redonda; 2: rectangular; 3: triangular;*/
		double profundidadPiscina = 0.0;
		double volumenMetrosCubicosPiscina = 0.0;
		
		/*Piscina redonda*/
		double diametroPiscina = 0.0;
		
		/*Piscina rectangular*/
		double ladoLargoPiscina = 0.0;
		double ladoCortoPiscina = 0.0;

		/*Piscina triangular*/
		double basePiscina = 0.0;
		double alturaPiscina = 0.0;
		
		
		
		System.out.println("Di la profundidad maxima de la piscina");
		
		profundidadPiscina = input.nextDouble();
		input.nextLine();
		
		System.out.println("Que tipo de piscina desea: \n 1: Redonda \n 2: Rectangular \n 3: Triangular");
		
		tipoPiscina = input.nextInt();
		input.nextLine();
		
		switch (tipoPiscina) {
			case 1:
				System.out.println("Introduce el diametro de la piscina");
				diametroPiscina = input.nextDouble();
				input.nextLine();				

				double radioPiscina = diametroPiscina/2;
				
				volumenMetrosCubicosPiscina = Pi*(Math.pow(radioPiscina, 2))*profundidadPiscina;
				
				break;
			case 2:
				System.out.println("Medida lado largo de la piscina");
				ladoLargoPiscina = input.nextDouble();
				input.nextLine();
				
				System.out.println("Medida lado corto de la piscina");
				ladoCortoPiscina = input.nextDouble();
				input.nextLine();
				
				volumenMetrosCubicosPiscina = ladoLargoPiscina*ladoCortoPiscina*profundidadPiscina;
				
				break;
			case 3:
				System.out.println("Medida de la base del triangulo");
				basePiscina = input.nextDouble();
				input.nextLine();
				
				System.out.println("Medida de la altura del triangulo");
				alturaPiscina = input.nextDouble();
				input.nextLine();
				
				volumenMetrosCubicosPiscina = ((basePiscina*alturaPiscina)/2)*profundidadPiscina;
				
				break;
			default:
				System.out.println("No disponemos del tipo de piscina introducido");
		}
		
		input.close();

		System.out.println("Para llenar la piscina necesitaras " + volumenMetrosCubicosPiscina + " litros de agua que tienen un precio de " + precioAgua*volumenMetrosCubicosPiscina + " Euros.");
		
	}

}

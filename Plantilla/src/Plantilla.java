import java.util.Scanner;

public class Plantilla {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int numCasos;
		numCasos = in.nextInt();
		for(int i = 0; i < numCasos; i++) {
			casoDePrueba();
		}
	}
	
	static void casoDePrueba() {
		int potecia = in.nextInt();
		int factor = in.nextInt();
		int tiempo = in.nextInt();
		
		System.out.println((tiempo % (potecia + 1)) * factor);
	}
}

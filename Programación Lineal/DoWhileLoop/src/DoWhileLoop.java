import java.util.Scanner;

public class DoWhileLoop {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] alumnos = new String[10];
		String nombreIntroducido = "";
		int numTotalAlumnos = 0;
		
		do {
			if(numTotalAlumnos < 10) {
				System.out.println("Introduce el nombre del alumno");
				nombreIntroducido = input.nextLine();
				if(!nombreIntroducido.equals("salir")) {
					alumnos[numTotalAlumnos] = nombreIntroducido;
					numTotalAlumnos++;
				}
			} else {
				nombreIntroducido = "salir";
			}
			
		} while (!nombreIntroducido.toLowerCase().equals("salir"));
		
		for(int j = 0; j < numTotalAlumnos; j++) {			
			System.out.println(alumnos[j]);	
		}
		
		input.close();
	}

}

import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int nAlumnos = 0;
		String nombre = "";
		String[] alumnos = new String[5];
		int[] notas = new int[5];

		System.out.println("Introduce el nombre del alumno (salir para acabar) ª");
		nombre = input.nextLine();
		
		while (!nombre.toLowerCase().equals("salir") && (nAlumnos < 5)) {		
			alumnos[nAlumnos] = nombre;
			System.out.println("Introduce el nombre del alumno (salir para acabar)");
			nombre = input.nextLine();
			nAlumnos += 1;
		}
		
		for(int i = 0; i < nAlumnos; i++) {
			System.out.println("Introduce la nota de: " + alumnos[i]);
			notas[i] = input.nextInt();
			input.nextLine();
		}
		
		input.close();
		for(String j : alumnos){
			if(j != null) {
				System.out.println(j);
			}
		}
		for(int n : notas){
			if(n != 0) {
				System.out.println(n);
			}
		}
		System.out.println("Has salido del programa");
	}

}

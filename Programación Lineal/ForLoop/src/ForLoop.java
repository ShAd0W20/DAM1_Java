import java.util.Scanner;

public class ForLoop {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		/*
		for (int i = 0; i < 10; i++) {
			System.out.println("Good morning");
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Good night " + i);
		}
		

		System.out.println("Escribe 3 nombres");
		String name = "";
		String frase = "";
		
		for (int i = 1; i < 4; i++) {
			name = input.nextLine();
			frase += "Alumno " + i + ": " + name + "\n";
		}
		
		System.out.println(frase);
		
		
		String[] names = new String[3];
		
		System.out.println("Escribe 3 nombres");
		
		for (int i = 0; i < 3; i++) {
			names[i] = input.nextLine();
		}
		
		for(int i = 0; i < names.length; i++) {
			System.out.println("Alumno " + (i + 1) + ": " + names[i]);
		}

		
		String[] numbers = new String[5];
		
		numbers[0] = "a";
		numbers[1] = "b";
		
		for(String j : numbers) {
			System.out.println(j);
		}
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		String[] alumnos = {"A1", "A2", "A3", "A4", "A5"};
		double[] notas = new double[5];
		double media = 0.0;
		
		System.out.println("Introduce las notas de los alumnos");
		
		for (int i = 0; i < alumnos.length; i++) {
			notas[i] = input.nextDouble();
		}
		
		for (int i = 0; i < alumnos.length; i++) {
			System.out.println(alumnos[i] + ", nota: " + notas[i]);
		}
		
		for (int i = 0; i < notas.length; i++) {
			media += notas[i];
		}
		System.out.println("La media de las notas es: " + media/notas.length);*/
		
		int alumnos = 0;
		String[] alumName = new String[10];
		int[] notAlumno = new int[10];
		
		
		for(int x = 0; x < 2; x++) {			
					
			System.out.print("Cuantos alumnos quieres entrar? (Max 10)");
			int nAlumnos = input.nextInt();
			input.nextLine();
			
			int totalAlum = alumnos + nAlumnos;
			
			if(totalAlum > 10) {
				System.out.println("Demasiados alumnos introducidos");
				break;
			}
			
			System.out.println("Entra los nombres de los alumnos");			
			for(int l = alumnos; l < (totalAlum); l++) {
				alumName[l] = input.nextLine();
			}
			
			System.out.println("Entra sus notas por orden");
			for(int j = alumnos; j < (totalAlum); j++) {
				notAlumno[j] = input.nextInt();
			}			

			alumnos += nAlumnos;
			
		}
		for(int k = 0; k < alumnos; k++) {
			System.out.println(alumName[k] + " - " + notAlumno[k]);
		}
		
		
		
		input.close();

	}

}

import java.util.Scanner;

public class Examen1_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] alumnos = {"Pepe", "Manolo", "Irene", "Alvaro", "Maria"};
		int[] notasAlumnos = new int[5];
		
		String notaLiteral = "";
		
		String canvio = "";
		int canvio2 = 0;
		
		for(int i = 0; i < alumnos.length; i++) {
			System.out.println("Introduce la nota para: " + alumnos[i]);
			notasAlumnos[i] = input.nextInt();
			input.nextLine();
		}		
		
		for (int i = 0; i < alumnos.length - 1; i++) {
			
			for (int j = i + 1; j < notasAlumnos.length; j++) {
				
				if (notasAlumnos[i] < notasAlumnos[j]) {
					
					canvio = alumnos[i];
					
					alumnos[i] = alumnos[j];
					
					alumnos[j] = canvio;
					
					canvio2 = notasAlumnos[i];
					
					notasAlumnos[i] = notasAlumnos[j];
					
					notasAlumnos[j] = canvio2;
					
				}	
			}
		}
		
		System.out.println("Assoleixen el modul");
		for(int j = 0; j < alumnos.length; j++) {				
			if(notasAlumnos[j] >= 5) {
				if(notasAlumnos[j] < 7) {
					notaLiteral = "Aprovat";
				} else if (notasAlumnos[j] < 9) {
					notaLiteral = "Notable";					
				} else if (notasAlumnos[j] >= 9) {
					notaLiteral = "Excel·lent";
				}
				System.out.println(alumnos[j] + " " + notasAlumnos[j] + " " + notaLiteral);
			}
		}
		
		System.out.println("\n No assoleixen el modul");
		for(int j = 0; j < alumnos.length; j++) {				
			if(notasAlumnos[j] < 5) {
				notaLiteral = "Suspes";
				System.out.println(alumnos[j] + " " + notasAlumnos[j] + " " + notaLiteral);
			}
		}
		
		input.close();
	}

}

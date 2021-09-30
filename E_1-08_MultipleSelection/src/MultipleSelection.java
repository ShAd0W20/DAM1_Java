import java.util.Scanner;

public class MultipleSelection {

	public static void main(String[] args) {
		/*
		 Feu un programa que us pregunti quina nota num�rica heu tret en el m�dul i us digui la nota literal que us correspon.

                    De 0 a 4 -> Susp�s
                    De 5 a 6 -> Aprovat
                    De 7 a 8 -> Notable
                    De 9 a 10 -> Excel�lent

		El programa demana la nota del m�dul per teclat
		
		                    notaModul
		
		El programa escriu per pantalla:
		
		Has tret una nota de [notaModul] que es correspon amb un [notaLiteralModul].
		
		*/
		
		Scanner input = new Scanner(System.in);
		
		int nota = 0;
		
		System.out.println("Quina nota has tret al m�dul?");
		
		nota = input.nextInt();
		input.nextLine();
		
		input.close();
		
		if(nota < 5) {
			System.out.println("Has tret una nota de " + nota + " que correspon amb un susp�s");
		} else if (nota < 7) {
			System.out.println("Has tret una nota de " + nota + " que correspon amb un aprobat");
		} else if (nota < 9) {
			System.out.println("Has tret una nota de " + nota + " que correspon amb un notable");
		} else if (nota < 11) {
			System.out.println("Has tret una nota de " + nota + " que correspon amb un Excel�lent");
		} else {
			System.out.println("El valot introuit no es v�lid");
		}

	}

}

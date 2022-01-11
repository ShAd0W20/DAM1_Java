public class RegisterGrades {

	public static void main(String[] args) {

		double[] notes = { 2.0, 5.5, 7.25, 3.0, 9.5, 8.25, 7.0, 7.5 };

		double max = CalculateArrays.calculateMaximum(notes);

		double min = CalculateArrays.calculateMinimum(notes);

		double mitjana = CalculateArrays.calculateAverage(notes);

		System.out.println("La nota maxima es " + max + ".");

		System.out.println("La nota minima es " + min + ".");

		System.out.println("La media de las notas es " + mitjana + ".");

	}

}
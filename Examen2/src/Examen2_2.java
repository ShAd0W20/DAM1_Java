
public class Examen2_2 {

	public static void main(String[] args) {
		String[] studentNames = new String[5];
		int[] studentFailedGrades = new int[5];
		int[][] studentGrades = new int[5][3];

		String[] gradeNames = { "Programacio", "BBDD", "Entorns" };

		studentNames[0] = "Irene"; studentGrades[0][0] = 5; studentGrades[0][1] = 8; studentGrades[0][2] = 7;
		studentNames[1] = "Guille"; studentGrades[1][0] = 9; studentGrades[1][1] = 8; studentGrades[1][2] = 6;
		studentNames[2] = "Maria"; studentGrades[2][0] = 7; studentGrades[2][1] = 4; studentGrades[2][2] = 5;
		studentNames[3] = "Pol"; studentGrades[3][0] = 3; studentGrades[3][1] = 5; studentGrades[3][2] = 2;
		studentNames[4] = "Joan"; studentGrades[4][0] = 1; studentGrades[4][1] = 9; studentGrades[4][2] = 8;
		
		int studentGradeToSort = 0;
		String studentNameToSort = "";

		for (int k = 0; k < gradeNames.length; k++) {
			for (int i = 0; i < studentNames.length - 1; i++) {

				for (int j = i + 1; j < studentNames.length; j++) {

					if (studentGrades[i][k] < studentGrades[j][k]) {

						studentNameToSort = studentNames[i];

						studentNames[i] = studentNames[j];

						studentNames[j] = studentNameToSort;

						studentGradeToSort = studentGrades[i][0];

						studentGrades[i][0] = studentGrades[j][0];

						studentGrades[j][0] = studentGradeToSort;

						studentGradeToSort = studentGrades[i][1];

						studentGrades[i][1] = studentGrades[j][1];

						studentGrades[j][1] = studentGradeToSort;

						studentGradeToSort = studentGrades[i][2];

						studentGrades[i][2] = studentGrades[j][2];

						studentGrades[j][2] = studentGradeToSort;
					}
				}
			}
			System.out.println("\n" + gradeNames[k]);
			for (int j = 0; j < studentNames.length; j++) {
				System.out.println(studentNames[j] + " " + studentGrades[j][k]);
			}
		}
		
		System.out.println("\n NOTAS");
		
		for (int i = 0; i < studentNames.length; i++) {
			for (int j = 0; j < 3; j++) {
				if(studentGrades[i][j] < 5) {
					studentFailedGrades[i]++;
				}
			}
			if(studentFailedGrades[i] == 0) {
				System.out.println(studentNames[i] + " TOT APROVAT");
			} else {
				System.out.println(studentNames[i] + " ha suspes: " + studentFailedGrades[i] + " UF");
			}
		}
	}

}

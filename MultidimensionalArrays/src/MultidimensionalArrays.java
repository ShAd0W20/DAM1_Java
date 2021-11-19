
public class MultidimensionalArrays {

	public static void main(String[] args) {
		final int totalStudents = 8;
		final int totalSubjects = 4;

		String[][] studentGrades = new String[totalStudents][totalSubjects];
		
		String[] gradeNames = {"M1", "M2", "M3", ""};
		
		studentGrades[0][0] = "Pepe"; studentGrades[0][1] = "7"; studentGrades[0][2] = "6"; studentGrades[0][3] = "9";
		studentGrades[1][0] = "Maria"; studentGrades[1][1] = "7"; studentGrades[1][2] = "6"; studentGrades[1][3] = "9";
		studentGrades[2][0] = "Irene"; studentGrades[2][1] = "7"; studentGrades[2][2] = "6"; studentGrades[2][3] = "9";
		studentGrades[3][0] = "Guille"; studentGrades[3][1] = "7"; studentGrades[3][2] = "6"; studentGrades[3][3] = "9";
		studentGrades[4][0] = "Pol"; studentGrades[4][1] = "7"; studentGrades[4][2] = "6"; studentGrades[4][3] = "9";
		studentGrades[5][0] = "Richard"; studentGrades[5][1] = "7"; studentGrades[5][2] = "6"; studentGrades[5][3] = "9";
		studentGrades[6][0] = "Fran"; studentGrades[6][1] = "7"; studentGrades[6][2] = "6"; studentGrades[6][3] = "9";
		studentGrades[7][0] = "David"; studentGrades[7][1] = "7"; studentGrades[7][2] = "6"; studentGrades[7][3] = "9";
		
		for (int i = 0; i < totalStudents; i++) {
			for (int j = 0; j < totalSubjects; j++) {
				System.out.print(studentGrades[i][j] + " " + gradeNames[j] + " -> ");
			}
			System.out.println();
		}
	}

}

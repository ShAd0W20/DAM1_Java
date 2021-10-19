import java.util.Scanner;

public class ArrayModification {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[] userNames = new String[10];
		int[] userAges = new int[10];
		
		int totalUsers = 7;
		int arrayIndexToDelete = 0;
		
		String userSearch = "";
		
		userNames[0] = "a";	userAges[0] = 5;		
		userNames[1] = "b";	userAges[1] = 6;
		userNames[2] = "c";	userAges[2] = 7;
		userNames[3] = "d";	userAges[3] = 8;
		userNames[4] = "e";	userAges[4] = 9;
		userNames[5] = "f";	userAges[5] = 10;
		userNames[6] = "g";	userAges[6] = 11;
		
		System.out.println("Que usuario desea borrar?");
		
		userSearch = input.nextLine();
		
		while(!userSearch.toLowerCase().equals(userNames[arrayIndexToDelete]) && arrayIndexToDelete < totalUsers) {
			arrayIndexToDelete++;
		}
		
		if(userSearch.toLowerCase().equals(userNames[arrayIndexToDelete])) {
			for(int i = arrayIndexToDelete; i < totalUsers - 1; i++) {
				userNames[i] = userNames[i+1];
				userAges[i] = userAges[i+1];
			}			
			totalUsers--;
		}
		
		for(int j = 0; j < totalUsers; j++) {
			System.out.println(userNames[j] + " " + userAges[j]);
		}
		
		input.close();
	}

}
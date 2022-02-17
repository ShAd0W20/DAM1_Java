package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException {
		final int MAX_IN_MARATHON = 10;
		String[] userName = new String[MAX_IN_MARATHON];
		int[] usersBib = new int[MAX_IN_MARATHON];
		char[] userSex  = new char[MAX_IN_MARATHON];
		LocalDate[] userBirhtDate = new LocalDate[MAX_IN_MARATHON];
		String[] userCategory = new String[MAX_IN_MARATHON];
		
		int totalUsers = 0;
		
		File fileToSave = new File("runners.txt");
		Scanner fileInput = new Scanner(fileToSave);
		totalUsers = fileInput.nextInt();
		fileInput.nextLine();
		fileInput.close();
		getDataFromFile(fileToSave, userName, usersBib, userSex, userBirhtDate, userCategory, totalUsers);
		displayUsers(userName, usersBib, userSex, userBirhtDate, userCategory, totalUsers);
		registerUser(userName, usersBib, userSex, userBirhtDate, userCategory, totalUsers);
		totalUsers++;
		displayUsers(userName, usersBib, userSex, userBirhtDate, userCategory, totalUsers);
		saveDataToFile(userName, usersBib, userSex, userBirhtDate, userCategory, totalUsers, fileToSave);
	}
	
	static void getDataFromFile(File fileToSave, String[] userName, int[] userBib, char[] userSex, LocalDate[] userBirhtDate, String[] userCategory, int totalUsers) throws FileNotFoundException {
		Scanner fileInput = new Scanner(fileToSave);
		totalUsers = fileInput.nextInt();
		fileInput.nextLine();
		for (int i = 0; i < totalUsers; i++) {
			userName[i] = fileInput.next();
			userBib[i] = fileInput.nextInt();
			userSex[i] = fileInput.next().charAt(0);
			userBirhtDate[i] = LocalDate.parse(fileInput.next());
			userCategory[i] = fileInput.next();
			fileInput.nextLine();
		}
		fileInput.close();
	}
	
	static void displayUsers(String[] userName, int[] userBib, char[] userSex, LocalDate[] userBirhtDate, String[] userCategory, int totalUsers) {
		for (int i = 0; i < totalUsers; i++) {
			System.out.println("[+] " + userName[i] + " " + " " + userSex[i] + " " + userBirhtDate[i].format(DateTimeFormatter.ofPattern("d/M/Y")) + " " + userCategory[i]);
		}
	}
	
	static void registerUser(String[] userName, int[] usersBib, char[] userSex, LocalDate[] userBirhtDate, String[] userCategory, int totalUsers) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Introduc el nombre del corredor");
		userName[totalUsers] = userInput.nextLine();
		
		usersBib[totalUsers] = getUserBib(usersBib, totalUsers);
		
		System.out.println("Introduc el sexo del corredor");
		userSex[totalUsers] = userInput.nextLine().charAt(0);
		
		System.out.println("Introduc la fecha de nacimiento del corredor -> dd/mm/aa");
		userBirhtDate[totalUsers] = LocalDate.parse(userInput.nextLine(), DateTimeFormatter.ofPattern("d/M/y"));
		
		userCategory[totalUsers] = getUserCategory(userBirhtDate[totalUsers]);
		totalUsers = totalUsers + 1;
		userInput.close();		
	}
	
	static int getUserBib(int[] usersBib, int totalUsers) {
		Random rnd = new Random();
		int userBib = rnd.nextInt(100) + 1;
		while(isUserBibRegistered(userBib, usersBib, totalUsers)) {
			userBib = rnd.nextInt(100) + 1;
		}
		
		return userBib;
	}
	
	static String getUserCategory(LocalDate userBirthDay) {
		if(userBirthDay.isBefore(LocalDate.of(1969, 12, 31))) {
			return "Vetera";
		}
		return "Absolut";
	}
	
	static boolean isUserBibRegistered(int userBib, int[] usersBib, int totalUsers) {
		for (int i = 0; i < totalUsers; i++) {
			if(userBib == usersBib[i]) {
				return true;
			}
		}
		return false;
	}
	
	static void saveDataToFile(String[] userName, int[] usersBib, char[] userSex, LocalDate[] userBirhtDate, String[] userCategory, int totalUsers, File fileToSave) throws FileNotFoundException {
		PrintStream output = new PrintStream(fileToSave);
		output.println(totalUsers);
		for (int i = 0; i < totalUsers; i++) {
			output.println(userName[i] + " " + usersBib[i] + " " + userSex[i] + " " + userBirhtDate[i] + " " + userCategory[i]);
		}
		
		output.close();
	}

	
}

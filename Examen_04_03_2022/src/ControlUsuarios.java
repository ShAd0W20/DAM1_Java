import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ControlUsuarios {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Users.txt");
		Scanner input = new Scanner(System.in);

		String mainMenuOption = "";
		
		String[][] users = getDataFromFile(file);
		
		for(int i = 0; i < users.length; i++) {
			for(int j = 0; j < users[i].length; j++) {
				System.out.print(users[i][j] + "/");
			}
			System.out.println();
		}
		
		System.out.printf("Que desea hacer? %n[1] Validar usuario %n[2] Registrar usuario%n");
		mainMenuOption = input.nextLine();
		
		switch (mainMenuOption) {
		case "1":
			validateUser(users);
			break;
		case "2":
			registerUser(users);
			break;
		}
		
		saveDataToFile(file, users);
		
	}
	
	static String[][] getDataFromFile(File file) throws FileNotFoundException {
		String[][] users = new String[10][3];
		try (Scanner fileData = new Scanner(file)) {
			int i = 0;
			while(fileData.hasNextLine()) {
				users[i] = fileData.nextLine().split(",");
				i++;
			}
		}
		
		return users;
	}
	
	static void saveDataToFile(File file, String[][] users) throws FileNotFoundException {
		PrintStream output = new PrintStream(file);
		for(int i = 0; i < users.length; i++) {
			if(users[i][0] != null) {
				output.printf("%s,%s,%s%n", users[i][0], users[i][1], users[i][2]);
			}
		}
		output.close();
	}
	
	static void validateUser(String[][] users) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		String userName = "";
		String password = "";
		
		System.out.println("Introduce el nombre de usuario");
		userName = input.nextLine();
		
		try {
			int i = 0;
			while(!users[i][0].equals(userName) && i < users.length) {
				i++;
			}
			System.out.println("Introduce la contraseña");
			password = input.nextLine();
			
			if(!password.equals(users[i][2])) {
				System.out.println("Contraseña incorrecta");
				return;
			}
			
			System.out.println("Bienvenido " + users[i][1]);
		} catch (Exception e) {
			System.out.println("Usuario no registrado");
		};
	}
	
	static void registerUser(String[][] users) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		String userName = "";
		String fullUserName = "";
		String password = "";
		String repeatPasasword = "";
		
		System.out.println("Introduce el nombre de usuario");
		userName = input.nextLine();
		
		System.out.println("Introduce tu nombre completo");
		fullUserName = input.nextLine();
		
		System.out.println("Introduce la contraseña");
		password = input.nextLine();
		
		do {
			System.out.println("Confirma la contraseña");
			repeatPasasword = input.nextLine();
		} while(!repeatPasasword.equals(password));
		
		input.close();
		
		int i = 0;
		while(users[i][0] != null && i < users.length) {
			i++;
		}
		
		users[i][0] = userName;
		users[i][1] = fullUserName;
		users[i][2] = password;
	}

}

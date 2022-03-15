package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.Scanner;

import models.User;

public class UserManagement {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("users.bin");
		Scanner input = new Scanner(System.in);
		String mainMenuOption = "";

		System.out.printf(
				"Que desea hacer? %n[1] Registrar usuario %n[2] Borrar usuario %n[3] Dar libro %n[4] Retirar libro %n[Salir] para salir %n");
		do {
			mainMenuOption = input.nextLine();
			switch (mainMenuOption) {
			case "1":
				registerUser(file, input);
				break;
			case "2":
				deleteUser(file, input);
				break;
			case "3":
				giveBookToUser(file, input);
				break;
			case "4":
				removeBookToUser(file, input);
				break;
			default:
				if (!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.printf(
							"Que desea hacer? %n[1] Registrar usuario %n[2] Borrar usuario %n[3] Dar libro %n[4] Retirar libro %n[Salir] para salir %n");
				}
			}
		} while (!mainMenuOption.equalsIgnoreCase("salir"));

		input.close();
		System.out.printf("%n%n[!] Saliendo... %n");
	}

	private static void removeBookToUser(File file, Scanner input) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		String userIDToSearch = "";
		String bookToRemove = "";
		boolean userExists = false;

		System.out.println("Introduce el DNI del usuario a buscar");

		userIDToSearch = input.nextLine();

		while (raf.getFilePointer() < file.length()) {
			raf.readBoolean();
			String userID = raf.readUTF();

			if (userID.trim().equals(userIDToSearch)) {
				userExists = true;
				raf.readUTF();
				String userBook = raf.readUTF();
				if(!userBook.trim().equals("")) {
					bookToRemove = "cap";
					if (bookToRemove.length() < 40) {
						bookToRemove = String.format("%-40s", bookToRemove);
					} else {
						bookToRemove = bookToRemove.substring(0, 39);
					}
					raf.seek(raf.getFilePointer() - 42);
					raf.writeUTF(bookToRemove);					
				} else {
					System.out.println("Este usuario no tiene ningun libro");
				}
			} else {
				userExists = false;
				raf.skipBytes(64);
			}
		}
		
		if(!userExists) {
			System.out.println("El usuario no existe");
		}
		
		exportToCSV(file);
		
		System.out.println("\nPulse enter para volver al menu");
		raf.close();
	}
	
	private static void giveBookToUser(File file, Scanner input) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		String userIDToSearch = "";
		String bookToGive = "";
		boolean userExists = false;

		System.out.println("Introduce el DNI del usuario a buscar");

		userIDToSearch = input.nextLine();

		while (raf.getFilePointer() < file.length()) {
			raf.readBoolean();
			String userID = raf.readUTF();

			if (userID.trim().equals(userIDToSearch)) {
				userExists = true;
				raf.readUTF();
				String userBook = raf.readUTF();
				if(!userBook.trim().equals("")) {
					System.out.println("Introduce el libro a dejar");
					bookToGive = input.nextLine();
					if (bookToGive.length() < 40) {
						bookToGive = String.format("%-40s", bookToGive);
					} else {
						bookToGive = bookToGive.substring(0, 39);
					}
					raf.seek(raf.getFilePointer() - 42);
					raf.writeUTF(bookToGive);					
				} else {
					System.out.println("Este usuario ya tiene el libro " + userBook);
				}
			} else {
				userExists = false;
				raf.skipBytes(64);
			}
		}
		
		if(!userExists) {
			System.out.println("El usuario no existe");
		}
		
		listAllUserBooks(file);
		
		System.out.println("\nPulse enter para volver al menu");
		raf.close();
	}

	private static void deleteUser(File file, Scanner input) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		String userIDToSearch = "";

		System.out.println("Introduce el DNI del usuario a eliminar");

		userIDToSearch = input.nextLine();
		boolean isUserDeleted = false;

		while (raf.getFilePointer() < file.length()) {
			raf.readBoolean();
			String userID = raf.readUTF();

			if (userID.trim().equals(userIDToSearch)) {
				raf.seek(raf.getFilePointer() - 12);
				raf.writeBoolean(true);
				raf.skipBytes(75);
				isUserDeleted = true;
			} else {
				raf.skipBytes(64);
			}
		}

		if (isUserDeleted) {
			System.out.printf("%Usuario eliminado%n");
		} else {
			System.out.printf("%Usuario no encontrado%n");
		}

		System.out.println("\nPulse enter para volver al menu");
		raf.close();
		exportToCSV(file);

	}

	private static void registerUser(File file, Scanner input) throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		User user = new User();

		System.out.println("Introduce el DNI del usuario");
		String dni = input.nextLine();
		if (dni.length() < 9) {
			user.userDNI = String.format("%-11s", dni);
		} else {
			user.userDNI = dni.substring(0, 8);
		}

		System.out.println("Introduce el nombre del usuario");
		String userName = input.nextLine();
		if (dni.length() < 20) {
			user.userName = String.format("%-20s", userName);
		} else {
			user.userName = dni.substring(0, 19);
		}

		System.out.println("Introduce el nombre del libro en credito");
		String bookName = input.nextLine();
		if (bookName.length() < 40) {
			user.bookName = String.format("%-40s", bookName);
		} else {
			user.bookName = dni.substring(0, 39);
		}

		raf.writeBoolean(user.isDeleted);
		raf.writeUTF(user.userDNI);
		raf.writeUTF(user.userName);
		raf.writeUTF(user.bookName);

		raf.close();
		listAllUsers(file);

		System.out.println("Pulse enter para volver al menu");
	}

	private static void listAllUsers(File file) throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "r");

		while (raf.getFilePointer() < file.length()) {
			User user = new User();
			user.isDeleted = raf.readBoolean();
			user.userDNI = raf.readUTF().trim();
			user.userName = raf.readUTF().trim();
			user.bookName = raf.readUTF().trim();

			if (!user.isDeleted) {
				System.out.printf("%s - %s %n", user.userName, user.userDNI);
			}
		}

		raf.close();
	}
	
	private static void listAllUserBooks(File file) throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "r");

		while (raf.getFilePointer() < file.length()) {
			User user = new User();
			user.isDeleted = raf.readBoolean();
			user.userDNI = raf.readUTF().trim();
			user.userName = raf.readUTF().trim();
			user.bookName = raf.readUTF().trim();

			if (!user.isDeleted) {
				System.out.printf("%s -> %s - %s %n", user.bookName, user.userName, user.userDNI);
			}
		}

		raf.close();
	}

	private static void exportToCSV(File file) throws FileNotFoundException, IOException {
		File csv = new File("Users.csv");
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		PrintStream stream = new PrintStream(csv);
		stream.printf("\"%s\";\"%s\"%n", "User DNI", "User Name");
		while (raf.getFilePointer() < file.length()) {
			User user = new User();
			user.isDeleted = raf.readBoolean();
			user.userDNI = raf.readUTF();
			user.userName = raf.readUTF();
			user.bookName = raf.readUTF();
			stream.printf("\"%s\";\"%s\"%n", user.userDNI.trim(), user.userName.trim());
		}

		stream.close();
		raf.close();
	}
}

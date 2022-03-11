package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.Scanner;

import models.Book;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("books.bin");
		Scanner input = new Scanner(System.in);
		String mainMenuOption = "";

		System.out.printf(
				"Que desea hacer? %n[1] Registrar libro %n[2] Borrar libro %n[3] Listar libros %n[4] Purgar fichero de libros %n[Salir] para salir %n");
		do {
			mainMenuOption = input.nextLine();
			switch (mainMenuOption) {
			case "1":
				registerNewBook(file, input);
				break;
			case "2":
				deleteBook(file, input);
				break;
			case "3":
				listAllBooks(file);
				break;
			case "4":
				purge();
				break;
			default:
				if (!mainMenuOption.equalsIgnoreCase("salir")) {
					System.out.printf(
							"Que desea hacer? %n[1] Registrar libro %n[2] Borrar libro %n[3] Listar libros %n[4] Purgar fichero de libros %n[Salir] para salir %n");
				}
			}
		} while (!mainMenuOption.equalsIgnoreCase("salir"));
		
		input.close();
		System.out.printf("%n%n[!] Saliendo... %n");
	}
	
	private static void listAllBooks(File file) throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		String[] genres = {"Novela", "Poesia", "Miedo"};
		
		while(raf.getFilePointer() < file.length()) {
			Book book = new Book();
			book.isDeleted = raf.readBoolean();
			book.bookID = raf.readInt();
			book.bookTitle = raf.readUTF();
			book.bookAuthor = raf.readUTF();
			book.bookGenre = raf.readChar();
			
			if(!book.isDeleted) {
				System.out.printf("%d %s %s %s %n", book.bookID, book.bookTitle.trim(), book.bookAuthor.trim(),	book.bookGenre);
			}
		}
		
		raf.close();
	}
	
	static void purge() throws FileNotFoundException, IOException {
		File file = new File("books.bin");
		RandomAccessFile readRaf = new RandomAccessFile(file, "r");
		RandomAccessFile writeRaf = new RandomAccessFile(file, "rw");
		boolean isDeleted = false;
		
		while(readRaf.getFilePointer() < file.length()) {
			isDeleted = readRaf.readBoolean();
			
			if(!isDeleted) {
				writeRaf.writeBoolean(false);				
				writeRaf.writeInt(readRaf.readInt());
				writeRaf.writeUTF(readRaf.readUTF());
				writeRaf.writeUTF(readRaf.readUTF());
				writeRaf.writeChar(readRaf.readChar());
			} else {
				readRaf.skipBytes(70);
			}
		}
		writeRaf.setLength(writeRaf.getFilePointer());
		
		readRaf.close();
		writeRaf.close();
		
		System.out.println("Pulse enter para volver al menu");
	}

	private static void deleteBook(File file, Scanner input) throws FileNotFoundException, IOException {
		int bookCodeToSearch = 0;
		RandomAccessFile raf = new RandomAccessFile(file, "rw");

		System.out.println("Introduce el codigo del libro a eliminar");

		do {
			bookCodeToSearch = input.nextInt();
			input.nextLine();
			if (bookCodeToSearch != 0) {
				while (raf.getFilePointer() < file.length()) {
					raf.readBoolean();
					int bookCode = raf.readInt();

					if (bookCode == bookCodeToSearch) {
						raf.seek(raf.getFilePointer() - 5);
						raf.writeBoolean(true);
						System.out.printf("%nLibro eliminado%n");
						raf.skipBytes(70);
					} else {
						raf.skipBytes(66);
					}
				}
				System.out.println("Introduce el codigo del libro a eliminar");
			}

		} while (bookCodeToSearch != 0);
		
		System.out.println("Pulse enter para volver al menu");

		raf.close();
	}

	static void registerNewBook(File file, Scanner input) throws FileNotFoundException, IOException {
		File intentoryFile = new File("inventari_" + LocalDate.now() + ".txt");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		Book book = null;
		do {
			book = new Book();

			System.out.println("Introduce el codigo del libro | 0 para salir");
			book.bookID = input.nextInt();
			input.nextLine();
			if (book.bookID != 0) {
				System.out.println("Introduce el titulo del libro");
				String title = input.nextLine();
				if (title.length() < 40) {
					book.bookTitle = String.format("%-40s", title);
				} else {
					book.bookTitle = title.substring(0, 39);
				}

				System.out.println("Introduce el autor de libro");
				String author = input.nextLine();
				if (author.length() < 20) {
					book.bookAuthor = String.format("%-20s", author);
				} else {
					book.bookAuthor = author.substring(0, 19);
				}

				System.out.println("Introduce el genero del libo (Novela, Poesia, Misteri)");
				book.bookGenre = input.nextLine().charAt(0);

				while (!validateBookGenre(book.bookGenre)) {
					System.out.println("Introduce el genero del libo (Novela, Poesia, Misteri)");
					book.bookGenre = input.nextLine().charAt(0);
				}

				raf.seek(file.length());
				
				raf.writeBoolean(book.isDeleted);
				raf.writeInt(book.bookID);
				raf.writeUTF(book.bookTitle);
				raf.writeUTF(book.bookAuthor);
				raf.writeChar(book.bookGenre);
				
				raf.seek(0);
				
				int i = 0;
				while (raf.getFilePointer() < file.length()) {
					i++;
				}

				System.out.printf("%d %s %s %s %n", book.bookID, book.bookTitle.trim(), book.bookAuthor.trim(),	book.bookGenre);
				System.out.println("Actualmente tienes [" + i + "] libros en la biblioteca \n");

				PrintStream fileInput = new PrintStream(intentoryFile);
				fileInput.printf("%d %s %s %s %n", book.bookID, book.bookTitle.trim().replace(" ", "_"), book.bookAuthor.trim().replace(" ", "_"), book.bookGenre);
				fileInput.close();

			} else {
				System.out.println("Pulse enter para volver al menu");
			}

		} while (book.bookID != 0);

		raf.close();
	}

	static boolean validateBookGenre(char genre) {
		if (genre == 'N' || genre == 'P' || genre == 'M') {
			return true;
		}
		return false;
	}

}

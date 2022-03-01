package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("test.bin");
		
		//Files with just numbers
		writeInFile(file);
		readFile(file);
		
		modifyValueAtPosition(file, getPositionInFile("int", 4), 999);
		readFile(file);
		
		modifyValueAtPosition(file, getPositionInFile("int", 4), 8);
		readFile(file);
		
		//Files with strings		
		writeInFileStrings(file);
		readFileStrings(file);
		
		modifyValueAtPosition(file, getPositionInFile(3, 30), "LolaLolita");
		readFileStrings(file);
		
		modifyValueAtPosition(file, getPositionInFile(file, "LolaLolita"), "Lola");
		readFileStrings(file);
		
	}

	static void writeInFile(File file) throws FileNotFoundException, IOException {
		Random rnd = new Random();
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(0);
		for (int i = 0; i < rnd.nextInt(30); i++) {
			raf.writeInt((i + 1));
		}

		raf.close();
	}
	
	static void writeInFileStrings(File file) throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.seek(0);
		
		raf.writeUTF(String.format("%-30s", "Pepe"));
		raf.writeUTF(String.format("%-30s", "Manolito"));
		raf.writeUTF(String.format("%-30s", "Maria"));
		raf.writeUTF(String.format("%-30s", "Lolita"));
		raf.writeUTF(String.format("%-30s", "Conchita"));

		raf.close();
	}

	static void readFile(File file) throws FileNotFoundException, IOException {
		long fileLength = file.length();
		RandomAccessFile raf = new RandomAccessFile(file, "r");

		while (raf.getFilePointer() < fileLength) {
			System.out.println(raf.readInt());
		}

		raf.close();
	}
	
	static void readFileStrings(File file) throws FileNotFoundException, IOException {
		long fileLength = file.length();
		RandomAccessFile raf = new RandomAccessFile(file, "r");

		while (raf.getFilePointer() < fileLength) {
			System.out.println(raf.readUTF());
		}

		raf.close();
	}

	static void modifyValueAtPosition(File file, int position, int value) throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");

		raf.seek(position);
		raf.writeInt(value);

		raf.close();
	}

	static void modifyValueAtPosition(File file, int position, String value) throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		
		raf.seek(position);
		raf.writeUTF(String.format("%-30s", value));
		
		raf.close();
	}
	
	static int getPositionInFile(String dataType, int quantity) {
		switch (dataType) {
		case "byte":
			return (1 * quantity);
		case "short":
			return (2 * quantity);
		case "int":
			return (4 * quantity);
		case "long":
			return (8 * quantity);
		case "float":
			return (4 * quantity);
		case "double":
			return (8 * quantity);
		case "char":
			return (2 * quantity);
		default:
			return 0;
		}

	}
	
	static int getPositionInFile(int quantity, int maxStringLength) {
		return (quantity * (maxStringLength + 2));
	}
	
	static int getPositionInFile(File file, String stringToSearch) throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");

		while(raf.getFilePointer() < file.length()) {
			if(raf.readUTF().trim().equalsIgnoreCase(stringToSearch)) {
				return (int) (raf.getFilePointer() - 32);
			}
		}

		raf.close();
		return 0;
	}
	
}

package mainapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MainApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("data.bin");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		
		int numberToSave = 4;
		
		raf.writeInt(1);
		raf.writeInt(2);
		raf.writeInt(3);
		raf.writeInt(5);
		raf.writeInt(6);
		raf.writeInt(7);
		
		raf.seek(0);
		
		while(raf.getFilePointer() < file.length()) {
			int data = raf.readInt();
			if(numberToSave < data) {
				raf.seek(raf.getFilePointer() - 4);
				raf.writeInt(numberToSave);
				numberToSave = data;
			}
		}
		
		raf.seek(0);
		while(raf.getFilePointer() < file.length()) {
			System.out.println(raf.readInt());
		}
		
		raf.close();
	}

}
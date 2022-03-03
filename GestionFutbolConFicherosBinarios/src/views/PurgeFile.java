package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PurgeFile {
	public static void purge() throws FileNotFoundException, IOException {
		File file = new File("Players.bin");
		RandomAccessFile readRaf = new RandomAccessFile(file, "r");
		RandomAccessFile writeRaf = new RandomAccessFile(file, "rw");
		boolean isDeleted = false;
		
		while(readRaf.getFilePointer() < file.length()) {
			isDeleted = readRaf.readBoolean();
			
			if(!isDeleted) {
				writeRaf.writeBoolean(false);
				writeRaf.writeUTF(readRaf.readUTF());
				writeRaf.writeUTF(readRaf.readUTF());
				writeRaf.writeInt(readRaf.readInt());
				writeRaf.writeUTF(readRaf.readUTF());
				writeRaf.writeInt(readRaf.readInt());
			} else {
				readRaf.skipBytes(72);
			}
		}
		writeRaf.setLength(writeRaf.getFilePointer());
		
		readRaf.close();
		writeRaf.close();
	}
}

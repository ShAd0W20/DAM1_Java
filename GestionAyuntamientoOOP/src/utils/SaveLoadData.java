package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.Ayuntamiento;

public class SaveLoadData {
	public static Ayuntamiento loadData(Ayuntamiento townHall) {
		try {
			FileInputStream fileIn = new FileInputStream("townhall.bin");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			townHall = (Ayuntamiento) in.readObject();
			in.close();
			fileIn.close();
			return townHall;
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Inventario class not found");
			c.printStackTrace();
			return null;
		}
	}
	
	public static void saveData(Ayuntamiento townHall) {

		try {
			FileOutputStream fileOut = new FileOutputStream("townhall.bin");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(townHall);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}

package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.Inventario;

public class SaveLoadData {
	
	public static Inventario loadData(Inventario inventario) {
		try {
			FileInputStream fileIn = new FileInputStream("inventario.bin");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			inventario = (Inventario) in.readObject();
			in.close();
			fileIn.close();
			return inventario;
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Inventario class not found");
			c.printStackTrace();
			return null;
		}
	}
	
	public static void saveData(Inventario inventario) {

		try {
			FileOutputStream fileOut = new FileOutputStream("inventario.bin");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(inventario);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}

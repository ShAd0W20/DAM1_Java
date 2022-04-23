package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.Tienda;

public class SaveLoadData {
	public static Tienda loadData(Tienda t) {
		try {
			FileInputStream fileIn = new FileInputStream("tienda.bin");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			t = (Tienda) in.readObject();
			in.close();
			fileIn.close();
			return t;
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Inventario class not found");
			c.printStackTrace();
			return null;
		}
	}
	
	public static void saveData(Tienda t) {

		try {
			FileOutputStream fileOut = new FileOutputStream("tienda.bin");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(t);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}

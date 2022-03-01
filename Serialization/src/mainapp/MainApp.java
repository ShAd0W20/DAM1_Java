package mainapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.Employee;

public class MainApp {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "Reyan Ali";
		e.address = "Phokka Kuan, Ambehta Peer";
		e.SSN = 11122333;
		e.number = 101;

		try {
			FileOutputStream fileOut = new FileOutputStream("employee.bin");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		Employee f = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.bin");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			f = (Employee) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}

		System.out.println("Deserialized Employee...");
		System.out.println("Name: " + f.name);
		System.out.println("Address: " + f.address);
		System.out.println("SSN: " + f.SSN);
		System.out.println("Number: " + f.number);
	}

}

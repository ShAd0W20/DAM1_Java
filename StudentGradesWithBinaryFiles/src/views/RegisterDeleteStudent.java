package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import models.Student;
import models.Subject;

public class RegisterDeleteStudent {
	final static Scanner input = new Scanner(System.in);

	public static void main() throws FileNotFoundException, IOException {
		File file = new File("studentsData.bin");
		String mainMenu = "";

		System.out.printf("%nQue desea hacer? %n[1] Registrar estudiante %n[2] Dar de baja a estudiante %n[Salir] para salir %n");

		do {
			mainMenu = input.nextLine();
			switch (mainMenu) {
			case "1":
				registerNewStudent(file);
				break;
			case "2":
				deleteStudent(file);
				break;
			default:
				if (!mainMenu.equalsIgnoreCase("salir")) {
					System.out.printf("%nQue desea hacer? %n[1] Registrar estudiante %n[2] Dar de baja a estudiante %n[Salir] para salir %n");
				}
			}
		} while (!mainMenu.equalsIgnoreCase("salir"));
		System.out.println("Pulse enter para volver al menu");
	}

	static void registerNewStudent(File file) throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		String studentName = "";
		
		raf.seek(file.length());

		System.out.println("Introduce el nombre del alumno | [Salir] para salir");
		do {
			studentName = input.nextLine();
			if (!studentName.equalsIgnoreCase("salir")) {
				Student student = new Student();
				if (studentName.length() < 20) {
					student.studentName = String.format("%-20s", studentName);
				} else {
					student.studentName = studentName.substring(0, 19);
				}
				for (int i = 0; i < 4; i++) {
					Subject s = new Subject();
					s.subjectGrade = -1;
					s.subjectComment = String.format("%-40s", "");
					student.subjects.add(s);
				}

				raf.writeBoolean(student.isDeleted);
				raf.writeUTF(student.studentName);
				for (Subject s : student.subjects) {
					raf.writeInt(s.subjectGrade);
					raf.writeUTF(s.subjectComment);
				}

				System.out.println("Introduce el nombre del alumno | [Salir] para salir");
			}
		} while (!studentName.equalsIgnoreCase("salir"));

		raf.close();
		System.out.println("Pulse enter para volver al menu");
	}

	static void deleteStudent(File file) throws FileNotFoundException, IOException {
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		String studentNameToSearch = "";

		System.out.println("Introduce el nombre del alumno a eliminar | [Salir] para salir");

		do {
			studentNameToSearch = input.nextLine();
			while (raf.getFilePointer() < file.length()) {
				raf.readBoolean();
				String studentName = raf.readUTF();

				if (studentNameToSearch.equals(studentName.trim())) {
					raf.seek(raf.getFilePointer() - 23);
					raf.writeBoolean(true);
					raf.skipBytes((22 + ((4 + 42) * 4)));
					System.out.println(studentName.trim() + " eliminado");
					purge();
				} else {
					raf.skipBytes(((4 + 42) * 4));
				}
			}
			if (!studentNameToSearch.equalsIgnoreCase("salir")) {
				System.out.println("Introduce el nombre del alumno a eliminar | [Salir] para salir");
			}
		} while (!studentNameToSearch.equalsIgnoreCase("salir"));

		raf.close();
		System.out.println("Pulse enter para volver al menu");
	}
	
	static void purge() throws FileNotFoundException, IOException {
		File file = new File("studentsData.bin");
		RandomAccessFile readRaf = new RandomAccessFile(file, "r");
		RandomAccessFile writeRaf = new RandomAccessFile(file, "rw");
		boolean isDeleted = false;
		
		while(readRaf.getFilePointer() < file.length()) {
			isDeleted = readRaf.readBoolean();
			
			if(!isDeleted) {
				writeRaf.writeBoolean(false);
				writeRaf.writeUTF(readRaf.readUTF());
				writeRaf.writeInt(readRaf.readInt());
				writeRaf.writeUTF(readRaf.readUTF());
				writeRaf.writeInt(readRaf.readInt());
				writeRaf.writeUTF(readRaf.readUTF());
				writeRaf.writeInt(readRaf.readInt());
				writeRaf.writeUTF(readRaf.readUTF());
				writeRaf.writeInt(readRaf.readInt());
				writeRaf.writeUTF(readRaf.readUTF());
			} else {
				readRaf.skipBytes((22 + ((4 + 42) * 4)));
			}
		}
		writeRaf.setLength(writeRaf.getFilePointer());
		
		readRaf.close();
		writeRaf.close();
	}
}

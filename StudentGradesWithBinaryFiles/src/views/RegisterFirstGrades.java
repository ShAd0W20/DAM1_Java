package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import models.Student;
import models.Subject;

public class RegisterFirstGrades {
	final static Scanner input = new Scanner(System.in);

	public static void main() throws FileNotFoundException, IOException {
		File file = new File("studentsData.bin");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");

		String studentNameToSearch = "";

		System.out.println("Introduce el nombre del alumno a buscar | [Salir] para salir");
		do {
			studentNameToSearch = input.nextLine();
			if (!studentNameToSearch.equalsIgnoreCase("salir")) {
				while (raf.getFilePointer() < file.length()) {
					boolean isDeleted = raf.readBoolean();
					String studentName = raf.readUTF();
					if (studentNameToSearch.equals(studentName.trim())) {
						Student student = new Student();
						student.isDeleted = isDeleted;
						student.studentName = studentName;
						for (int i = 0; i < 4; i++) {
							Subject s = new Subject();
							s.subjectGrade = raf.readInt();
							s.subjectComment = raf.readUTF().trim();
							student.subjects.add(s);
						}

						raf.seek(raf.getFilePointer() - ((4 + 42) * 4));

						System.out.println("Introduce la nota para Programación estructurada");
						student.subjects.get(0).subjectGrade = input.nextInt();
						input.nextLine();

						System.out.println("Introduce el comentario para Programación estructurada");
						student.subjects.get(0).subjectComment = input.nextLine();

						raf.writeInt(student.subjects.get(0).subjectGrade);
						if (student.subjects.get(0).subjectComment.length() < 40) {
							raf.writeUTF(String.format("%-40s", student.subjects.get(0).subjectComment));
						} else {
							raf.writeUTF(student.subjects.get(0).subjectComment.substring(0, 39));
						}

						raf.skipBytes(((4 + 42) * 3));
						System.out.println("Nota actualizada");
					} else {
						raf.skipBytes(((4 + 42) * 4));
					}
				}
				System.out.println("Introduce el nombre del alumno a buscar | [Salir] para salir");
			}
		} while (!studentNameToSearch.equalsIgnoreCase("salir"));
		raf.close();
		
		System.out.println("Pulse enter para volver al menu");
	}
}

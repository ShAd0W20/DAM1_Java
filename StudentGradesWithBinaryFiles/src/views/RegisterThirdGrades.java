package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import models.Student;
import models.Subject;

public class RegisterThirdGrades {
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

						raf.seek(raf.getFilePointer() - ((4 + 42) * 2));

						System.out.println("Introduce la nota para Gestion ficheros");
						student.subjects.get(2).subjectGrade = input.nextInt();
						input.nextLine();

						System.out.println("Introduce el comentario para Gestion ficheros");
						student.subjects.get(2).subjectComment = input.nextLine();

						raf.writeInt(student.subjects.get(2).subjectGrade);
						if (student.subjects.get(2).subjectComment.length() < 40) {
							raf.writeUTF(String.format("%-40s", student.subjects.get(2).subjectComment));
						} else {
							raf.writeUTF(student.subjects.get(2).subjectComment.substring(0, 39));
						}
						
						System.out.println("Introduce la nota para Programación orientada a objectos");
						student.subjects.get(3).subjectGrade = input.nextInt();
						input.nextLine();

						System.out.println("Introduce el comentario para Programación orientada a objectos");
						student.subjects.get(3).subjectComment = input.nextLine();

						raf.writeInt(student.subjects.get(3).subjectGrade);
						if (student.subjects.get(3).subjectComment.length() < 40) {
							raf.writeUTF(String.format("%-40s", student.subjects.get(3).subjectComment));
						} else {
							raf.writeUTF(student.subjects.get(3).subjectComment.substring(0, 39));
						}

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

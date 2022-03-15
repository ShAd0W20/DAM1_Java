package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import models.Student;
import models.Subject;

public class Recuperation {

	final static Scanner input = new Scanner(System.in);

	public static void main() throws FileNotFoundException, IOException {
		File file = new File("studentsData.bin");
		RandomAccessFile raf = new RandomAccessFile(file, "rw");

		String studentNameToSearch = "";
		String gradeToChange = "";

		System.out.println("Introduce el nombre del alumno a buscar | [Salir] para salir");
		do {
			studentNameToSearch = input.nextLine();
			if (!studentNameToSearch.equalsIgnoreCase("salir")) {
				while (raf.getFilePointer() < file.length()) {
					boolean isDeleted = raf.readBoolean();
					if (!isDeleted) {
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
							
							System.out.printf("%nDe que asignatura desea modificar la nota %n[1] Programación Estructurada %n[2] Programación Modular %n[3] Ficheros %n[4] Programación Orientada a Objetos %n[0] Para salir %n");
							do {
								gradeToChange = input.nextLine();
								switch (gradeToChange) {
								case "1":
									raf.seek(raf.getFilePointer() - ((4 + 42) * 4));
									System.out.printf("Introduce la nueva nota");
									student.subjects.get(0).subjectGrade = input.nextInt();
									input.nextLine();

									System.out.printf("Introduce el nuevo comentario %n");
									student.subjects.get(0).subjectComment = input.nextLine();

									raf.writeInt(student.subjects.get(0).subjectGrade);
									if (student.subjects.get(0).subjectComment.length() < 40) {
										raf.writeUTF(String.format("%-40s", student.subjects.get(0).subjectComment));
									} else {
										raf.writeUTF(student.subjects.get(0).subjectComment.substring(0, 39));
									}

									break;
								case "2":
									raf.seek(raf.getFilePointer() - ((4 + 42) * 3));
									System.out.printf("Introduce la nueva nota %n");
									student.subjects.get(1).subjectGrade = input.nextInt();
									input.nextLine();

									System.out.printf("Introduce el nuevo comentario %n");
									student.subjects.get(1).subjectComment = input.nextLine();

									raf.writeInt(student.subjects.get(1).subjectGrade);
									if (student.subjects.get(1).subjectComment.length() < 40) {
										raf.writeUTF(String.format("%-40s", student.subjects.get(1).subjectComment));
									} else {
										raf.writeUTF(student.subjects.get(1).subjectComment.substring(0, 39));
									}
									break;
								case "3":
									raf.seek(raf.getFilePointer() - ((4 + 42) * 2));
									System.out.printf("Introduce la nueva nota %n");
									student.subjects.get(2).subjectGrade = input.nextInt();
									input.nextLine();

									System.out.printf("Introduce el nuevo comentario %n");
									student.subjects.get(2).subjectComment = input.nextLine();

									raf.writeInt(student.subjects.get(2).subjectGrade);
									if (student.subjects.get(2).subjectComment.length() < 40) {
										raf.writeUTF(String.format("%-40s", student.subjects.get(2).subjectComment));
									} else {
										raf.writeUTF(student.subjects.get(2).subjectComment.substring(0, 39));
									}
									break;
								case "4":
									raf.seek(raf.getFilePointer() - (4 + 42));
									System.out.printf("Introduce la nueva nota %n");
									student.subjects.get(3).subjectGrade = input.nextInt();
									input.nextLine();

									System.out.printf("Introduce el nuevo comentario %n");
									student.subjects.get(3).subjectComment = input.nextLine();

									raf.writeInt(student.subjects.get(3).subjectGrade);
									if (student.subjects.get(3).subjectComment.length() < 40) {
										raf.writeUTF(String.format("%-40s", student.subjects.get(3).subjectComment));
									} else {
										raf.writeUTF(student.subjects.get(3).subjectComment.substring(0, 39));
									}
									break;
								}
								System.out.println("Nota actualizada");
								System.out.printf("%nDe que asignatura desea modificar la nota %n[1] Programación Estructurada %n[2] Programación Modular %n[3] Ficheros %n[4] Programación Orientada a Objetos %n[0] Para salir %n");
							} while (!gradeToChange.equals("0"));
							
						} else {
							raf.skipBytes(((4 + 42) * 4));
						}
					} else {
						raf.skipBytes(22 + ((4 + 42) * 4));
					}
				}
				System.out.println("%n Introduce el nombre del alumno a buscar | [Salir] para salir ");
			}
		} while (!studentNameToSearch.equalsIgnoreCase("salir"));
		raf.close();
		
		System.out.println("Pulse enter para volver al menu");
	}

}

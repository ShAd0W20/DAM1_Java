package views;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import models.Student;
import models.Subject;

public class DisplayResults {

	public static void main() throws FileNotFoundException, IOException {
		File file = new File("studentsData.bin");
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		String[] grades = {"Programació Estructurada", "Programació Modular", "Fitxers", "Programació Orientada a Objecte"};
		
		
		while(raf.getFilePointer() < file.length()) {
			boolean isDeleted = raf.readBoolean();
			String studentName = raf.readUTF();
			
			Student student = new Student();
			student.isDeleted = isDeleted;
			student.studentName = studentName;
			for (int i = 0; i < 4; i++) {
				Subject s = new Subject();
				s.subjectGrade = raf.readInt();
				s.subjectComment = raf.readUTF().trim();
				student.subjects.add(s);
			}
			System.out.printf("-".repeat(120) + " %n%n%5s: %s %n%n", "Nom", student.studentName);
			for(int j = 0; j < 4; j++) {
				if(student.subjects.get(j).subjectGrade >= 0) {
					System.out.printf("%10s%d %s: %d -> %s: %s %n", "[+] UF", (j + 1), grades[j], student.subjects.get(j).subjectGrade, "Comentario", student.subjects.get(j).subjectComment);
				}
			}
			System.out.printf("%n");
		}
		
		raf.close();
		
		System.out.println("Pulse enter para volver al menu");
	}

}

package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import models.Baloncesto;
import models.CF;
import models.ESO;
import models.Futbolista;
import utils.ConsoleHelper;

public class Register {
	public static ESO RegisterESOStudent() {
		String dni = ConsoleHelper.readString("Introduce el dni: ");
		String name = ConsoleHelper.readString("Introduce el nombre: ");
		LocalDate birthDay = LocalDate.parse(ConsoleHelper.readString("Introduce la fecha de nacimiento"), DateTimeFormatter.ofPattern("d/M/y"));
		String studentID = ConsoleHelper.readString("Introduce el ID del alumno: ");
		String studiesType = ConsoleHelper.readString("Introduce los estudios que realiza: ");
		String institute = ConsoleHelper.readString("Introduce el instituto en el que esta: ");
		int firstGrade = ConsoleHelper.readInteger("Introduce la primera nota: ");
		int secondGrade = ConsoleHelper.readInteger("Introduce la segunda nota: ");
		int thirdGrade = ConsoleHelper.readInteger("Introduce la tercera nota: ");
		int fourthGrade = ConsoleHelper.readInteger("Introduce la cuarta nota: ");
		
		ESO e = new ESO(dni, name, birthDay, studentID, studiesType, institute, firstGrade, secondGrade, thirdGrade, fourthGrade);
		return e;
	}
	
	public static CF RegisterCFStudent() {
		String dni = ConsoleHelper.readString("Introduce el dni: ");
		String name = ConsoleHelper.readString("Introduce el nombre: ");
		LocalDate birthDay = LocalDate.parse(ConsoleHelper.readString("Introduce la fecha de nacimiento"), DateTimeFormatter.ofPattern("d/M/y"));
		String studentID = ConsoleHelper.readString("Introduce el ID del alumno: ");
		String studiesType = ConsoleHelper.readString("Introduce los estudios que realiza: ");
		String institute = ConsoleHelper.readString("Introduce el instituto en el que esta: ");
		String nameCF = ConsoleHelper.readString("Introduce el ciclo en el que esta: ");
		int firstGrade = ConsoleHelper.readInteger("Introduce la primera nota: ");
		int secondGrade = ConsoleHelper.readInteger("Introduce la segunda nota: ");
		
		CF c = new CF(dni, name, birthDay, studentID, studiesType, institute, nameCF, firstGrade, secondGrade);
		return c;
	}
	
	public static Futbolista RegisterFootballPlayer() {
		String dni = ConsoleHelper.readString("Introduce el dni: ");
		String name = ConsoleHelper.readString("Introduce el nombre: ");
		LocalDate birthDay = LocalDate.parse(ConsoleHelper.readString("Introduce la fecha de nacimiento"), DateTimeFormatter.ofPattern("d/M/y"));
		String ficha = ConsoleHelper.readString("Introduce el ID del jugador: ");
		String sportType = ConsoleHelper.readString("Introduce el tipo de deporte: ");
		String teamName = ConsoleHelper.readString("Introduce el equipo del jugador: ");
		String position = ConsoleHelper.readString("Introduce la posicion: ");
		int scores = ConsoleHelper.readInteger("Introduce los goles: ");
		int fails = ConsoleHelper.readInteger("Introduce las faltas: ");
		
		Futbolista f = new Futbolista(dni, name, birthDay, ficha, sportType, teamName, position, scores, fails);
		return f;
	}
	
	public static Baloncesto RegisterBasketBallPlayer() {
		String dni = ConsoleHelper.readString("Introduce el dni: ");
		String name = ConsoleHelper.readString("Introduce el nombre: ");
		LocalDate birthDay = LocalDate.parse(ConsoleHelper.readString("Introduce la fecha de nacimiento"), DateTimeFormatter.ofPattern("d/M/y"));
		String ficha = ConsoleHelper.readString("Introduce el ID del jugador: ");
		String sportType = ConsoleHelper.readString("Introduce el tipo de deporte: ");
		String teamName = ConsoleHelper.readString("Introduce el equipo del jugador: ");
		String position = ConsoleHelper.readString("Introduce la posicion: ");
		int scores = ConsoleHelper.readInteger("Introduce los puntos: ");
		int fails = ConsoleHelper.readInteger("Introduce las faltas: ");
		
		Baloncesto b = new Baloncesto(dni, name, birthDay, ficha, sportType, teamName, position, scores, fails);
		return b;
	}
}

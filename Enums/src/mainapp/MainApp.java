package mainapp;

import java.time.LocalDate;

import models.DaysOfWeek;

public class MainApp {
	public static void main(String[] args) {

		DaysOfWeek[] days = DaysOfWeek.values();

		System.out.println(days[LocalDate.now().getDayOfWeek().ordinal()].getWeekDayName("ES") + "\n");
		System.out.println(days[LocalDate.now().getDayOfWeek().getValue() - 1].getWeekDayName("CA") + "\n");

		System.out.println(DaysOfWeek.values()[LocalDate.now().getDayOfWeek().getValue() - 1].getWeekDayName(System.getProperty("user.language")) + "\n");

		for (DaysOfWeek d : DaysOfWeek.values()) {
			System.out.println(d.getWeekDayName("ES"));
		}
	}
}

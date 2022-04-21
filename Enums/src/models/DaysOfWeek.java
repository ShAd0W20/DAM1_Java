package models;

public enum DaysOfWeek {
	MONDAY("Monday", "Lunes", "Dilluns"),
	TUESDAY("Thursday", "Martes", "Dimarts"),
	WEDNESDAY("Wednesday", "Miercoles", "Dimecres"),
	THURSDAY("Thursday", "Jueves", "Dijous"),
	FRIDAY("Friday", "Viernes", "Divendres"),
	SATURDAY("Saturday", "Sabado", "Dissabte"),
	SUNDAY("Sunday", "Domingo", "Diumenge");

	private String weekDayNameEN, weekDayNameES, weekDayNameCA;
	
	DaysOfWeek(String en, String es, String ca) {
		this.weekDayNameEN = en;
		this.weekDayNameES = es;
		this.weekDayNameCA = ca;
	}

	public String getWeekDayName() {
		return this.weekDayNameEN;
	}
	
	public String getWeekDayName(String lang) {
		switch (lang) {
		case "ES": case "es":
			return this.weekDayNameES;
		case "CA": case "ca":
			return this.weekDayNameCA;
		default:
			return this.weekDayNameEN;
		}
	}
}

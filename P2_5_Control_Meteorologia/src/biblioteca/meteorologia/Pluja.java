package biblioteca.meteorologia;

import java.util.ArrayList;

import programa.DiaMeteo;
import biblioteca.estadistica.TaulaEnters;

public class Pluja {

	public static int mitjanaMensualPluja(String mes, DiaMeteo[] dias) {
		int monthNumber = monthNumber(mes);
		ArrayList<DiaMeteo> objectInMonth = new ArrayList<DiaMeteo>();
		
		for (int i = 0; i < dias.length; i++) {
			if(dias[i].dia.getMonthValue() == monthNumber) {
				DiaMeteo object = new DiaMeteo();
				
				object.tempMax = dias[i].tempMax;
				object.tempMin = dias[i].tempMin;
				object.ventMax = dias[i].ventMax;
				object.pluja = dias[i].pluja;
				object.dia = dias[i].dia;
				
				objectInMonth.add(object);
			}
		}
		int[] rainDaysByMonth = new int[objectInMonth.size()];
		
		for (int i = 0; i < objectInMonth.size(); i++) {
			rainDaysByMonth[i] = objectInMonth.get(i).pluja;
		}
		
		return TaulaEnters.mitjanaTaula(rainDaysByMonth);
	}

	static ArrayList<DiaMeteo> diesMesPlujaMensual(String mes, DiaMeteo[] dias) {

		
		return null;
	}

	static int mitjanaAnualPluja(DiaMeteo[] dias) {
		int[] rainDays = new int[dias.length];
		for (int i = 0; i < dias.length; i++) {
			rainDays[i] = dias[i].pluja;
		}
		return TaulaEnters.mitjanaTaula(rainDays);
	}

	static ArrayList<DiaMeteo> diasMesPlujaAnual(DiaMeteo[] dias) {
		return null;
	}
	
	static int monthNumber(String mes) {
		int monthNumber = 0;
		switch (mes) {
		case "Gener":
			monthNumber = 1;
			break;
		case "Febrer":
			monthNumber = 2;
			break;
		case "Març":
			monthNumber = 3;
			break;
		case "Abril":
			monthNumber = 4;
			break;
		case "Maig":
			monthNumber = 5;
			break;
		case "Juny":
			monthNumber = 6;
			break;
		case "Juliol":
			monthNumber = 7;
			break;
		case "Agost":
			monthNumber = 8;
			break;
		case "Septembre":
			monthNumber = 9;
			break;
		case "Octubre":
			monthNumber = 10;
			break;
		case "Novembre":
			monthNumber = 11;
			break;
		case "Desembre":
			monthNumber = 12;
			break;
		}
		
		return monthNumber;
	}

}

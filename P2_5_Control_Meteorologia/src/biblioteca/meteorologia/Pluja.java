package biblioteca.meteorologia;

import java.util.ArrayList;

import programa.DiaMeteo;
import biblioteca.estadistica.TaulaEnters;

/**
 * The Class Pluja.
 */
public class Pluja {

	/**
	 * Mitjana mensual pluja.
	 *
	 * @param mes the string of the month to search
	 * @param dias the DiaMeteo object array
	 * @return the number with the value of the median monthly rain
	 */
	public static int mitjanaMensualPluja(String mes, DiaMeteo[] dias) {
		int monthNumber = TaulaEnters.monthNumber(mes);
		ArrayList<DiaMeteo> objectInMonth = new ArrayList<DiaMeteo>();

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				objectInMonth.add(dias[i]);
			}
		}
		int[] rainDaysByMonth = new int[objectInMonth.size()];

		for (int i = 0; i < objectInMonth.size(); i++) {
			rainDaysByMonth[i] = objectInMonth.get(i).pluja;
		}

		return TaulaEnters.mitjanaTaula(rainDaysByMonth);
	}

	/**
	 * Dies mes pluja mensual.
	 *
	 * @param mes the string of the month to search
	 * @param dias the DiaMeteo object array
	 * @return the array list of days that have rained the most of the month
	 */
	public static ArrayList<DiaMeteo> diesMesPlujaMensual(String mes, DiaMeteo[] dias) {
		int monthNumber = TaulaEnters.monthNumber(mes);
		ArrayList<DiaMeteo> objectInMonth = new ArrayList<DiaMeteo>();
		ArrayList<DiaMeteo> maxRainDaysInMonth = new ArrayList<DiaMeteo>();

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				objectInMonth.add(dias[i]);
			}
		}
		int[] rainDaysByMonth = new int[objectInMonth.size()];

		for (int i = 0; i < objectInMonth.size(); i++) {
			rainDaysByMonth[i] = objectInMonth.get(i).pluja;
		}

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				if (dias[i].pluja == TaulaEnters.maxTaula(rainDaysByMonth)) {
					maxRainDaysInMonth.add(dias[i]);
				}
			}
		}

		return maxRainDaysInMonth;
	}

	/**
	 * Mitjana anual pluja.
	 *
	 * @param dias the DiaMeteo object array
	 * @return the the integer containing the average annual rainfall
	 */
	public static int mitjanaAnualPluja(DiaMeteo[] dias) {
		int[] rainDays = new int[dias.length];
		for (int i = 0; i < dias.length; i++) {
			rainDays[i] = dias[i].pluja;
		}
		return TaulaEnters.mitjanaTaula(rainDays);
	}

	/**
	 * Dias mes pluja anual.
	 *
	 * @param dias the DiaMeteo object array
	 * @return the array list of the days that it has rained more throughout the year
	 */
	public static ArrayList<DiaMeteo> diasMesPlujaAnual(DiaMeteo[] dias) {
		int[] rainDays = new int[dias.length];
		ArrayList<DiaMeteo> daysMaxRain = new ArrayList<DiaMeteo>();
		
		for (int i = 0; i < dias.length; i++) {
			rainDays[i] = dias[i].pluja;
		}
		
		for (int i = 0; i < dias.length; i++) {
				if (dias[i].pluja == TaulaEnters.maxTaula(rainDays)) {
					daysMaxRain.add(dias[i]);
				}
		}
		return daysMaxRain;
	}

}

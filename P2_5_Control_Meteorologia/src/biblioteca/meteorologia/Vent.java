package biblioteca.meteorologia;

import java.util.ArrayList;
import programa.DiaMeteo;
import biblioteca.estadistica.TaulaEnters;

/**
 * The Class Vent.
 */
public class Vent {

	/**
	 * Dies poc vent mensual.
	 *
	 * @param mes the string of the month to search
	 * @param dias the DiaMeteo object array
	 * @return the array list containing the days that has made less wind
	 */
	public static ArrayList<DiaMeteo> diesPocVentMensual(String mes, DiaMeteo[] dias) {
		int monthNumber = TaulaEnters.monthNumber(mes);
		ArrayList<DiaMeteo> daysLessWind = new ArrayList<DiaMeteo>();

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				if (dias[i].ventMax < 10) {
					daysLessWind.add(dias[i]);
				}
			}
		}

		return daysLessWind;
	}

	/**
	 * Dies poc vent anual.
	 *
	 * @param dias the DiaMeteo object array
	 * @return the array list containing the days which has been less windy throughout the year
	 */
	public static ArrayList<DiaMeteo> diesPocVentAnual(DiaMeteo[] dias) {
		ArrayList<DiaMeteo> daysLessWind = new ArrayList<DiaMeteo>();

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].ventMax < 10) {
				daysLessWind.add(dias[i]);
			}
		}

		return daysLessWind;
	}
	
	/**
	 * Nombre dies poc vent mensual.
	 *
	 * @param mes the string of the month to search
	 * @param dias the DiaMeteo object array
	 * @return the number of days that it has been little windy in the month
	 */
	public static int nombreDiesPocVentMensual (String mes, DiaMeteo[] dias) {
		int monthNumber = TaulaEnters.monthNumber(mes);
		int totalDays = 0;
		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				if (dias[i].ventMax < 10) {
					totalDays++;				
				}
			}
		}
		return totalDays;
	}
	
	/**
	 * Nombre dies poc vent anual.
	 *
	 * @param dias the DiaMeteo object array
	 * @return the number of days that it has been little windy 
	 */
	public static int nombreDiesPocVentAnual (DiaMeteo[] dias) {
		int totalDays = 0;
		for (int i = 0; i < dias.length; i++) {
			if (dias[i].ventMax < 10) {
				totalDays++;
			}
		}
		return totalDays;
	}

}

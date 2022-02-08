package biblioteca.meteorologia;

import java.util.ArrayList;

import biblioteca.estadistica.TaulaEnters;
import programa.DiaMeteo;


/**
 * The Class Temperatura.
 */
public class Temperatura {

	/**
	 * Dies mes amplitud mensual.
	 *
	 * @param mes the string of the month to search
	 * @param dias the DiaMeteo object array
	 * @return the array list of days with most amplitude temperature in month searched
	 */
	public static ArrayList<DiaMeteo> diesMesAmplitudMensual(String mes, DiaMeteo[] dias) {
		int monthNumber = TaulaEnters.monthNumber(mes);
		int differenceBetweenTemp = 0;
		int maxDifference = 0;

		ArrayList<DiaMeteo> maxTemperatureAmpliude = new ArrayList<DiaMeteo>();

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				differenceBetweenTemp = dias[i].tempMax - dias[i].tempMin;

				if (differenceBetweenTemp > maxDifference) {
					maxDifference = differenceBetweenTemp;
				}
			}

		}

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				if ((dias[i].tempMax - dias[i].tempMin) == maxDifference) {
					maxTemperatureAmpliude.add(dias[i]);
				}
			}
		}

		return maxTemperatureAmpliude;
	}

	/**
	 * Dies mes amplitud anual.
	 *
	 * @param dias the DiaMeteo object array
	 * @return the array list of days with most amplitude temperature in year
	 */
	public static ArrayList<DiaMeteo> diesMesAmplitudAnual(DiaMeteo[] dias) {
		int differenceBetweenTemp = 0;
		int maxDifference = 0;

		ArrayList<DiaMeteo> maxTemperatureAmpliude = new ArrayList<DiaMeteo>();

		for (int i = 0; i < dias.length; i++) {
			differenceBetweenTemp = dias[i].tempMax - dias[i].tempMin;

			if (differenceBetweenTemp > maxDifference) {
				maxDifference = differenceBetweenTemp;
			}

		}

		for (int i = 0; i < dias.length; i++) {
			if ((dias[i].tempMax - dias[i].tempMin) == maxDifference) {
				maxTemperatureAmpliude.add(dias[i]);
			}
		}

		return maxTemperatureAmpliude;
	}

	/**
	 * Dies mes calor mensual.
	 *
	 * @param mes the string of the month to search
	 * @param dias the DiaMeteo object array
	 * @return the array list of days that have been colder throughout the month
	 */
	public static ArrayList<DiaMeteo> diesMesCalorMensual(String mes, DiaMeteo[] dias) {
		int monthNumber = TaulaEnters.monthNumber(mes);
		ArrayList<DiaMeteo> objectInMonth = new ArrayList<DiaMeteo>();
		ArrayList<DiaMeteo> maxHeatDaysInMonth = new ArrayList<DiaMeteo>();

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				objectInMonth.add(dias[i]);
			}
		}
		int[] heatDaysByMonth = new int[objectInMonth.size()];

		for (int i = 0; i < objectInMonth.size(); i++) {
			heatDaysByMonth[i] = objectInMonth.get(i).tempMax;
		}

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				if (dias[i].tempMax == TaulaEnters.maxTaula(heatDaysByMonth)) {
					maxHeatDaysInMonth.add(dias[i]);
				}
			}
		}

		return maxHeatDaysInMonth;
	}

	/**
	 * Dies mes calor anual.
	 *
	 * @param dias the DiaMeteo object array
	 * @return the array list of days that have been hotter throughout the year
	 */
	public static ArrayList<DiaMeteo> diesMesCalorAnual(DiaMeteo[] dias) {
		int[] heatDaysYear = new int[dias.length];
		ArrayList<DiaMeteo> maxHeatDaysInYear = new ArrayList<DiaMeteo>();

		for (int i = 0; i < dias.length; i++) {
			heatDaysYear[i] = dias[i].tempMax;
		}

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].tempMax == TaulaEnters.maxTaula(heatDaysYear)) {
				maxHeatDaysInYear.add(dias[i]);
			}
		}

		return maxHeatDaysInYear;
	}

	/**
	 * Dies mes fred mensual.
	 *
	 * @param mes the string of the month to search
	 * @param dias the DiaMeteo object array
	 * @return the array list of days that have been colder throughout the month
	 */
	public static ArrayList<DiaMeteo> diesMesFredMensual(String mes, DiaMeteo[] dias) {
		int monthNumber = TaulaEnters.monthNumber(mes);
		ArrayList<DiaMeteo> objectInMonth = new ArrayList<DiaMeteo>();
		ArrayList<DiaMeteo> maxColdDaysInMonth = new ArrayList<DiaMeteo>();

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				objectInMonth.add(dias[i]);
			}
		}
		int[] coldDaysByMonth = new int[objectInMonth.size()];

		for (int i = 0; i < objectInMonth.size(); i++) {
			coldDaysByMonth[i] = objectInMonth.get(i).tempMin;
		}

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].dia.getMonthValue() == monthNumber) {
				if (dias[i].tempMin == TaulaEnters.minTaula(coldDaysByMonth)) {
					maxColdDaysInMonth.add(dias[i]);
				}
			}
		}

		return maxColdDaysInMonth;
	}
	
	/**
	 * Dies mes fred anual.
	 *
	 * @param dias the DiaMeteo object array
	 * @return the array list of days that have been colder throughout the year
	 */
	public static ArrayList<DiaMeteo> diesMesFredAnual(DiaMeteo[] dias) {
		int[] coldDaysYear = new int[dias.length];
		ArrayList<DiaMeteo> maxColdDaysInYear = new ArrayList<DiaMeteo>();

		for (int i = 0; i < dias.length; i++) {
			coldDaysYear[i] = dias[i].tempMax;
		}

		for (int i = 0; i < dias.length; i++) {
			if (dias[i].tempMax == TaulaEnters.maxTaula(coldDaysYear)) {
				maxColdDaysInYear.add(dias[i]);
			}
		}

		return maxColdDaysInYear;
	}

}

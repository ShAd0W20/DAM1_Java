package mainapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import models.*;

public class RainyDays {

	public static void main(String[] args) {
		DiaPluja[] pluja2021 = new DiaPluja[365];
		int[] probabilitatPlujaDiaria = { 20, 20, 40, 60, 50, 40, 20, 10, 20, 50, 30, 30 };
		int[] maximPlujaDiaria = { 10, 10, 30, 50, 50, 25, 10, 10, 10, 40, 30, 20 };
		
		
		generarPlujaAnual(pluja2021, probabilitatPlujaDiaria, maximPlujaDiaria);
		
		imprimirDadesPlujaAnualAgrupadesPerMesos(pluja2021);
	}

	public static void generarPlujaAnual(DiaPluja[] plujaAny, int[] probabilitatPlujaDiaria, int[] maximPlujaDiaria) {
		Random rnd = new Random();
		for (int i = 0; i < plujaAny.length; i++) {
			DiaPluja dia = new DiaPluja();
			dia.data = LocalDate.of(2021, (rnd.nextInt(12) + 1), (rnd.nextInt(28) + 1));
			dia.litres = rnd.nextInt(100);

			plujaAny[i] = dia;
		}
	}

	
	public static void imprimirDadesPlujaAnualAgrupadesPerMesos(DiaPluja[] plujaAny) {
		String[] monthName = { "Gener", "Febrer", "Març", "April", "Maig", "Juny", "Juliol", "Agost", "Septembre", "Octubre", "Novembre", "Decembre" };
		int totalLiters = 0;
		int totalRainyDays = 0;
		int maxRain = 0;
		for (String s : monthName) {
			System.out.print(s);
			for(DiaPluja d: plujaAny) {
				if(s.equals(mes(d.data))) {
					totalLiters += d.litres;
					totalRainyDays += quantsDiesHaPlogutMes(mes(d.data), plujaAny);
				}
			}
			System.out.print(" " + totalLiters + " - " + totalRainyDays + "\n");
			totalLiters = 0;
			totalRainyDays = 0;
		}
		
		for (String s : monthName) {
			for(DiaPluja d: plujaAny) {
				if(s.equals(mes(d.data))) {
					totalLiters += d.litres;
					totalRainyDays += quantsDiesHaPlogutMes(mes(d.data), plujaAny);
				}
			}
		}
		
		System.out.println("Any: [2021] " + totalLiters + " litres - " + totalRainyDays + " dies de pluja");
		
		System.out.print("Els dias de l'any amb mes pluja han estat: ");
		for(DiaPluja d : diesHaPlogutMesLitres(plujaAny)) {
			maxRain = d.litres;
			System.out.print(d.data.toString() + ", ");
		}
		System.out.print("amb " + maxRain + " litres");
		System.out.println();
	}
	

	public static int quantsDiesHaPlogutMes(String mes, DiaPluja[] plujaAny) {
		int monthNumber = monthNumber(mes);
		int totalDays = 0;
		for (int i = 0; i < plujaAny.length; i++) {
			if (plujaAny[i].data.getMonthValue() == monthNumber) {
				if (plujaAny[i].litres > 0) {
					totalDays++;
				}
			}
		}
		return totalDays;
	}

	public static int quantsLitresHaPlogutMes(String mes, DiaPluja[] plujaAny) {
		int monthNumber = monthNumber(mes);
		int totalRain = 0;
		for (int i = 0; i < plujaAny.length; i++) {
			if (plujaAny[i].data.getMonthValue() == monthNumber) {
				totalRain += plujaAny[i].litres;
			}
		}
		return totalRain;
	}

	public static String mes(LocalDate date) {
		String[] monthName = { "Gener", "Febrer", "Març", "April", "Maig", "Juny", "Juliol", "Agost", "Septembre", "Octubre", "Novembre", "Decembre" };
		int monthNumber = date.getMonthValue();
		
		return monthName[monthNumber - 1];
	}

	public static ArrayList<DiaPluja> diesHaPlogutMesLitres(DiaPluja[] plujaAny) {
		int[] rainDays = new int[plujaAny.length];
		ArrayList<DiaPluja> daysMaxRain = new ArrayList<DiaPluja>();

		for (int i = 0; i < plujaAny.length; i++) {
			rainDays[i] = plujaAny[i].litres;
		}

		for (int i = 0; i < plujaAny.length; i++) {
			if (plujaAny[i].litres == maxInArray(rainDays)) {
				daysMaxRain.add(plujaAny[i]);
			}
		}
		return daysMaxRain;
	}
	
	public static int monthNumber(String mes) {
		int monthNumber = 0;
		switch (mes.toLowerCase()) {
		case "gener":
			monthNumber = 1;
			break;
		case "febrer":
			monthNumber = 2;
			break;
		case "març":
			monthNumber = 3;
			break;
		case "abril":
			monthNumber = 4;
			break;
		case "maig":
			monthNumber = 5;
			break;
		case "juny":
			monthNumber = 6;
			break;
		case "juliol":
			monthNumber = 7;
			break;
		case "agost":
			monthNumber = 8;
			break;
		case "septembre":
			monthNumber = 9;
			break;
		case "octubre":
			monthNumber = 10;
			break;
		case "novembre":
			monthNumber = 11;
			break;
		case "desembre":
			monthNumber = 12;
			break;
		}

		return monthNumber;
	}

	public static int maxInArray(int[] array) {
		int max = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

}

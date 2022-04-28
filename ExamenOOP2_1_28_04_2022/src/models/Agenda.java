package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Cumpleaños> cumple;
	private ArrayList<DiaFestivo> diaFestivos;
	private ArrayList<Examen> examen;
	private ArrayList<EntregaPractica> practica;

	public Agenda() {
		this.cumple = new ArrayList<>();
		this.diaFestivos = new ArrayList<>();
		this.examen = new ArrayList<>();
		this.practica = new ArrayList<>();
	}

	public String getEventosDia(LocalDate day) {
		String data = "";
		for (Cumpleaños c : cumple) {
			if (c.getDate().compareTo(day) == 0) {
				data += String.format("Cumple de %s %s %n", c.getName(), c.getBirthDate());
			}
		}

		for (DiaFestivo d : diaFestivos) {
			if (d.getDate().compareTo(day) == 0) {
				data += String.format("Dia festivo %s %n", d.getNombreFesitvo());
			}
		}

		for (Examen e : examen) {
			if (e.getDate().compareTo(day) == 0) {
				data += String.format("Examen de %s de %s a %s%n", e.getModulo(), e.getHoraInicio(), e.getHoraFinal());
			}
		}

		for (EntregaPractica ep : practica) {
			if (ep.getDate().compareTo(day) == 0) {
				data += String.format("Entrega de la practica de %s antes de %s %n", ep.getModulo(), ep.getHoraFinal());
			}
		}
		return data;
	}

	public void addEvento(Cumpleaños c) {
		this.cumple.add(c);
	}

	public void addEvento(DiaFestivo d) {
		this.diaFestivos.add(d);
	}

	public void addEvento(Examen e) {
		this.examen.add(e);
	}

	public void addEvento(EntregaPractica p) {
		this.practica.add(p);
	}

	public String getEventos() {
		String data = "";
		ArrayList<Evento> dataList = new ArrayList<>();
		ArrayList<LocalDate> dates = new ArrayList<>();
		for (Cumpleaños c : cumple) {
			dataList.add(c);
			if(!dates.contains(c.getDate())) {
				dates.add(c.getDate());
			}
		}

		for (DiaFestivo d : diaFestivos) {
			dataList.add(d);
			if(!dates.contains(d.getDate())) {
				dates.add(d.getDate());
			}
		}

		for (Examen e : examen) {
			dataList.add(e);
			if(!dates.contains(e.getDate())) {
				dates.add(e.getDate());
			}
		}

		for (EntregaPractica ep : practica) {
			dataList.add(ep);
			if(!dates.contains(ep.getDate())) {
				dates.add(ep.getDate());
			}
		}
		
		dates.sort((o1, o2) -> o1.compareTo(o2));
		dataList.sort((o1, o2) -> o1.getDate().compareTo(o1.getDate()));
		
		for(LocalDate localDate : dates) {
			data += String.format("%s%n", localDate.format(DateTimeFormatter.ofPattern("d/M/y")));
			for(Evento e : dataList) {
				if(e.getDate().compareTo(localDate) == 0) {
					data += e.descripcion();
				}
			}
		}
		
		return data;
	}

}

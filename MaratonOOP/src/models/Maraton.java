package models;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Maraton {
	private int codigoMaraton;
	private String nombreMaraton;
	private int distancia;
	private LocalDate fechaMaraton;
	private ArrayList<Resultado> resultados;

	public Maraton(int codigoMaraton, String nombreMaraton, int distancia, LocalDate fechaMaraton) {
		super();
		this.codigoMaraton = codigoMaraton;
		this.nombreMaraton = nombreMaraton;
		this.distancia = distancia;
		this.fechaMaraton = fechaMaraton;
		this.resultados = new ArrayList<>();
	}

	public int getCodigoMaraton() {
		return codigoMaraton;
	}

	public String getNombreMaraton() {
		return nombreMaraton;
	}

	public int getDistancia() {
		return distancia;
	}

	public LocalDate getFechaMaraton() {
		return fechaMaraton;
	}

	public ArrayList<Resultado> getResultados() {
		return resultados;
	}

	public boolean addResultado(Resultado resultado) {
		if (!resultAlreadyExists(resultado)) {
			this.resultados.add(resultado);
			return true;
		}
		return false;
	}

	private boolean resultAlreadyExists(Resultado resultado) {

		boolean dorsalExists = false;
		boolean DNIExists = false;

		int[] dorsal = new int[this.getResultados().size()];
		String[] DNIs = new String[this.getResultados().size()];

		for (int i = 0; i < this.getResultados().size(); i++) {
			dorsal[i] = this.getResultados().get(i).getDorsalCorredor();
			DNIs[i] = this.getResultados().get(i).getCorredor().getDNI();
		}

		for (int i : dorsal) {
			if (i == resultado.getDorsalCorredor()) {
				dorsalExists = true;
			}
		}

		for (String s : DNIs) {
			if (s.equals(resultado.getCorredor().getDNI())) {
				DNIExists = true;
			}
		}

		return (DNIExists || dorsalExists);
	}

	public String getAllCorredores() {
		String data = "";
		ArrayList<Corredor> corredores = new ArrayList<Corredor>();

		for (Resultado r : this.getResultados()) {
			corredores.add(r.getCorredor());
		}

		corredores.sort((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));

		for (Corredor c : corredores) {
			data += String.format("%-10s %-10s%n", c.getNombre(), c.getCategoria());
		}

		return data;
	}

	public String getAllCorredoresFromCategory(String category) {
		String data = "";
		ArrayList<Corredor> corredores = new ArrayList<Corredor>();

		for (Resultado r : this.getResultados()) {
			if (r.getCorredor().getCategoria().equals(category)) {
				corredores.add(r.getCorredor());
			}
		}

		corredores.sort((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));

		for (Corredor c : corredores) {
			data += String.format("%-10s %-10s%n", c.getNombre(), c.getCategoria());
		}

		return data;
	}

	public String getAllCorredoresOrderByCategory() {
		String data = "";
		ArrayList<Corredor> corredores = new ArrayList<Corredor>();
		String[] categories = {"Absoluto Masculino", "Absoluto Femenino", "Veterano Masculino", "Veterano Femenino"};

		for (Resultado r : this.resultados) {
			corredores.add(r.getCorredor());
		}

		corredores.sort((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));

		for(String category : categories) {
			data += String.format("%n%n%s%n", category);
			for (Corredor c : corredores) {
				if(c.getCategoria().equals(category)) {
					data += String.format("%-10s %-10s%n", c.getNombre(), c.getCategoria());
				}
			}
		}

		return data;
	}
	
	public void editResult(int[][] result) {
		for(Resultado r : this.getResultados()) {
			if(r.getDorsalCorredor() == result[0][0]) {
				r.setTiempoMaraton(Duration.ofSeconds(result[0][1]));
				return;
			}
		}
	}
	
	public String getAllResults() {
		String data = "";
		ArrayList<Resultado> resultados = new ArrayList<>();

		for (Resultado r : this.getResultados()) {
			resultados.add(r);
		}

		resultados.sort((o1, o2) -> o1.getTiempoMaraton().compareTo(o2.getTiempoMaraton()));

		for (Resultado r : resultados) {
			data += String.format("%-20s %-10s %-10s%n", formatDuration(r.getTiempoMaraton()), r.getDorsalCorredor(), r.getCorredor().getNombre());
		}

		return data;
	}
	
	public String getAllResultsFromCategory(String category) {
		String data = "";
		ArrayList<Resultado> resultados = new ArrayList<>();

		for (Resultado r : this.getResultados()) {
			if(r.getCorredor().getCategoria().equals(category)) {
				resultados.add(r);
			}
		}

		resultados.sort((o1, o2) -> o1.getTiempoMaraton().compareTo(o2.getTiempoMaraton()));

		for (Resultado r : resultados) {
			data += String.format("%-20s %-10s %-10s%n", formatDuration(r.getTiempoMaraton()), r.getDorsalCorredor(), r.getCorredor().getNombre());
		}

		return data;
	}
	
	public String getAllResultsOrderByCategory() {
		String data = "";
		ArrayList<Resultado> resultados = new ArrayList<>();
		String[] categories = {"Absoluto Masculino", "Absoluto Femenino", "Veterano Masculino", "Veterano Femenino"};

		for (Resultado r : this.getResultados()) {
			resultados.add(r);
		}

		resultados.sort((o1, o2) -> o1.getTiempoMaraton().compareTo(o2.getTiempoMaraton()));

		for(String category : categories) {
			data += String.format("%n%n%s%n", category);
			for (Resultado r : resultados) {
				if(r.getCorredor().getCategoria().equals(category)) {
					data += String.format("%-20s %-10s %-10s%n", formatDuration(r.getTiempoMaraton()), r.getDorsalCorredor(), r.getCorredor().getNombre());
				}
			}
		}

		return data;
	}
	
	private String formatDuration(Duration time) {
		String timeFormat = "";
		timeFormat = time.toHoursPart() + " h " + time.toMinutesPart() + " m " + time.toSecondsPart() + " s";
		return timeFormat;
	}
}

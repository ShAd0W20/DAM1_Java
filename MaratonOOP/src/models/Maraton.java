package models;

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

		int[] dorsal = new int[this.resultados.size()];
		String[] DNIs = new String[this.resultados.size()];

		for (int i = 0; i < this.resultados.size(); i++) {
			dorsal[i] = this.resultados.get(i).getDorsalCorredor();
			DNIs[i] = this.resultados.get(i).getCorredor().getDNI();
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

		for (Resultado r : this.resultados) {
			corredores.add(r.getCorredor());
		}
		
		corredores.sort((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
		
		for(Corredor c : corredores) {
			String.format("%-10s %-10s", c.getNombre(), c.getCategoria());
		}

		return data;
	}
}

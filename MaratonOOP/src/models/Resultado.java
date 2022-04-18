package models;

import java.time.Duration;

public class Resultado {
	private static int currentDorsal = 1;
	private Corredor corredor;
	private int dorsalCorredor;
	private Duration tiempoMaraton;

	public Resultado(Corredor corredor, Duration tiempoMaraton) {
		super();
		this.corredor = corredor;
		this.tiempoMaraton = tiempoMaraton;
		this.dorsalCorredor = currentDorsal;
		currentDorsal++;
	}

	public Corredor getCorredor() {
		return this.corredor;
	}
	
	public int getDorsalCorredor() {
		return dorsalCorredor;
	}

	public Duration getTiempoMaraton() {
		return tiempoMaraton;
	}

}

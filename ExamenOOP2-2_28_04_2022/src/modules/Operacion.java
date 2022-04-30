package modules;

import java.time.LocalDateTime;

import modules.enums.TipoOperacion;

public class Operacion {
	public LocalDateTime momentoOperacion;
	public TipoOperacion tipo;
	public int importe;
	public int importeAfter;

	public Operacion(LocalDateTime momentoOperacion, TipoOperacion tipo, int importe, int importeAfter) {
		super();
		this.momentoOperacion = momentoOperacion;
		this.tipo = tipo;
		this.importe = importe;
		this.importeAfter = importeAfter;
	}

}

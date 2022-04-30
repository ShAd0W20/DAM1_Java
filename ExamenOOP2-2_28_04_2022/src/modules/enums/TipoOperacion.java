package modules.enums;

public enum TipoOperacion {
	INGRESO("Ingreso"), TRANSFER("Transferencia"), REINTEGRO("Reintegro");

	private String name;
	
	TipoOperacion(String string) {
		this.name = string;
	}
	
	public String getName() {
		return this.name;
	}	
}

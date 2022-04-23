package models.enums;

public enum ProgramTypes {
	PROCESADORTEXT("Procesador de texto"), HOJASDECALCULO("Hojas de calculo"), PRESENTACIONES("Presentaciones");
	
	private String programType;
	
	ProgramTypes(String string) {
		this.programType = string;
	}
	
	public String getProgramType() {
		return this.programType;
	}
	
}

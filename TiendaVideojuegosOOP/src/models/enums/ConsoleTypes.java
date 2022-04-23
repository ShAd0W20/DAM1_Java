package models.enums;

public enum ConsoleTypes {
	PS4("PS4"), PS5("PS5"), XBOX("XBox"), PC("PC");

	private String consoleName;
	
	ConsoleTypes(String string) {
		this.consoleName = string;
	}
	
	public String getConsoleType() {
		return this.consoleName;
	}
}

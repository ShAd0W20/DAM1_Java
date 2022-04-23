package models.enums;

public enum OSTypes {
	WINDOWS("Windows"), MACOS("MacOS"), LINUX("Linux");

	private String osType;
	
	OSTypes(String string) {
		this.osType = string;
	}
	
	public String getOsType() {
		return this.osType;
	}
}

package models.enums;

public enum GameTypes {
	ACCION("Accion"), ARCADE("Arcade"), DEPORTIVO("Deportivo"), ESTRATEGIA("Estrategia"), SIMULACION("Simulacion");

	private String tipeName;

	GameTypes(String string) {
		this.tipeName = string;
	}

	public String getGameType() {
		return this.tipeName;
	}
}

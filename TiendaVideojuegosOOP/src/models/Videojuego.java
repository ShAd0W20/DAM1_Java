package models;

import enums.ConsoleTypes;
import enums.GameTypes;

public class Videojuego extends Producto {

	private GameTypes type;
	private ConsoleTypes console;

	public Videojuego(String code, String name, double price, int stock, int sells, GameTypes type, ConsoleTypes console) {
		super(code, name, price, stock, sells);
		this.type = type;
		this.console = console;
	}

	public String getType() {
		return this.type.getGameType();
	}

	public String getConsole() {
		return this.console.getConsoleType();
	}

	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10s %-10s %-10s %n", this.getCode(), this.getName(), this.getPrice(), this.getSells(), this.getStock());
	}
}

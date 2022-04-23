package models;

import java.io.Serializable;

public abstract class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7530450796300775273L;
	private String code;
	private String name;
	private double price;
	private int stock;
	private int sells;

	public Producto(String code, String name, double price, int stock, int sells) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.sells = sells;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void addStock(int stock) {
		this.stock += stock;
	}

	public int getSells() {
		return sells;
	}

	public void addSells(int sells) {
		this.sells += sells;
	}

}

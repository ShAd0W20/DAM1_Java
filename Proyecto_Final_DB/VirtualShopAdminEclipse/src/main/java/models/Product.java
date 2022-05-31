package main.java.models;

public class Product {
	private String id;
	private String name;
	private int stock;
	private double price;
	private int IVA;

	public Product(String id, String name, int stock, double price, int IVA) {
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.IVA = IVA;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getIVA() {
		return IVA;
	}

	public void setIVA(int IVA) {
		this.IVA = IVA;
	}
}

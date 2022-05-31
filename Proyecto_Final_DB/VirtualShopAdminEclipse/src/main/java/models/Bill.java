package main.java.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bill {
	private ArrayList<ShoppingCartProduct> products;
	private String billOwner;
	private String billID;
	private LocalDate billDate;

	public Bill(String billOwner, String billID) {
		this.billOwner = billOwner;
		this.billOwner = billID;
		this.products = new ArrayList<>();
	}

	public Bill(String billOwner) {
		this.billOwner = billOwner;
		this.products = new ArrayList<>();
	}

	public String getBillOwner() {
		return this.billOwner;
	}

	public ArrayList<ShoppingCartProduct> getProducts() {
		return this.products;
	}

	public void addProduct(ShoppingCartProduct p) {
		this.products.add(p);
	}

	public String getBillID() {
		return this.billID;
	}

	public void setBillID(String billID) {
		this.billID = billID;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public LocalDate getBillDate() {
		return this.billDate;
	}
}

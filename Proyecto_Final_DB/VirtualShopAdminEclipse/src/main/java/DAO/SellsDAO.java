package main.java.DAO;

import main.java.models.Bill;
import main.java.models.Product;
import main.java.models.ShoppingCartProduct;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SellsDAO extends ConnectionDAO {

	public String getAllBills() {
		String data = "";
		try {
			PreparedStatement stmt = this.conn().prepareStatement("SELECT b.billid, u.dni, u.name FROM bills b INNER JOIN users u ON b.userid = u.dni;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				data += String.format("%-20s %-20s %-20s%n", rs.getString("billid"), rs.getString("dni"), rs.getString("name"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return data;
	}

	public Bill getBillFromUser(String billOwner, String billID) {
		if (!new UserDAO().userExists(billOwner))
			return null;
		if (!this.existsBill(billID))
			return null;

		Bill bill = new Bill(billOwner);

		try {
			PreparedStatement stmt = this.conn().prepareStatement("SELECT p.id, p.name, p.stock, p.price, p.iva, c.productquantity, b.billdate, b.billid FROM bills b INNER JOIN shoppingcart c ON c.billid = b.billid INNER JOIN products p ON p.id = c.productid WHERE b.billid = ? AND b.userid = ?;");
			stmt.setString(1, billID);
			stmt.setString(2, billOwner);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				bill.addProduct(new ShoppingCartProduct(new Product(rs.getString("id"), rs.getString("name"), rs.getInt("stock"), rs.getDouble("price"), rs.getInt("iva")), rs.getInt("productquantity")));
				bill.setBillDate(rs.getDate("billdate").toLocalDate());
				bill.setBillID(rs.getString("billid"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return bill;
	}

	public ArrayList<Bill> getAllBillsFromUser(String billOwner) {
		if (!new UserDAO().userExists(billOwner))
			return null;

		ArrayList<Bill> userBills = new ArrayList<>();

		try {
			PreparedStatement stmt = this.conn().prepareStatement("SELECT p.id, p.name, p.stock, p.price, p.iva, c.productquantity, b.billdate, b.billid FROM bills b INNER JOIN shoppingcart c ON c.billid = b.billid INNER JOIN products p ON p.id = c.productid WHERE b.userid = ? GROUP BY b.billid, p.id, p.name, p.stock, p.price, p.iva, c.productquantity, b.billdate;");
			stmt.setString(1, billOwner);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Bill bill = new Bill(billOwner);
				bill.setBillID(rs.getString("billid"));
				bill.setBillDate(rs.getDate("billdate").toLocalDate());
				bill.addProduct(new ShoppingCartProduct(new Product(rs.getString("id"), rs.getString("name"), rs.getInt("stock"), rs.getDouble("price"), rs.getInt("iva")), rs.getInt("productquantity")));
				userBills.add(bill);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return userBills;
	}

	public ArrayList<Bill> getAllBillsFromUserBetweenDates(String billOwner, LocalDate startDate, LocalDate endDate) {
		if (!new UserDAO().userExists(billOwner))
			return null;

		ArrayList<Bill> userBills = new ArrayList<>();

		try {
			PreparedStatement stmt = this.conn().prepareStatement("SELECT p.id, p.name, p.stock, p.price, p.iva, c.productquantity, b.bildate, b.billid FROM bills b INNER JOIN shoppingcart c ON c.billid = b.billid INNER JOIN products p ON p.id = c.productid WHERE b.userid = ? AND (b.billdate BETWEEN ? AND ?);");
			stmt.setString(1, billOwner);
			stmt.setDate(2, Date.valueOf(startDate));
			stmt.setDate(3, Date.valueOf(endDate));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Bill bill = new Bill(billOwner);
				bill.setBillID(rs.getString("billid"));
				bill.setBillDate(rs.getDate("billdate").toLocalDate());
				bill.addProduct(new ShoppingCartProduct(new Product(rs.getString("id"), rs.getString("name"), rs.getInt("stock"), rs.getDouble("price"), rs.getInt("iva")), rs.getInt("productquantity")));
				userBills.add(bill);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return userBills;
	}

	public String getAllProductsStatistics() {
		StringBuilder data = new StringBuilder();
		try {
			PreparedStatement stmt = this.conn().prepareStatement("SELECT p.name, p.stock, SUM((SELECT COUNT(*) FROM shoppingcart WHERE productid = s.productid GROUP BY productid) * s.productquantity) as totalsells FROM shoppingcart s INNER JOIN products p ON p.id = s.productid GROUP BY s.productid, p.name, p.stock ORDER BY totalsells;");
			ResultSet rs = stmt.executeQuery();

			data.append(String.format("%-20s %-20s %-20s%n", "Nombre", "Stock", "Ventas"));
			
			while (rs.next()) {
				data.append(String.format("%-20s %-20s %-20s%n", rs.getString("name"), rs.getString("stock"), rs.getString("totalsells")));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return data.toString();
	}

	public String getProductStatistics(String productName) {
		StringBuilder data = new StringBuilder();
		Product p = new ProductDAO().getProductByName(productName);
		if (p == null)
			return String.format("%n%n[!] Product not found%n");

		try {
			PreparedStatement stmt = this.conn().prepareStatement("SELECT p.name, p.stock, SUM((SELECT COUNT(*) FROM shoppingcart WHERE productid = s.productid GROUP BY productid) * s.productquantity) as totalsells FROM shoppingcart s INNER JOIN products p ON p.id = s.productid WHERE p.id = ? GROUP BY s.productid, p.name, p.stock ORDER BY totalsells;");
			stmt.setString(1, p.getId());
			ResultSet rs = stmt.executeQuery();

			data.append(String.format("%-20s %-20s %-20s%n", "Nombre", "Stock", "Ventas"));
			
			while (rs.next()) {
				data.append(String.format("%-20s %-20s %-20s%n", rs.getString("name"), rs.getString("stock"), rs.getString("totalsells")));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return data.toString();
	}

	private boolean existsBill(String billID) {
		try {
			PreparedStatement stmt = this.conn().prepareStatement("SELECT * FROM bills WHERE billid = ?;");
			stmt.setString(1, billID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException e) {
			System.out.printf(e.getMessage());
		}
		return false;
	}
}

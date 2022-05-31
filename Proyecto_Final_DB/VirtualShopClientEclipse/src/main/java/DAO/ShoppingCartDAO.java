package main.java.DAO;

import main.java.models.ShoppingCart;
import main.java.models.ShoppingCartProduct;
import main.java.models.User;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class ShoppingCartDAO extends ConnectionDAO {
	public void addProductsToShoppingCart(@NotNull ShoppingCart cart, User user) {

		String billid = this.registerNewBillOrder(user);

		for (ShoppingCartProduct product : cart.getAllProducts()) {
			this.saveToShoppingCart(product, billid);
		}

	}

	private void saveToShoppingCart(@NotNull ShoppingCartProduct cart, String billid) {
		try {
			PreparedStatement stmt = this.conn().prepareStatement("INSERT INTO shoppingcart (productid, productquantity, billid) VALUES (?, ?, ?);");
			stmt.setString(1, cart.getProduct().getId());
			stmt.setInt(2, cart.getQuantity());
			stmt.setString(3, billid);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private @NotNull String registerNewBillOrder(@NotNull User u) {
		Random rnd = new Random();
		String billid = u.getDni() + rnd.nextInt(10000);
		try {
			PreparedStatement stmt = this.conn().prepareStatement("INSERT INTO bills (userid, billid) VALUES (?, ?);");
			stmt.setString(1, u.getDni());
			stmt.setString(2, billid);
			stmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return billid;
	}
}

package main.java.DAO;

import main.java.models.Product;
import main.java.models.ShoppingCartProduct;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO extends ConnectionDAO {

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement stmt = this.conn().prepareStatement("SELECT * FROM products;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getString("id"), rs.getString("name"), rs.getInt("stock"), rs.getDouble("price"), rs.getInt("iva")));
            }
            this.conn().close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return products;
    }

    public Product getProductByID(String id) {
    	return this.getAllProducts()
    			.stream()
    			.filter(p -> p.getId().equals(id))
    			.map(p -> new Product(
    					p.getId(), 
    					p.getName(), 
    					p.getStock(), 
    					p.getPrice(), 
    					p.getIVA()
    			))
    			.findFirst()
    			.orElse(null);
    }

    public Product getProductByName(String name) {
    	return this.getAllProducts()
    			.stream()
    			.filter(p -> p.getName().equals(name))
    			.map(p -> new Product(
    					p.getId(), 
    					p.getName(), 
    					p.getStock(), 
    					p.getPrice(), 
    					p.getIVA()
    			))
    			.findFirst()
    			.orElse(null);
    }

    public int getProductStock(Product p) {
        return getProductByName(p.getName()).getStock();
    }

    public void modifyProductStock(ShoppingCartProduct cart) {
        if(!productExists(cart.getProduct())) {
            return;
        }

        try {
            PreparedStatement stmt = this.conn().prepareStatement("UPDATE products SET stock = stock - ? WHERE id = ?;");
            stmt.setInt(1, cart.getQuantity());
            stmt.setString(2, cart.getProduct().getId());
            stmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private boolean productExists(Product p) {
        try {
            PreparedStatement stmt = this.conn().prepareStatement("SELECT id FROM products WHERE id = ?;");
            stmt.setString(1, p.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}

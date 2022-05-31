package DAO;

import models.Product;
import models.ShoppingCartProduct;
import org.jetbrains.annotations.NotNull;

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

    public boolean registerProduct(Product p) {
        if (productExists(p)) return false;

        try {
            PreparedStatement stmt = this.conn().prepareStatement("INSERT INTO products (id, name, stock, price, iva) VALUES (?, ?, ?, ?,?);");
            stmt.setString(1, p.getId());
            stmt.setString(2, p.getName());
            stmt.setInt(3, p.getStock());
            stmt.setDouble(4, p.getPrice());
            stmt.setInt(5, p.getIVA());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public Product getProductByID(String id) {
        try {
            PreparedStatement stmt = this.conn().prepareStatement("SELECT * FROM products WHERE id = ?;");
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(rs.getString("id"), rs.getString("name"), rs.getInt("stock"), rs.getDouble("price"), rs.getInt("iva"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Product getProductByName(String name) {
        try {
            PreparedStatement stmt = this.conn().prepareStatement("SELECT * FROM products WHERE name = ?;");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(rs.getString("id"), rs.getString("name"), rs.getInt("stock"), rs.getDouble("price"), rs.getInt("iva"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deleteProduct(Product p) {
        if(!productExists(p)) return;

        try {
            PreparedStatement stmt = this.conn().prepareStatement("DELETE FROM products WHERE id = ?;");
            stmt.setString(1, p.getId());
            stmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void modifyProductStock(@NotNull Product p, int stock) {
        if (!productExists(p)) {
            return;
        }

        try {
            PreparedStatement stmt = this.conn().prepareStatement("UPDATE products SET stock = stock + ? WHERE id = ?;");
            stmt.setInt(1, stock);
            stmt.setString(2, p.getId());
            stmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void modifyProductPrice(@NotNull Product p, double price) {
        if (!productExists(p)) {
            return;
        }

        try {
            PreparedStatement stmt = this.conn().prepareStatement("UPDATE products SET price = ? WHERE id = ?;");
            stmt.setDouble(1, price);
            stmt.setString(2, p.getId());
            stmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void modifyProductIVA(@NotNull Product p, int IVA) {
        if (!productExists(p)) {
            return;
        }

        try {
            PreparedStatement stmt = this.conn().prepareStatement("UPDATE products SET iva = ? WHERE id = ?;");
            stmt.setInt(1, IVA);
            stmt.setString(2, p.getId());
            stmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    private boolean productExists(@NotNull Product p) {
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

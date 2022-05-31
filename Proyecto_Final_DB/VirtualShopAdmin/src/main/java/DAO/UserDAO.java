package DAO;

import models.User;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends ConnectionDAO {

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement stmt = this.conn().prepareStatement("SELECT * FROM users;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getString("dni"), rs.getString("name"), rs.getString("password"), rs.getString("email"), rs.getString("phone"), rs.getString("address"));
                users.add(u);
            }
            this.conn().close();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return users;
    }

    public String getUserInfo(String dni) {
        if (!userExists(dni)) return String.format("%n%n[!] User doesn't exists%n");

        try {
            PreparedStatement stmt = this.conn().prepareStatement("SELECT * FROM users WHERE dni = ?;");
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return String.format("%-20s %-20s %-20s %-20s %-20s %n%-20s %-20s %-20s %-20s %-20s%n", "DNI", "Name", "Email", "Phone", "Address", rs.getString("dni"), rs.getString("name"), rs.getString("Email"), rs.getString("phone"), rs.getString("address"));
            }
            this.conn().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return String.format("%n%n[!] Something went wrong%n");
    }

    public boolean userExists(@NotNull String dni) {
        try {
            PreparedStatement stmt = this.conn().prepareStatement("SELECT * FROM users WHERE dni = ?;");
            stmt.setString(1, dni);
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

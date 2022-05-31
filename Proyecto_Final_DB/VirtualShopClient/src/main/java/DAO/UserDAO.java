package DAO;

import models.User;
import org.jetbrains.annotations.NotNull;
import utils.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends ConnectionDAO {

    public boolean register(@NotNull User u) {
        if (!userExists(u)) {
            try {
                PreparedStatement stmt = this.conn().prepareStatement("INSERT INTO users (dni, name, password, email, phone, address) VALUES (?, ?, ?, ?, ?, ?);");
                stmt.setString(1, u.getDni());
                stmt.setString(2, u.getName());
                stmt.setString(3, BCrypt.hashpw(u.getPassword()));
                stmt.setString(4, u.getEmail());
                stmt.setString(5, u.getPhone());
                stmt.setString(6, u.getAddress());
                stmt.execute();
                this.conn().close();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public User login(@NotNull User u) {
        User user = null;
        if (!userExists(u)) {
            return null;
        }

        try {
            PreparedStatement stmt = this.conn().prepareStatement("SELECT dni, password, name, email, phone, address FROM users WHERE dni = ?;");
            stmt.setString(1, u.getDni());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (BCrypt.checkpw(u.getPassword(), rs.getString("password"))) {
                    user = new User(rs.getString("dni"), rs.getString("password"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("address"));
                } else {
                    return u;
                }
            }
            this.conn().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    public boolean deleteUser(@NotNull User u) {
        if (userExists(u)) {
            try {
                PreparedStatement stmt = this.conn().prepareStatement("DELETE FROM users WHERE dni = ?;");
                stmt.setString(1, u.getDni());
                stmt.execute();
                this.conn().close();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean updatePassword(@NotNull User u) {
        if (userExists(u)) {
            try {
                PreparedStatement stmt = this.conn().prepareStatement("UPDATE users SET password = ? WHERE dni = ?;");
                stmt.setString(1, BCrypt.hashpw(u.getPassword()));
                stmt.setString(2, u.getDni());
                stmt.execute();
                this.conn().close();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean updateEmail(@NotNull User u) {
        if (userExists(u)) {
            try {
                PreparedStatement stmt = this.conn().prepareStatement("UPDATE users SET email = ? WHERE dni = ?;");
                stmt.setString(1, u.getEmail());
                stmt.setString(2, u.getDni());
                stmt.execute();
                this.conn().close();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean updatePhone(@NotNull User u) {
        if (userExists(u)) {
            try {
                PreparedStatement stmt = this.conn().prepareStatement("UPDATE users SET phone = ? WHERE dni = ?;");
                stmt.setString(1, u.getPhone());
                stmt.setString(2, u.getDni());
                stmt.execute();
                this.conn().close();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean updateAddress(@NotNull User u) {
        if (userExists(u)) {
            try {
                PreparedStatement stmt = this.conn().prepareStatement("UPDATE users SET address = ? WHERE dni = ?;");
                stmt.setString(1, u.getAddress());
                stmt.setString(2, u.getDni());
                stmt.execute();
                this.conn().close();
                return true;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    private boolean userExists(@NotNull User u) {
        try {
            PreparedStatement stmt = this.conn().prepareStatement("SELECT * FROM users WHERE dni = ?;");
            stmt.setString(1, u.getDni());
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

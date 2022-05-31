package main.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	private Connection conn;

	public ConnectionDAO() {
		dbConnection();
	}

	private void dbConnection() {
		try {
			this.conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/virtualShop", "postgres", "1234");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Connection conn() {
		return this.conn;
	}
}

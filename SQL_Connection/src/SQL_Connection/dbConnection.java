package SQL_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost/es_extended_2";
		String DBUser = "root";
		String DBPassword = "";
		String query = "SELECT * FROM users";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, DBUser, DBPassword);
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			
			while (result.next()) {
				String row = "";
				for (int i = 1; i <= 28; i++) {
					row += result.getString(i) + ",";
				}
				System.out.println(row);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

package databasezone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "system";
	public static final String PASS = "system";
	
	public static Connection getConnection() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL,USER, PASS);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("Error connectiong to the database", e);
		}
	}
}

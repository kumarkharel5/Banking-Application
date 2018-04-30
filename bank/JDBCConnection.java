package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	Connection getConnection() throws ClassNotFoundException, SQLException {

		// step1 load the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// step2 create the connection object
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		return con;
	}
}

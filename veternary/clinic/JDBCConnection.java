package com.veternary.clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
	
	Connection conn;
	Statement stmt;
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		conn = null;
		Class.forName(driver);
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		return conn;
	}
	
	public void createTable() throws SQLException, ClassNotFoundException {
		String createSql = "create table pet(name varchar2(30), owner varchar2(30), age number(20), breed varchar2(100), medicalhistory varchar2(100), vaccination varchar2(30), appointment varchar2(100))";
		conn = null;
		conn = getConnection();
		stmt = conn.createStatement();
		stmt.executeQuery(createSql);
		conn.close();
		System.out.println("pet table has been added");
	}
}

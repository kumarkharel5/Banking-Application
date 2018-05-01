package com.addressbook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SortClass {
	Connection con;
	ResultSet rs; 
	Statement stmt;
	AddressBook ab;
	
	public void sortByFirstName() throws SQLException, ClassNotFoundException {
		con = null;
		con = ab.getConnection();
		String sql = "SELECT * FROM ADDRESS ORDER BY FIRSTNAME ASC";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("FIRSTNAME")+"  "+rs.getString("LASTNAME")+"  "+rs.getInt("PHONENUMBER")+"  "
					+rs.getInt("DATEOFBIRTH")+"  "+rs.getString("ADDRESS")+"  "+rs.getString("EMAILADDRESS"));
		}
		rs.close();
		con.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SortClass sc = new SortClass();
		sc.sortByFirstName();
	}
}

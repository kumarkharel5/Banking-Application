package com.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class AddressBook {
	int i;
	Address ad = new Address();

	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;

	Scanner scan = new Scanner(System.in);

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		stmt = con.createStatement();
		System.out.println("connection is successfull....");
		return con;
	}
	
	public void addEntry() {
		con = null;
		while (i < 10) {
			System.out.println("Enter First Name");
			ad.setFirstName(scan.next()); 
			System.out.println("Enter Last Name");
			ad.setLastName(scan.next());
			System.out.println("Enter Phone Number");
			ad.setPhoneNumber(scan.nextInt());
			System.out.println("Enter Date of Birth");
			int dob = scan.nextInt();
			System.out.println("Enter Address");
			String add = scan.next();
			System.out.println("Enter Email Address");
			String eadd = scan.next();
			try {
				con = getConnection();
				pstmt = con.prepareStatement("INSERT INTO ADDRESS VALUES(?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, ad.getFirstName());
				pstmt.setString(2, ad.getLastName());
				pstmt.setInt(3, ad.getPhoneNumber());
				pstmt.setInt(4, dob);
				pstmt.setString(5, add);
				pstmt.setString(6, eadd);
				pstmt.executeUpdate();
				i++;
				System.out.println(i + " records are inserted....");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
			} finally {
				try {
					con.close();
					pstmt.close();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
			System.out.println("Enter N to Exit");
			String str = scan.next();
			if (str.contains("N")) {
				break;
			}
		}
	}

	public void deleteEntry() throws ClassNotFoundException, SQLException {
		con = null;
		while (i != 0) {
			con = getConnection();
			System.out.println("Enter FirstName to delete");
			String firstName = scan.next();
			String deleteSql = "DELETE from ADDRESS WHERE FIRSTNAME = " + firstName;
			rs = stmt.executeQuery(deleteSql);
			System.out.println("row has been deleted");
			con.close();
			System.out.println("Enter N to Exit");
			String str = scan.next();
			if (str.contains("N")) {
				break;
			}
		}
	}

	public void viewEntry() throws SQLException, ClassNotFoundException {
		System.out.println("Enter number below to sort entries by specific order"
				+ "\n1 -- FirstName\n2 -- LastName\n3 -- DateOfBirth\n4 -- PhoneNumber\n5 -- Address\n6 -- EmailAddress");
		int value = scan.nextInt();
		if (value > 6) {
			System.out.println("Invalid action");
		} else {
			switch (Integer.valueOf(value)) {
			case 1:
				sortByFirstName();
				break;
			case 2:
				sortByLastName();
				break;
			case 3:
				sortByDateOfBirth();
				break;
			case 4:
				sortByPhoneNumber();
				break;
			case 5:
				sortByAddress();
				break;
			case 6:
				sortByEmailAddress();
				break;
			default:
				break;
			}
		}
	}

	public void updateByPhoneNumer() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		System.out.println("Enter FirstName to update your record");
		String str = scan.next();
		System.out.println("enter your value for PhoneNumber to update");
		int tphone = scan.nextInt();
		String updateSql = "UPDATE ADDRESS SET PHONENUMBER = " + tphone + " WHERE FIRSTNAME = " + str;
		rs = stmt.executeQuery(updateSql);
		System.out.println("update is completed");
		rs.close();
		con.close();
	}

	public void updateEntryByFirstName() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		System.out.println("Enter FirstName to update your record");
		String str = scan.next();
		System.out.println("enter your value for FirstName to update");
		String fName = scan.next();
		String updateSql = "UPDATE ADDRESS SET FIRSTNAME = " + fName + " WHERE FIRSTNAME = " + str;
		rs = stmt.executeQuery(updateSql);
		System.out.println("update is completed");
		rs.close();
		con.close();
	}

	public void updateEntryByLastName() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		System.out.println("Enter LastName to update your record");
		String str = scan.next();
		System.out.println("enter your value for LastName to update");
		String lName = scan.next();
		String updateSql = "UPDATE ADDRESS SET LASTNAME = " + lName + " WHERE FIRSTNAME = " + str;
		rs = stmt.executeQuery(updateSql);
		System.out.println("update is completed");
		rs.close();
		con.close();
	}

	public void updateEntryByDateOfBirth() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		System.out.println("Enter FirstName to update your record");
		String str = scan.next();
		System.out.println("enter your value for DateOfBirth to update");
		int dob = scan.nextInt();
		String updateSql = "UPDATE ADDRESS SET DATEOFBIRTH = " + dob + " WHERE FIRSTNAME = " + str;
		rs = stmt.executeQuery(updateSql);
		System.out.println("update is completed");
		rs.close();
		con.close();
	}

	public void updateEntryByAddress() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		System.out.println("Enter FirstName to update your record");
		String str = scan.next();
		System.out.println("enter your value for Address to update");
		String add = scan.next();
		String updateSql = "UPDATE ADDRESS SET ADDRESS = " + add + " WHERE FIRSTNAME = " + str;
		rs = stmt.executeQuery(updateSql);
		System.out.println("update is completed");
		rs.close();
		con.close();
	}

	public void updateEntryByEmailAddress() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		System.out.println("Enter FirstName to update your record");
		String str = scan.next();
		System.out.println("enter your value for EmailAddress to update");
		String eAdd = scan.next();
		String updateSql = "UPDATE ADDRESS SET EMAILADDRESS = " + eAdd + " WHERE FIRSTNAME = " + str;
		rs = stmt.executeQuery(updateSql);
		System.out.println("update is completed");
		rs.close();
		con.close();
	}

	public void updateEntry() throws SQLException, ClassNotFoundException {
		System.out.println("Enter number below to update values"
				+ "\n1 -- FirstName\n2 -- LastName\n3 -- DateOfBirth\n4 -- PhoneNumber\n5 -- Address\n6 -- EmailAddress");
		int value = scan.nextInt();
		if (value > 6) {
			System.out.println("Invalid action");
		} else {
			switch (Integer.valueOf(value)) {
			case 1:
				updateEntryByFirstName();
				break;
			case 2:
				updateEntryByLastName();
				break;
			case 3:
				updateByPhoneNumer();
				break;
			case 4:
				updateEntryByDateOfBirth();
				break;
			case 5:
				updateEntryByAddress();
				break;
			case 6:
				updateEntryByEmailAddress();
				break;
			default:
				break;
			}
		}
	}

	public void sortByFirstName() throws SQLException, ClassNotFoundException {
		con = null;
		con = getConnection();
		String sql = "SELECT * FROM ADDRESS ORDER BY FIRSTNAME ASC";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("FIRSTNAME") + "  " + rs.getString("LASTNAME") + "  "
					+ rs.getInt("PHONENUMBER") + "  " + rs.getInt("DATEOFBIRTH") + "  " + rs.getString("ADDRESS") + "  "
					+ rs.getString("EMAILADDRESS"));
		}
		rs.close();
		con.close();
	}

	public void sortByLastName() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		String sql = "SELECT * FROM ADDRESS ORDER BY LASTNAME ASC";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("FIRSTNAME") + "  " + rs.getString("LASTNAME") + "  "
					+ rs.getInt("PHONENUMBER") + "  " + rs.getInt("DATEOFBIRTH") + "  " + rs.getString("ADDRESS") + "  "
					+ rs.getString("EMAILADDRESS"));
		}
		rs.close();
		con.close();
	}

	public void sortByDateOfBirth() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		String sql = "SELECT * FROM ADDRESS ORDER BY DATEOFBIRTH ASC";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("FIRSTNAME") + "  " + rs.getString("LASTNAME") + "  "
					+ rs.getInt("PHONENUMBER") + "  " + rs.getInt("DATEOFBIRTH") + "  " + rs.getString("ADDRESS") + "  "
					+ rs.getString("EMAILADDRESS"));
		}
		rs.close();
		con.close();
	}

	public void sortByPhoneNumber() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		String sql = "SELECT * FROM ADDRESS ORDER BY PHONENUMBER ASC";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("FIRSTNAME") + "  " + rs.getString("LASTNAME") + "  "
					+ rs.getInt("PHONENUMBER") + "  " + rs.getInt("DATEOFBIRTH") + "  " + rs.getString("ADDRESS") + "  "
					+ rs.getString("EMAILADDRESS"));
		}
		rs.close();
		con.close();
	}

	public void sortByAddress() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		String sql = "SELECT * FROM ADDRESS ORDER BY ADDRESS ASC";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("FIRSTNAME") + "  " + rs.getString("LASTNAME") + "  "
					+ rs.getInt("PHONENUMBER") + "  " + rs.getInt("DATEOFBIRTH") + "  " + rs.getString("ADDRESS") + "  "
					+ rs.getString("EMAILADDRESS"));
		}
		rs.close();
		con.close();
	}

	public void sortByEmailAddress() throws ClassNotFoundException, SQLException {
		con = null;
		con = getConnection();
		String sql = "SELECT * FROM ADDRESS ORDER BY EMAILADDRESS ASC";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getString("FIRSTNAME") + "  " + rs.getString("LASTNAME") + "  "
					+ rs.getInt("PHONENUMBER") + "  " + rs.getInt("DATEOFBIRTH") + "  " + rs.getString("ADDRESS") + "  "
					+ rs.getString("EMAILADDRESS"));
		}
		rs.close();
		con.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AddressBook abook = new AddressBook();
		System.out.println(
				"Choose from the following\n" + "1 -- AddEntry\n2 -- DeleteEntry\n3 -- ViewEntry\n4 -- UpdateEntry");
		int str = abook.scan.nextInt();
		if (str > 6) {
			System.out.println("Invalid action");
		} else {
			switch (Integer.valueOf(str)) {
			case 1:
				abook.addEntry();
				break;
			case 2:
				abook.deleteEntry();
				break;
			case 3:
				abook.viewEntry();
				break;
			case 4:
				abook.updateEntry();
				break;
			default:
				break;
			}
		}
	}
}

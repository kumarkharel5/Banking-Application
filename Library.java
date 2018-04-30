package com.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Library {
	static Connection con;
	static Statement stmt;
	static PreparedStatement pstmt;
	static ResultSet rs;

	static Scanner scan = new Scanner(System.in);

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		stmt = con.createStatement();
		System.out.println("connection successfull....");
		return con;
	}

	private static void exitProgram() {
		while (true) {
			System.out.println("Enter Y/N to proceed...");
			String str = scan.next();
			if (str.equals("N")) {
				return;
			}
		}
	}

	private static void deleteLibrarian() {
		con = null;
		while (true) {
			try {
				con = Library.getConnection();
				System.out.println("Enter librarian's name to be deleted");
				String name = scan.next();
				String deleteSql = "DELETE FROM LIBRARIAN WHERE NAME =" + name;
				rs = stmt.executeQuery(deleteSql);
				System.out.println("deleted successfully.....");
				System.out.println("Enter Y/N to proceed...");
				String str = scan.next();
				if (str.equals("N")) {
					return;
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					rs.close();
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

	private static void viewLibrarian() throws SQLException, ClassNotFoundException {
		String createSql = "select * from librarian";
		con = Library.getConnection();
		rs = stmt.executeQuery(createSql);
		System.out.println("Information of librarians.......");
		while (rs.next()) {
			System.out.println(rs.getString("NAME") + "  " + rs.getString("EMAIL") + "  " + rs.getInt("EMPLOYEENUMBER")
					+ "  " + rs.getString("CITY") + "  " + rs.getInt("PHONENUMBER"));
		}
		con.close();
	}

	private static void addlibrarian() {
		con = null;
		while (true) {
			System.out.println("Enter librarian details......\nEnter name");
			String name = scan.next();
			System.out.println("Enter email address");
			String email = scan.next();
			System.out.println("Enter employee number");
			int empNum = scan.nextInt();
			System.out.println("Enter city");
			String city = scan.next();
			System.out.println("Enter phone number");
			int phnum = scan.nextInt();
			try {
				con = Library.getConnection();
				pstmt = con.prepareStatement("insert into Librarian values(?, ?, ?, ?, ?)");
				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.setInt(3, empNum);
				pstmt.setString(4, city);
				pstmt.setInt(5, phnum);
				pstmt.executeUpdate();
				System.out.println("records are successfully entered.....");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
			} finally {
				try {
					con.close();
					pstmt.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			System.out.println("Enter Y/N to proceed...");
			String str = scan.next();
			if (str.equals("N")) {
				return;
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Enter the choice from below\n\n"
				+ "1 -- Add Librarian\n2 -- View Librarian\n3 -- Delete Librarian\n4 -- Exit Program");
		int libChoice = scan.nextInt();
		if (libChoice > 4) {
			System.out.println("no option is available for this input");
		} else {
			switch (Integer.valueOf(libChoice)) {
			case 1:
				addlibrarian();
				break;
			case 2:
				viewLibrarian();
				break;
			case 3:
				deleteLibrarian();
				break;
			case 4:
				exitProgram();
				break;
			}
		}
	}
}

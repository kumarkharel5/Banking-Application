package com.college.enrollmet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {

	StudentInformation sin = new StudentInformation();
	JDBCConnection jdbc = new JDBCConnection();
	Scanner scan = new Scanner(System.in);
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public void addStudent() throws ClassNotFoundException, SQLException {
		conn = jdbc.getConnection();
		String op_input = "y";
		while (op_input.equalsIgnoreCase("y")) {
			System.out.println("Please Enter Student's Name");
			sin.setName(scan.next());
			System.out.println("Please Enter Student's Phone");
			sin.setPhone(scan.nextLong());
			System.out.println("Please Enter Student's Address");
			sin.setAddress(scan.next());
			System.out.println("Please Enter Student's Grade");
			sin.setGrade(scan.next());
			pstmt = conn
					.prepareStatement("Insert into STUDENTS(STUDENTNAME, PHONE, ADDRESS, GRADE) values(?, ?, ?, ?)");
			pstmt.setString(1, sin.getName());
			pstmt.setLong(2, sin.getPhone());
			pstmt.setString(3, sin.getAddress());
			pstmt.setString(4, sin.getGrade());
			pstmt.executeUpdate();
			System.out.println("Do you wish to continue(Y/N)...");
			op_input = scan.next();
		}
		conn.close();
	}

	public void updateStudent() throws ClassNotFoundException, SQLException {
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		System.out.println("Please Enter Student ID to update");
		int id = scan.nextInt();
		String selectSql = "select * from students where id = " + id;
		rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			sin.setId(rs.getInt("ID"));
			if (id == sin.getId()) {
				System.out.println("1) Name\n2) Phone\n3) Address\n4) Grade");
				int opt = scan.nextInt();
				if (opt >= 1 && opt <= 4) {
					switch (opt) {
					case 1:
						System.out.println("Enter Student's name to change");
						String name = scan.next();
						stmt.executeUpdate("update STUDENTS set STUDENTNAME = " + name + "where ID = " + id);
						break;
					case 2:
						System.out.println("Enter Student's Phone Numer to change");
						String phnum = scan.next();
						stmt.executeUpdate("update STUDENTS set PHONE = " + phnum + "where ID = " + id);
						break;
					case 3:
						System.out.println("Enter Student's Address to change");
						String Address = scan.next();
						stmt.executeUpdate("update STUDENTS set ADDRESS = " + Address + "where ID = " + id);
						break;
					case 4:
						System.out.println("Enter Student's Grade to change");
						String grade = scan.next();
						stmt.executeUpdate("update STUDENTS set GRADE = " + grade + "where ID = " + id);
						break;
					}
				} else {
					System.out.println("Invalid Option....");
				}
			}
		} else {
			System.out.println("Invalid ID");
		}
	}

	public void listStudent() throws ClassNotFoundException, SQLException {
		String selectSql = "select * from students";
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(selectSql);
		while (rs.next()) {
			System.out.println(rs.getInt("ID") + ", " + rs.getString("STUDENTNAME") + ", " + rs.getDouble("PHONE")
					+ ", " + rs.getString("ADDRESS") + ", " + rs.getString("GRADE"));
		}
		conn.close();
	}

	public void removeStudent() throws ClassNotFoundException, SQLException {
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		System.out.println("Please Enter Student ID to update");
		int id = scan.nextInt();
		String selectSql = "select * from students where id = " + id;
		rs = stmt.executeQuery(selectSql);
		if (rs.next()) {
			sin.setId(rs.getInt("ID"));
			if (id == sin.getId()) {
				String deleteSql = "delete from Students where id = " + id;
				stmt.executeQuery(deleteSql);
			}
		} else {
			System.out.println("Invalid ID ");
		}
		conn.close();
	}
}

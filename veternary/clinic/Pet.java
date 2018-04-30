package com.veternary.clinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Pet {
	JDBCConnection jdbc = new JDBCConnection();
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	Scanner scan = new Scanner(System.in);
	Record rec = new Record();
	
	public void getMedList() throws ClassNotFoundException, SQLException {
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		System.out.println("Enter name to view details");
		rec.setName(scan.next());
		rs = stmt.executeQuery("select * from medhistory where name = " + rec.getName());
		while(rs.next()) {
			System.out.println(rs.getString(2));
		}
		conn.close();
	}
	
	public void addMedHist() throws ClassNotFoundException, SQLException {
		System.out.println("Press Y to register Medical history for your pet");
		String ent = scan.next();
		while(ent.equalsIgnoreCase("Y")) {
			System.out.println("Enter dog's name");
			rec.setName(scan.next());
			System.out.println("Enter medical history:");
			rec.setMedicalHistory(scan.next());
			String insertMedHistory = "insert into MedHistory values(?, ?)";
			conn = jdbc.getConnection();
			pstmt = conn.prepareStatement(insertMedHistory);
			pstmt.setString(1, rec.getName());
			pstmt.setString(2, rec.getMedicalHistory());
			pstmt.executeUpdate();
			System.out.println("Enter N to exit the loop");
			String exit = scan.next();
			if(exit.equalsIgnoreCase("N")) {
				return;
			}
			conn.close();
		}
	}
	
	public void removeMedHist() throws ClassNotFoundException, SQLException {
		System.out.println("Please Enter pet's name to delete any medical history associated with it");
		rec.setName(scan.next());
		String deleteSql = "delete from MEDHISTORY where NAME = " + rec.getName();
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(deleteSql);
		conn.close();
	}
	
	public void getVaccinations() throws ClassNotFoundException, SQLException {
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		System.out.println("Enter name to view vaccination details");
		rec.setName(scan.next());
		rs = stmt.executeQuery("select * from vaccination where name = " + rec.getName());
		while(rs.next()) {
			System.out.println(rs.getString(2));
		}
		conn.close();
	}
	
	public void addVaccination() throws ClassNotFoundException, SQLException {
		System.out.println("Press Y to register vaccination history for your pet");
		String ent = scan.next();
		while(ent.equalsIgnoreCase("Y")) {
			System.out.println("Enter dog's name");
			rec.setName(scan.next());
			System.out.println("Enter vaccination:");
			rec.setVaccination(scan.next());
			String insertMedHistory = "insert into vaccination values(?, ?)";
			conn = jdbc.getConnection();
			pstmt = conn.prepareStatement(insertMedHistory);
			pstmt.setString(1, rec.getName());
			pstmt.setString(2, rec.getVaccination());
			pstmt.executeUpdate();
			System.out.println("Enter N to exit the loop");
			String exit = scan.next();
			if(exit.equalsIgnoreCase("N")) {
				return;
			}
			conn.close();
		}
	}
	
	public void removeVaccination() throws ClassNotFoundException, SQLException {
		System.out.println("Please Enter pet's name to delete any vaccine history associated with it");
		rec.setName(scan.next());
		String deleteSql = "delete from vaccination where NAME = " + rec.getName();
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(deleteSql);
		conn.close();
	}
	
	public void getAppointments() throws ClassNotFoundException, SQLException {
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		System.out.println("Enter name to view appointment details");
		rec.setName(scan.next());
		rs = stmt.executeQuery("select * from appointment where name = " + rec.getName());
		while(rs.next()) {
			System.out.println(rs.getString("name")+ " " + rs.getString("day") + " " + rs.getString("month") + " " + rs.getInt("year") + " " + rs.getInt("time"));
		}
		conn.close();
	}
	
	public void addAppointments() throws ClassNotFoundException, SQLException {
		System.out.println("Press Y to add appointment for your pet");
		String ent = scan.next();
		while(ent.equalsIgnoreCase("Y")) {
			System.out.println("Enter dog's name");
			rec.setName(scan.next());
			System.out.println("Enter day:");
			rec.setDay(scan.next());
			System.out.println("Enter Month:");
			rec.setMonth(scan.next());
			System.out.println("Enter year:");
			rec.setYear(scan.nextInt());
			System.out.println("Enter time:");
			rec.setTime (scan.next());
			String insertMedHistory = "insert into appointment values(?, ?, ?, ?, ?)";
			conn = jdbc.getConnection();
			pstmt = conn.prepareStatement(insertMedHistory);
			pstmt.setString(1, rec.getName());
			pstmt.setString(2, rec.getDay());
			pstmt.setString(3, rec.getMonth());
			pstmt.setInt(4, rec.getYear());
			pstmt.setString(5, rec.getTime());
			pstmt.executeUpdate();
			System.out.println("records inseted");
			System.out.println("Enter N to exit the loop");
			String exit = scan.next();
			if(exit.equalsIgnoreCase("N")) {
				return;
			}
			conn.close();
		}
	}
	
	public void resolveAppointment() throws ClassNotFoundException, SQLException {
		System.out.println("Please Enter pet's name to delete any appointment associated with it");
		rec.setName(scan.next());
		String deleteSql = "delete from appointment where NAME = " + rec.getMedicalHistory();
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(deleteSql);
		conn.close();
	}
	
}

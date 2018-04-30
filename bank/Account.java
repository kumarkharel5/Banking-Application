package com.bank;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Account {
	JDBCConnection jdbc = new JDBCConnection();
	Connection conn;
	Statement stmt;
	
	double balance;
	double interest;
	
	void withdraw(double amount_to_deposit, SavingsAccount obj) throws ClassNotFoundException, SQLException{
		balance -= amount_to_deposit;
		String depAmount = "update Accounts set balance = " + balance + "where accountnumber = " + obj.accountNumber;
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		stmt.executeUpdate(depAmount);
		System.out.println("Amount after deposited = " + balance);
	}
	
	void deposit(double amount_to_deposit, SavingsAccount obj) throws ClassNotFoundException, SQLException{
		balance += amount_to_deposit;
		String depAmount = "update Accounts set balance = " + balance + "where accountnumber = " + obj.accountNumber;
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		stmt.executeUpdate(depAmount);
		System.out.println("Amount after deposited = " + balance);
	}
	
	abstract void interest(double amount);
	
}

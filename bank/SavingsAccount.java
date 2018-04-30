package com.bank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SavingsAccount extends Account{
	Connection conn;
	Statement stmt;
	ResultSet rs;
	Scanner s = new Scanner(System.in);
	int accountNumber;
	String user;
	
	SavingsAccount(String uname, int accno, double balance){
		this.accountNumber = accno;
		this.user = uname;
		this.balance = balance;
	}

	@Override
	void interest(double interest) {
		this.interest = interest;
	}
	
	void checkBalance(int accno) throws ClassNotFoundException, SQLException{
		System.out.println("Balance = " + balance);
	}
	
	void fixedDeposit(double amt, SavingsAccount acc) throws ClassNotFoundException, SQLException {
		interest(0.02);
		double amount = amt+(amt*interest);
		deposit(amount, acc);
	}
	
	void transferMoney(int acc1, int acc2) throws ClassNotFoundException, SQLException{
		String selectSql = "select * from accounts where accountnumber = " + acc2;
	
		conn = jdbc.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(selectSql);
		
		if(rs.next()) {
			System.out.println("enter amount to transfer");
			double amount = s.nextDouble();
			
			String depositSql = "update Accounts set balance = " + (rs.getDouble("balance")+amount) + "where accountnumber = " + acc2;
			String withdrawSql = "update Accounts set balance = " + (balance-amount) + "where accountnumber = " + acc1;
		
			if(amount<=balance) {
				stmt.executeUpdate(withdrawSql);
				stmt.executeUpdate(depositSql);
			} else {
				System.out.println("you do not have enough amount for transfer............");
			}
		} else {
			System.out.println("Invalid Account Number....");
		}
	}
}

package com.bankingapplication.copy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Banking {
	static Statement stmt;
	static ResultSet rs;
	PreparedStatement ps;
	
	static Scanner scan = new Scanner(System.in);
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		stmt = con.createStatement();
		return con;
	}
	
	public static SavingAccount getAccountDetails(int accountNumber) {
		Connection con = null;
		SavingAccount savingAccount = new SavingAccount();
		try {
			con = Banking.getConnection();
			rs = stmt.executeQuery("select * from ACCOUNTS where ACCOUNTNUMBER = " + accountNumber);
			while (rs.next()) {
				savingAccount.setUser(rs.getString("NAME"));
				savingAccount.setAccNumber(Integer.valueOf(rs.getString("ACCOUNTNUMBER")));
				savingAccount.setBalance(rs.getInt("BALANCE"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return savingAccount;
	}
	
	private static void transferMoney(SavingAccount savingsAccount) {
		System.out.println("Enter transfer amount: ");
		double amount = scan.nextDouble();
		SavingAccount senderAccount = savingsAccount;
		if(amount<=senderAccount.getBalance()) {
			System.out.println("Enter the account Number to transfer amount: ");
			int accountNumber = scan.nextInt();
			SavingAccount receiverAccount = getAccountDetails(accountNumber);
			receiverAccount.deposit(amount);
			senderAccount.withdraw(amount);
			updateAccounts(receiverAccount);
			updateAccounts(senderAccount);
		} else {
			System.out.println("Entered amount is greater than your current balance.");
		}
	}

	private static void updateAccounts(SavingAccount savingsAccount) {
		Connection con = null;
		try {
			con=Banking.getConnection();
			stmt.executeQuery("update Accounts set Balance ="+savingsAccount.getBalance()+"where AccountNumber="+savingsAccount.getAccNumber());
			System.out.println("After update "+savingsAccount.toString());
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
	
	private static void fixedDeposit(SavingAccount savingsAccount) {
		System.out.println("Enter the amount for fixed deposit");
		double amount = scan.nextDouble();
		savingsAccount.setInterest(0.02);
		Double newBalance = amount+(amount*savingsAccount.getInterest());
		savingsAccount.deposit(newBalance);
		updateAccounts(savingsAccount);
	}

	private static void checkBalance(SavingAccount savingsAccount) {
		System.out.println("Balance = "+savingsAccount.getBalance());
	}

	private static void withdraw(SavingAccount savingsAccount) {
		System.out.println("Enter withdraw amount: ");
		double amount = scan.nextDouble();
		savingsAccount.withdraw(amount);
		updateAccounts(savingsAccount);
	}

	private static void deposit(SavingAccount savingsAccount) {
		System.out.println("Enter deposit amount: ");
		double amount = scan.nextDouble();
		savingsAccount.deposit(amount);
		updateAccounts(savingsAccount);
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println("Enter the account number....");
		int accountNumber = scan.nextInt();
		SavingAccount savingsAccount = getAccountDetails(accountNumber);
		System.out.println("Choose option: \n");
		System.out.println("1-Cash Deposit\n2-Cash Withdrawal\n3-CheckBalance\n4-Fixed Deposit\n5-Transfer Money");
		int action = scan.nextInt();
		if(action>5) {
			System.out.println("Invalid action");
		} else {
			switch (Integer.valueOf(action)) {
			case 1:
				deposit(savingsAccount);
			case 2:
				withdraw(savingsAccount);
			case 3:
				checkBalance(savingsAccount);
			case 4:
				fixedDeposit(savingsAccount);
			case 5:
				transferMoney(savingsAccount);
			} 
		}		
	}
}

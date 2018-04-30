package com.bank;

import java.sql.*;
import java.util.Scanner;

public class Banking {
	//step1: Write code to prompt the user to enter the account number.
	
	//Step 2: When users enters the account number, the program should fetch account details of particular user from database table Accounts and store the values in SavingsAccount object.
	
	public static void main(String[] agrs){
		
		int accno, option_selected;
		SavingsAccount accobj = null;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please enter the Account Number");
		accno = s.nextInt();
		
		try{

			Connection con = new JDBCConnection().getConnection();
			//step3 create the statement object  
			Statement stmt=con.createStatement();
			
			//query to fetch the account details
			ResultSet rs=stmt.executeQuery("select * from accounts where Accountnumber = "+ accno);  
			
			if(rs.next()){
				
				accobj = new SavingsAccount(rs.getString("NAME"), rs.getInt("ACCOUNTNUMBER"), rs.getDouble("BALANCE"));
				
				System.out.println("Plese select the option:");
				System.out.println("1) Cash Deposit");
				System.out.println("2) Cash Withdrawal");
				System.out.println("3) CheckBalance");
				System.out.println("4) Fixed Deposit");
				System.out.println("5) Transfer Money");
				
				option_selected = s.nextInt();
				
				if(option_selected>= 1 && option_selected<=5){
					
					switch(option_selected){
					
					case 1: 
						//deposit cash
						double amount_to_deposit;
						System.out.println("Please enter amount to deposit");
						amount_to_deposit = s.nextDouble();
						accobj.deposit(amount_to_deposit,accobj);
						break;
					case 2: 
						//withdraw
						double amount_to_withdraw;
						System.out.println("Please enter amount to withdraw");
						amount_to_withdraw = s.nextDouble();
						accobj.withdraw(amount_to_withdraw,accobj);
						break;
					case 3:
						//check balance
						accobj.checkBalance(accno);
						break;
					case 4:
						//fixed deposit;
						System.out.println("enter amount for fixed deposit....");
						double amount_fixed_deposit = s.nextDouble();
						accobj.fixedDeposit(amount_fixed_deposit, accobj);
						break;
					case 5:
						//transfer money;
						System.out.println("enter recievers account number");
						int acc2 = s.nextInt();
						accobj.transferMoney(accno, acc2);
						break;
					}
					
				}else{
					System.out.println("Invalid option selected");
				}
				
			}else{
				System.out.println("Invalid Account Number!");
			}

			//step5 close the connection object  
			con.close();  
		}catch(Exception e){
			e.printStackTrace();
		}  
		  
	}
	
}

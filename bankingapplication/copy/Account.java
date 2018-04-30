package com.bankingapplication.copy;

public abstract class Account {
	
	double balance;
	double interest;
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
	}
	
	public abstract void interest(double amount);
	
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", interest=" + interest + "]";
	}
	
}

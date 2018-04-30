package com.bankingapplication.copy;

public class SavingAccount extends Account {
	
	private int accNumber;
	private String name;

	@Override
	public void interest(double amount) {
		this.interest = amount;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public String getName() {
		return name;
	}

	public void setUser(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SavingAccount [accNumber=" + accNumber + ", name=" + name + ", balance=" + balance + ", interest="
				+ interest + "]";
	}

}

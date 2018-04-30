package com.cablecompanybilling;

import java.util.Scanner;

public class CableComp {
	
	int channel, connection;
	String customer;
	float billProcessing;
	float basicService;
	float premium;
	float value;
	int accNumber;
	
	Scanner scan = new Scanner(System.in);
	
	public void enterAccNumber() {
		System.out.println("Enter Account Number");
		accNumber = scan.nextInt();	
		System.out.println("Enter customer code");
		customer = scan.next();
	}
	
	public void resindentalCustomer() {
		billProcessing = 4.50f;
		basicService = 20.50f;
		premium = 7.50f;
		System.out.println("How many channels would you like to add");
		channel = scan.nextInt();
		value = billProcessing + basicService + (premium*channel);
		System.out.println("Your total bill is "+value);
	}
	
	public void businessCustomer() {
		int connection = 10;
		billProcessing = 15.00f;
		premium = 50.00f;
		basicService=75.00f;
		System.out.println("How many channels would you like to add");
		channel = scan.nextInt();
		System.out.println("How many connections would you like to add");
		connection = scan.nextInt();
		if(connection == 10) {
			basicService=75.00f;
			value = billProcessing + (basicService) + (premium*channel);
			System.out.println("Your total bill is "+value);
		} else if(connection>10) {
			basicService=basicService+5.00f;
			value = billProcessing + (basicService*(connection-10)) + (premium*channel);
			System.out.println("Your total bill is "+value);
		}
		
	}
	
	public void selectCustomer() {
		enterAccNumber();
		if(accNumber > 1000 && accNumber < 9999 && customer.equals("r")) {
			System.out.println("This account and code is for residental customers ");
			resindentalCustomer();
		} else if(accNumber > 10000 && accNumber < 99999 && customer.equals("b")) {
			System.out.println("This account is for business customers ");
			businessCustomer();
		}else {
			System.out.println("You have entered wrong Account Number or code");
		}
	} 
	
	public static void main(String[] args) {
		CableComp cc = new CableComp();
		cc.selectCustomer();
	}
}

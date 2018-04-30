package com.aggregation;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateEmployee {
	
	public static void main(String[] args) {
		
		ArrayList<Employee> employee = new ArrayList<>();
		Scanner	scan = new Scanner(System.in);
		
		Address ad1 = new Address();
		System.out.println("Enter Employer's cityName");
		String strr = scan.next();
		ad1.setCityName(strr);
		System.out.println("Enter Employer's streetName");
		String strr2 = scan.next();
		ad1.setStreetName(strr2);
		System.out.println("Enter Employer's zipcode");
		int vall1 = scan.nextInt();
		ad1.setZipCode(vall1);
		
		Employer emr = new Employer();
		System.out.println("Enter Employer name");
		String stg = scan.next();
		emr.setName(stg);
		System.out.println("Enter yearEstablished");
		int v1 = scan.nextInt();
		emr.setYearEstablished(v1);
		System.out.println("Enter revenue");
		int v2 = scan.nextInt();
		emr.setRevenue(v2);
		emr.setAddress(ad1);
		
		for (int i = 1; i <= 2; i++) {
			Address	ad = new Address();
			System.out.println("Enter your cityName");
			String str = scan.next();
			ad.setCityName(str);
			System.out.println("Enter your streetName");
			String str2 = scan.next();
			ad.setStreetName(str2);
			System.out.println("Enter your zipcode");
			int val1 = scan.nextInt();			
			ad.setZipCode(val1);
			
			Employee emp = new Employee();
			System.out.println("Enter Employee name");
			String st1 = scan.next();
			emp.setName(st1);
			System.out.println("Enter salary");
			int val2 = scan.nextInt();
			emp.setSalary(val2);
			emp.setAddr(ad);
			emp.setEmployer(emr);
			employee.add(emp);
		}
		
		for (Employee emple : employee) {
			System.out.println(emple);
		}
		
	
	}
}
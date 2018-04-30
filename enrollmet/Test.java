package com.college.enrollmet;


import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Student std = new Student();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Option:\n1) Enter Student\n2) Update Student\n3) List Student\n4) Remove Student");
		int option = scan.nextInt();
		
		if(option >= 1 && option <= 4) {
			switch (option) {
			case 1:
				std.addStudent();
				break;
			case 2:
				std.updateStudent();
				break;
			case 3:
				std.listStudent();
				break;	
			case 4:
				std.removeStudent();
				break;
			}
		} else {
			System.out.println("Invalid Option");
		}
	}
}

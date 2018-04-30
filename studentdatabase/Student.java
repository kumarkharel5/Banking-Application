package com.studentdatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	String firstName, lastName;
	String schoolYear;
	int courseCost = 600, tutionBalance = 0;
	int id = 1000, id1=1000, id2=1000, id3=1000;
	int str, crs, balance;
	int num;
	ArrayList<String> name;

	String[] grade = { "Freshmen", "Sophmore", "Junior", "Senior" };
	String[] course = { "History101", "Math101", "English101", "Chemistry101", "ComputerScience101" };

	Scanner scan = new Scanner(System.in);

	public void gradeLevel() {
		System.out.println("Enter grade level\n1-Freshmen\n2-Sophmore\n3-Junior\n4-Senior");
		str = scan.nextInt();
		if (str == 1) {
			schoolYear = grade[0];
		} else if (str == 2) {
			schoolYear = grade[1];
		} else if (str == 3) {
			schoolYear = grade[2];
		} else if (str == 4) {
			schoolYear = grade[3];
		}
	}

	public void enrollStudents() {
		name = new ArrayList<>();
		if(true) {
		System.out.println("Enter Student's FirstName");
		firstName = scan.next();
		System.out.println("Enter Student's LastName");
		lastName = scan.next();		
		if (firstName.equals(name)) {
			System.out.println(firstName + " is already exist");
		}
		if (lastName.equals(name)) {
			System.out.println(firstName + " is already exist");
		}
		else {
			name.add(firstName);
			name.add(lastName);
		}
		}
	}

	public void uniqueID() {
		for (int i = 0; i < 1; i++) {
			if(str==1) {
				System.out.println("ID: " + str + id++);
			} else if(str==2) {
				System.out.println("ID: " + str + id1++);
			} else if(str==3) {
				System.out.println("ID: " + str + id2++);
			} else if(str==4) {
				System.out.println("ID: " + str + id3++);
			}
		}
	}

	public void enrollCourse() {
		System.out.println("Course\n1-History101\n2-Math101\n3-English101\n4-Chemistry101\n5-Computer Science101\n6-Exit");
		while (true) {
			System.out.println("Enter course");
			crs = scan.nextInt();
			if (crs == 1) {
				System.out.println("Your enrolled in " + course[0]);
				tutionBalance += courseCost;
			}
			if (crs == 2) {
				System.out.println("Your enrolled in " + course[1]);
				tutionBalance += courseCost;
			}
			if (crs == 3) {
				System.out.println("Your enrolled in " + course[2]);
				tutionBalance += courseCost;
			}
			if (crs == 4) {
				System.out.println("Your enrolled in " + course[3]);
				tutionBalance += courseCost;
			}
			if (crs == 5) {
				System.out.println("Your enrolled in " + course[4]);
				tutionBalance += courseCost;
			}
			if (crs == 6) {
				return;
			}
		}
	}

	public void viewBalance() {
		balance = tutionBalance;
		System.out.println("Your balance is " + balance);
	}

	public void payTution() {
		System.out.println("How much do you want to pay?");
		int pay = scan.nextInt();
		int balance = tutionBalance - pay;
		System.out.println("Your remaining balance is " + balance);
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", schoolYear=" + schoolYear + "]";
	}
}

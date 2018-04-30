package com.studentdatabase;

public class TestStudent {

	public static void main(String[] args) {
		System.out.println("How many students are enrolling?");
		Student std = new Student();
		std.num = std.scan.nextInt();
		for (int i = 0; i <std.num; i++) {
			std.enrollStudents();
			std.gradeLevel();
			std.uniqueID();
			std.enrollCourse();
			std.viewBalance();
			std.payTution();
			System.out.println(std);
		}
	}
}

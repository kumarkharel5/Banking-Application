package com.emailapplication;

import java.util.Scanner;

public class employees {
	
	private String firstName, lastName;
	private String email;
	private int mailboxCapacity=500;
	private String company = "cubic", domain = "."+company+".com";
	
	String[] department = {"Sales", "Development", "Accounting"};
	Scanner scan = new Scanner(System.in);
	private String dep, password, alternateEmail;

	public void setDepartment() {
		System.out.println("Department\n1-Sales\n2-Development\n3-Accounting\nN-exit\nEnter your Department");
		dep = scan.next();
		if(dep.equals(department[0])) {
			System.out.println("Your department is "+department[0]);
		} else if(dep.equals(department[1])) {
			System.out.println("Your department is "+department[1]);
		} else if(dep.equals(department[2])) {
			System.out.println("Your department is "+department[2]);
		} else if(!dep.equals(department)) {
			return;
		}
	}
	
	public void genereateEmail() {
		System.out.println("Enter firstname");
		firstName = scan.next();
		System.out.println("Enter lastname");
		lastName = scan.next();
		email = firstName+"."+lastName+"@"+dep+domain;
		System.out.println("Your email is "+email);
	}
	
	public void setPassword() {
		String passwordSet = "abcdefghijklmnopqrstuvwxyz1234567890@#$1";
		char[] password = new char[10];
		for (int i = 0; i < password.length; i++) {
			int rand = (int) (Math.random()*password.length);
			password[i]=passwordSet.charAt(rand);
		}
		System.out.println("Your password is "+password);
	}
	
	public void setChangePassword(String password) {
		this.password = password;
	}
	
	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}
	
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	
	public String getChangePassword() {
		return password;
	}
	
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	public String getAlternateEmail() {
		return alternateEmail;
	}	
	
	@Override
	public String toString() {
		return "employees [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mailboxCapacity=" + mailboxCapacity + ", company=" + company + "]";
	}

	public static void main(String[] args) {
		employees emp = new employees();
		emp.setDepartment();
		emp.genereateEmail();
		emp.setPassword();
		System.out.println(emp);
	}

}

# Hotel Reservation
package com.hotelreservations;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservations {
	int days, price;
	int price1, price2;
	int totalCost;
	int breakfastPrice;
	String cName, str;
	String room;

	String[] city = { "New York", "London", "Chicago" };
	String[] rooms = { "Single room", "Double room", "Presidental" };
	ArrayList<String> names;

	Scanner scan = new Scanner(System.in);

	public void enterCity() {
		System.out.println("Welcome to hotel reservation, please press enter to continue");
		String str = scan.nextLine();
		System.out.println("Enter the destination city\nNew York\nLondon\nChicago");
		cName = scan.nextLine();

		if (cName.equals(city[0])) {
			System.out.println("Your destination is " + cName);
		} else if (cName.equals(city[1])) {
			System.out.println("Your destination is " + cName);
		} else if (cName.equals(city[2])) {
			System.out.println("Your destination is " + cName);
		} else {
			System.out.println("Sorry we dont currently have a hotel in that city.");
		}
	}
	
	public void selectRoom(String rooms) {
		char ch = scan.next().charAt(0);
		if (ch == 'Y') {
			room = rooms;
			System.out.println("Would you like to include breakfast with your stay for $15(Y\\N)");
			selectBreakfast();
		} else if (ch == 'N') {
			getPrice();
		}
	}
	
	public void selectBreakfast() {
			char c = scan.next().charAt(0);
			if (c == 'Y') {
				System.out.println("breakfast will be included with your stay");
				breakfastPrice = 15;
			} else if (c == 'N') {
				breakfastPrice = 0;
			}
	}

	public void getPrice() {
		System.out.println("What price would you like to spend a night");
		price = scan.nextInt();
		if (price > 0 && price <= 100) {
			System.out.println(rooms[0] + " is available.\nIs this ok(Y\\N)");
			selectRoom(rooms[0]);	
		} else if (price > 100 && price <= 200) {
			System.out.println(rooms[1] + " is available.\nIs this ok(Y\\N)");
			selectRoom(rooms[1]);
		} else if (price > 200 && price <= 300) {
			System.out.println(rooms[2] + " available.\nIs this ok(Y\\N)");
			selectRoom(rooms[2]);
		}
	}

	public void numOfPeople() {
		names = new ArrayList<>();
		for (int i = 0; ;) {
			System.out.println("Please enter the name of person who is staying with you\nEnter N to continue");
			str = scan.next();
			if (str.equals("N")) {
				return;
			}
			names.add(str);
		}
	}

	public void numOfDays() {
		System.out.println("How many days are you staying");
		days = scan.nextInt();
		price1 = (price * days);
		System.out.println("The total price for your room is " + price1);
	}

	public void breakfast() {
		price2 = days * breakfastPrice * names.size();
		System.out.println("The total price for your breakfast is " + price2);
	}

	public void display() {
		System.out.println("You will be staying at our hotel in " + cName + " for " + days + " days and in the " + room
				+ " the guests that are staying in the room are " + names + " we have the total price of your stay as "
				+ totalCost);
	}

	public static void main(String[] args) {
		Reservations r = new Reservations();
		r.enterCity();
		r.getPrice();
		r.numOfPeople();
		r.numOfDays();
		r.breakfast();
		r.totalCost = r.price1 + r.price2;
		r.display();
	}
}

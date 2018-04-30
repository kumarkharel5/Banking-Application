package com.aggregation;

public class Employer {
	private String name;
	private int yearEstablished;
	private int revenue;
	private Address address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearEstablished() {
		return yearEstablished;
	}

	public void setYearEstablished(int yearEstablished) {
		this.yearEstablished = yearEstablished;
	}

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employer [name=" + name + ", yearEstablished=" + yearEstablished + ", revenue=" + revenue + ", address="
				+ address + "]";
	}
	
}

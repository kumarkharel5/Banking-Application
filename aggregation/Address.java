package com.aggregation;

public class Address {
	private String cityName;
	private String streetName;
	private int zipCode;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "\nAddress [cityName=" + cityName + ", streetName=" + streetName + ", zipCode=" + zipCode + "]";
	}

}

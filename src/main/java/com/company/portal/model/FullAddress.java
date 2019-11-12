package com.company.portal.model;

public class FullAddress implements Address {

	private String building;

	@Override
	public String toString() {
		return "FullAddress [building=" + building + ", street=" + street + ", city=" + city + ", pincode=" + pincode
				+ "]";
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	private String street;
	private String city;
	private int pincode;

	public FullAddress(String building, String street, String city, int pincode) {
		super();
		this.building = building;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	}

}

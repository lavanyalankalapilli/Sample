package com.company.portal.model;

public class ShortAddress implements Address {
	private String city;
	private int pincode;

	public ShortAddress(String city, int pincode) {
		this.city = city;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", pincode=" + pincode + "]";
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

}

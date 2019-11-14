package com.company.portal.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShortAddress implements Address {
	private String city;
	private int pincode;



}

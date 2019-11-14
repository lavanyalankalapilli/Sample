package com.company.portal.model;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class FullAddress implements Address {

	private String building;
	private String street;
	private String city;
	private int pincode;

}

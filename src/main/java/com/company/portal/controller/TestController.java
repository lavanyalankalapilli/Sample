package com.company.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.portal.model.Company;

@RestController
public class TestController {
	@Autowired
	Company company;

	@RequestMapping("/address")
	public String getAddress() {
		return company.getAddress().toString();
	}

}

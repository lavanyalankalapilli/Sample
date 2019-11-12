package com.company.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.company.portal.model.Address;
import com.company.portal.model.FullAddress;
import com.company.portal.model.ShortAddress;

@Component
public class Configurator {

	@Bean
	@Primary
	public Address shortAddress() {
		return new ShortAddress("Hyderabad", 500032);
	}

	@Bean
	public Address fullAddress() {
		return new FullAddress("MAGNIFIQUE", "RAI DURGAM", "Hyderabad", 500032);
	}

}

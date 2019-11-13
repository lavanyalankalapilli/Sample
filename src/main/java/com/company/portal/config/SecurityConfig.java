package com.company.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
				.password("admin").roles("ADMIN");
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.PUT,"/zemoso/api/v1/employees/*").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST,"/zemoso/api/v1/employees/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE,"/zemoso/api/v1/employees/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/zemoso/api/v1/employees/").hasAnyRole("USER","ADMIN")
		.and()
		.csrf().disable()
		.formLogin().disable();
	}

}
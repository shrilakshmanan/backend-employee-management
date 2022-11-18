/*
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AuthenticationSuccessHandler successHandler;
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()		
			.antMatchers("/*").hasAnyRole("Admin")
			.antMatchers("/*").hasAnyRole("Employee")
			.antMatchers("/*").hasAnyRole("Manager")
			.and().formLogin().loginPage("/")
			
				.successHandler(successHandler)

				.permitAll()
			.and().logout();
	}
}
*/

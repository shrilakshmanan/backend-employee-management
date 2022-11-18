package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;


import com.example.demo.MODEL.emailsender;

@SpringBootApplication

public class LoginpageApplication {
	@Autowired
	private emailsender mail;

	
	public static void main(String[] args) {
		SpringApplication.run(LoginpageApplication.class, args);
	
	}

	
	@EventListener(ApplicationReadyEvent.class)
	public void sendmail() {
		
//mail.sendemail("shrilakshman00@gmail.com", "This is regarding your username and password", "The password is sree123 and your mail id is shri@gmail.com");
		
	}

	
}

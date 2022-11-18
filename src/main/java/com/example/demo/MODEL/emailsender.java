package com.example.demo.MODEL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class emailsender {

	@Autowired
	private JavaMailSender mail;

	public void sendemail( String subject, String body,String getmail) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("shrilakshmanan2000@gmail.com");
		message.setText(body);
		message.setSubject(subject);
		message.setTo(getmail);
		mail.send(message);

		System.out.println("mail sent successfully");

	}

	}

//		public void sendemails(String fromEmail, String subject, String body) {
//
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom(fromEmail);
//		message.setTo("shrilakshmanan2000@gmail.com");//"shrilakshmanan2000@gmail.com"
//		message.setText(body);
//		message.setSubject(subject);
//
//		mail.send(message);
//
//		System.out.println("mail sent successfully");
//
//	}





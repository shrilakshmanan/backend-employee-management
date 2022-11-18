package com.example.demo.service_cls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.Repository_one;

@Service
@Component
public class Admin_serv {

	@Autowired Repository_one repo;

	public String getByname(String pass) {
		
		  String s = repo.findsAll(pass);
		  
		 // System.out.println(pass);
	
		return s;
	}

}

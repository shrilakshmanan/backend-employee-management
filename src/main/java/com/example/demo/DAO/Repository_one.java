package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.MODEL.Admin_cls;


@Repository
public interface Repository_one  extends JpaRepository<Admin_cls, Integer>{

	@Query( value = "SELECT password FROM adminsignin u WHERE u.Emailid = ?1", 
			  nativeQuery = true)
	
	String findsAll(String pass);

}

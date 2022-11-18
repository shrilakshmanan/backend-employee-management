package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.MODEL.jva_clas;

@Repository
public interface id_repo extends JpaRepository<jva_clas, Integer> {

	@Query( value = "SELECT Employeeid FROM signin u WHERE u.Emailid = ?1", 
			  nativeQuery = true)
	int findsAll(String pass);

/*@Query(
	  value = "SELECT username FROM signin u WHERE u.password = 1", 
			  nativeQuery = true)
			
			*/
	
}

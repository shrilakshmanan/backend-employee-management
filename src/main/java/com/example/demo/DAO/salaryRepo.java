package com.example.demo.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.MODEL.Salary;



@Repository
public interface salaryRepo extends JpaRepository<Salary , Integer> {

	
	@Query( value = "SELECT * FROM Salary u WHERE u.salaryid = ?1", 
			  nativeQuery = true)
	Optional<Salary> findByIds(int id);

	@Query( value = "SELECT * FROM Salary u", 
			  nativeQuery = true)
	List<Salary> getsalary();

	@Query( value = "SELECT * FROM Salary u WHERE u.salaryid = ?1", 
			  nativeQuery = true)
	Salary getsalaryDept(int id);

	@Query( value = "SELECT * FROM Salary u WHERE u.position = ?1", 
			  nativeQuery = true)
	String position(String newone);

	@Query( value = "SELECT * FROM Salary u WHERE u.salaryid = ?1", 
			  nativeQuery = true)
	Salary findbysalid(int id);
	
	
}

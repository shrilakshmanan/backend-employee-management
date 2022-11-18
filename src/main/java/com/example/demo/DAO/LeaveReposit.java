package com.example.demo.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.MODEL.jva_clas;
import com.example.demo.MODEL.leaveDates;


@Repository
public interface LeaveReposit extends JpaRepository<leaveDates , Integer> {

	
	@Query( value = "SELECT * FROM leavedates u WHERE u.leaveid = ?1", 
			  nativeQuery = true)
	Optional<leaveDates> findByIds(int id);
	

	
	@Query( value = "SELECT * FROM leavedates u WHERE u.ids = ?1", 
			  nativeQuery = true)
	List<leaveDates> findByepid(int id);


	@Query( value = "SELECT COUNT(status) FROM leavedates  WHERE status= ?1",  nativeQuery = true)
	long findBystatus(String status);


	@Query( value = "SELECT COUNT(status) FROM leavedates  WHERE ids=?1 AND status=?2",  nativeQuery = true)
	long findByempstatus(Integer id,String status);


	@Query( value = "SELECT * FROM leavedates u WHERE u.leaveid = ?1", 
			  nativeQuery = true)
	leaveDates updateleave(int id);

	@Query( value = "SELECT * FROM leavedates u WHERE u.leaveid = ?1", 
			  nativeQuery = true)

	leaveDates findBYLeaveid(int id);


	@Query( value = "SELECT COUNT(leaveid) FROM leavedates WHERE status=?1",  nativeQuery = true)
	 int getleavecounts(String status) ;



}

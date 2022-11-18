package com.example.demo.DAO;


import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.MODEL.Salary;
import com.example.demo.MODEL.jva_clas;


@Repository
public interface Repo_cls extends JpaRepository<jva_clas, Integer> {

	@Query( value = "SELECT * FROM signin u WHERE u.Emailid = ?1", 
			  nativeQuery = true)
	jva_clas findAll(String pass);
	
	
//	@Query( value = "SELECT jobdesc FROM signin u WHERE u.Emailid = ?1", 
//			  nativeQuery = true)
//	String findposition(String email);

	
	
	@Query( value = "SELECT password FROM signin u WHERE u.personelmail = ?1", 
			  nativeQuery = true)
	String findAllpwd(String pass);
	

	@Query( value = "SELECT Roles FROM signin u WHERE u.Emailid = ?1", 
			  nativeQuery = true)
	
	String findAllRoles(String Role);

	@Query( value = "SELECT personelmail FROM signin u WHERE u.Emailid = ?1", 
			  nativeQuery = true)
	String findmail(String id);
	
	

	@Query( value = "SELECT username FROM signin u WHERE u.Emailid = ?1", 
			  nativeQuery = true)
	String findAllname(String name);

	@Query( value = "SELECT employeeid FROM signin u WHERE u.Emailid = ?1", 
			  nativeQuery = true)
	int findAllids(String name);

	
	@Query( value = "SELECT COUNT(employeeid) FROM signin",  nativeQuery = true)
	long counts(int id);

	@Query( value = "SELECT username FROM signin u WHERE u.employeeid = ?1", 
			  nativeQuery = true)
	String findAllnameid(int idds);

	@Query( value = "SELECT COUNT(employeeid) FROM signin WHERE roles=?1",  nativeQuery = true)
	long countmanager(String manager);

	@Query( value = "SELECT * FROM signin u WHERE u.manager_incharge = ?1", 
			  nativeQuery = true)
	List<jva_clas> findAllemp(int id);

	@Query( value = "SELECT leave_total_days FROM signin u WHERE u.emailid = ?1", 
			  nativeQuery = true)
	int getleave(String email);

	@Query( value = "SELECT * FROM signin u WHERE u.roles = ?1 AND u.EmployeeStatus != ?2", 
			  nativeQuery = true)
	List<jva_clas> getmanager(String m, String status);

	@Query( value = "SELECT leave_total_days FROM signin u WHERE u.employeeid = ?1", 
			  nativeQuery = true)
	int gettotaldates(int string);

	@Query( value = "SELECT * FROM signin u WHERE u.roles = ?1 	AND u.EmployeeStatus != ?2 AND u.EmployeeStatus != ?3 ", 
			  nativeQuery = true)
	List<jva_clas> gets(String str,String former, String wrong );


	@Query( value = "SELECT paidleave FROM signin u WHERE u.employeeid = ?1", 
			  nativeQuery = true)
	int getleavecount(int id);


	@Query( value = "SELECT casualleave FROM signin u WHERE u.employeeid = ?1", 
			  nativeQuery = true)
	int getcasual(int i);
	@Query( value = "SELECT wfh FROM signin u WHERE u.employeeid = ?1", 
			  nativeQuery = true)
	int getwfh(int id);
	
	@Query( value = "SELECT sickleave FROM signin u WHERE u.employeeid = ?1", 
			  nativeQuery = true)
	int getsickleave(int i);

	@Query( value = "UPDATE paidleave FROM signin u WHERE u.employeeid = ?1", 
			  nativeQuery = true)
	int updatepaid(int id);

	@Transactional 
	@Modifying
	@Query( value = "UPDATE signin  SET casualleave =?2 WHERE employeeid = ?1", 
			  nativeQuery = true)
	int updatecasualleave(int id, int updatecasual);



	@Transactional 
	@Modifying
	@Query( value = "UPDATE signin  SET sickleave =?2 WHERE employeeid = ?1", 
			  nativeQuery = true)
	void updatesick(int i, int totalsickleave);
	
	
	@Transactional 
	@Modifying
	@Query( value = "UPDATE signin  SET paidleave =?2 WHERE employeeid = ?1", 
			  nativeQuery = true)
	void updatepaidleave(int i, int updatpaid);
	
	
	@Query( value = "UPDATE sickleave FROM signin u WHERE u.employeeid = ?1", 
			  nativeQuery = true)
	int updatesickleave(int i);

	@Query( value = "SELECT * FROM signin u WHERE u.employeeid = ?1", 
			  nativeQuery = true)
 jva_clas findByemployee(int id);


	@Query( value = "SELECT * FROM signin u WHERE u.employeeid != ?1 AND u.roles!=?2 AND u.EmployeeStatus!=?3", 
			  nativeQuery = true)
	List<jva_clas> displayemployee(int id, String admin, String status);

	@Query( value = "SELECT * FROM signin u WHERE u.roles = ?1", 
			  nativeQuery = true)
	List<jva_clas> getmanagerupdate(String manager);

	@Query( value = "SELECT * FROM signin u WHERE u.EmployeeStatus = ?1", 
			  nativeQuery = true)
	List<jva_clas> displaycurrent(String status);

	@Query( value = "SELECT * FROM signin u WHERE u.EmployeeStatus = ?1", 
			  nativeQuery = true)
	List<jva_clas> displayformer(String status);

	@Query( value = "SELECT casualleave FROM signin  WHERE employeeid = ?1", 
			  nativeQuery = true)
	int getcasualleave( int id);

	@Query( value = "SELECT paidleave FROM signin  WHERE employeeid = ?1", 
			  nativeQuery = true)
	int getpaidleave(int i);

	@Query( value = "SELECT sickleave FROM signin  WHERE employeeid = ?1", 
			  nativeQuery = true)
	int getsickleavecount(int i);

	@Query( value = "SELECT * FROM signin  WHERE employeeid = ?1", 
			  nativeQuery = true)
	List<jva_clas> getLeaves(int id);

	@Query( value = "SELECT * FROM signin  WHERE employeeid = ?1", 
			  nativeQuery = true)
	int getmanagerprofile(int id);

	@Query( value = "SELECT * FROM signin  WHERE employeeid = ?1", 
			  nativeQuery = true)
	jva_clas findBYempid(int id);

	@Query( value = "SELECT manager_incharge FROM signin  WHERE employeeid = ?1", 
			  nativeQuery = true)

	int getmanageer(int id);


	@Query( value = "SELECT username FROM signin WHERE employeeid = ?1", 
			  nativeQuery = true)
	String getmanagername(int managercheck);


	@Query( value = "SELECT COUNT(employeeid) FROM signin  WHERE manager_incharge = ?1 ",  nativeQuery = true)
	int gettotalemp(int id);

	@Query( value = "SELECT COUNT(employeeid) FROM signin WHERE employeeid != 1 AND employeeid != 125",  nativeQuery = true)



	int gettotalsE();

	@Query( value = "SELECT * FROM signin  ",  nativeQuery = true)


	jva_clas getLeav(int id);


	@Query( value = "SELECT username FROM signin WHERE employeeid =?1 ",  nativeQuery = true)
	String username(String id);


	@Query( value = "SELECT * FROM signin u WHERE u.EmployeeStatus = ?1", 
			  nativeQuery = true)
	List<jva_clas> displaywrong(String status);

	@Transactional 
	@Modifying
	@Query( value = "UPDATE signin  SET wfh =?2 WHERE employeeid = ?1", 
			  nativeQuery = true)
	void updatewfh(int i, int totaldays);

	@Query( value = "SELECT * FROM signin u WHERE u.username = ?1", 
			  nativeQuery = true)
	List<jva_clas> getdetail(String string);


	@Query( value = "SELECT personelmail FROM signin WHERE employeeid =?1 ",  nativeQuery = true)
	String getpersonelmail(int i);








	










	

/*@Query(
	  value = "SELECT username FROM signin u WHERE u.password = 1", 
			  nativeQuery = true)
			
			*/
	
}



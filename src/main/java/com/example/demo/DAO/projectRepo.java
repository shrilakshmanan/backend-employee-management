package com.example.demo.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.MODEL.currentProjects;
//import com.example.demo.MODEL.project;
import com.example.demo.MODEL.jva_clas;

@Repository
public interface projectRepo extends JpaRepository<currentProjects, Integer> {

	

	@Query( value = "SELECT * FROM addprojects u WHERE u.employeeid LIKE %?1%", 
			  nativeQuery = true)

	
	List<currentProjects> findByempids(String id);
	


	
	@Query( value = "SELECT COUNT(employeeid) FROM addprojects",  nativeQuery = true)
	long projectcount(int id);

	
	@Query( value = "SELECT * FROM addprojects u WHERE u.managerid = ?1", 	
			  nativeQuery = true)
	List<currentProjects> findAllEmp(int id);


	@Query( value = "SELECT COUNT(projectid) FROM addprojects  WHERE employeeid= ?1",  nativeQuery = true)
	long findByempprojects(Integer id);


	@Query( value = "SELECT * FROM addprojects WHERE project_name=?2 AND employeeid=?1", 	
			  nativeQuery = true)
	List<currentProjects> verify(int empid, String projectname);

	@Query( value ="SELECT `project_name` FROM `addprojects` WHERE project_name=?1" ,  nativeQuery = true)
	String namecompare(String projectname);

	@Query( value = "SELECT * FROM addprojects WHERE project_name=?1", 	 nativeQuery = true)
	List<currentProjects> oldprojects(int id);


	@Query( value = "SELECT GROUP_CONCAT(employeeid) FROM addprojects u WHERE project_name=?1", nativeQuery=true)
	List<List<String>> concat(String comp);

	@Query( value = "SELECT * FROM addprojects u WHERE u.managerid = ?1 AND u.Status=?2", nativeQuery = true)
	List<currentProjects> completed(int id,String s);

	@Query( value = "SELECT * FROM addprojects u WHERE u.managerid = ?1 AND u.Status=?2", nativeQuery = true)
	List<currentProjects> Active(int id, String strin);

	@Query( value = "SELECT * FROM addprojects u WHERE u.Status=?1", nativeQuery = true)
	List<currentProjects> Admincompleted(String status);

	@Query( value = "SELECT * FROM addprojects u WHERE u.Status=?1", nativeQuery = true)
	List<currentProjects> AdminActive(String status);

	@Query( value = "SELECT employeeid FROM addprojects u WHERE u.project_name=?1", nativeQuery = true)
	String Team(String id);

	
//	@Query( value = "SELECT * FROM addprojects u WHERE u.Status=?1", nativeQuery = true)
//	List<currentProjects> yetto(String status);
	
	@Query( value = "SELECT * FROM addprojects u WHERE u.managerid = ?1 AND u.Status=?2", nativeQuery = true)
	List<currentProjects> yetto(int id, String strin);

	@Query( value = "SELECT projectid FROM addprojects u WHERE u.project_name=?1", nativeQuery = true)
	int getnumber(String name);

	@Query( value = "SELECT * FROM addprojects u WHERE u.projectid=?1", nativeQuery = true)
	 currentProjects findproject(int id);

	@Query( value = "SELECT COUNT(status) FROM addprojects u WHERE u.managerid= ?1 AND status=?2",  nativeQuery = true)
	int getproject(int id,String s);

	@Query( value = "SELECT COUNT(status) FROM addprojects u WHERE u.managerid= ?1 AND status=?2",  nativeQuery = true)
	int getyetto(int id, String yet);

	@Query( value = "SELECT COUNT(status) FROM addprojects u WHERE u.managerid= ?1 AND status=?2",  nativeQuery = true)
	
	int complete(int id, String comp);



	@Query( value = "SELECT * FROM addprojects u WHERE u.Status=?1", nativeQuery = true)
	List<currentProjects> getyetproject(String status);



	@Query( value = "SELECT COUNT(status) FROM addprojects u WHERE  u.employeeid LIKE %?1% AND status=?2",  nativeQuery = true)
	int getcount(String usernameemp, String current);



	@Query( value = "SELECT COUNT(status) FROM addprojects u WHERE  u.employeeid LIKE %?1% AND status=?2",  nativeQuery = true)
	int getcompletedcount(String usernameemp, String comp);




	@Query( value = "SELECT COUNT(status) FROM addprojects u WHERE  u.employeeid LIKE %?1% AND status=?2",  nativeQuery = true)
	
	int YetEmpfind(String usernameemp, String yetEmp);



	@Query( value = "SELECT COUNT(status) FROM addprojects",  nativeQuery = true)

	int getfullcount();


	
	





	
}

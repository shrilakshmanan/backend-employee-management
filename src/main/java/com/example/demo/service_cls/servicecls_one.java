package com.example.demo.service_cls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.LeaveReposit;
import com.example.demo.DAO.Repo_cls;
import com.example.demo.DAO.id_repo;
import com.example.demo.DAO.projectRepo;
import com.example.demo.DAO.queries_saved;
import com.example.demo.DAO.salaryRepo;
import com.example.demo.MODEL.Querymails;
import com.example.demo.MODEL.Salary;
import com.example.demo.MODEL.currentProjects;
import com.example.demo.MODEL.jva_clas;
import com.example.demo.MODEL.leaveDates;
import com.example.demo.MODEL.pojo_cls;


@Service
public class servicecls_one {

@Autowired Repo_cls repo;

@Autowired id_repo repoes;

@Autowired
LeaveReposit Leaverepo;
@Autowired
queries_saved queries;
@Autowired
projectRepo projectrepoes;

@Autowired

salaryRepo salaryRepoes;


	public String getById(int id) {
			
		  Optional < jva_clas > optional = repo.findById(id);
		
		  jva_clas existingCustomer=null;
		  
		  String nope = null;
		if(optional.isPresent()) {
		 existingCustomer = optional.get();
		      String nameWeWanted = existingCustomer.getPassword();
		  //    System.out.println(nameWeWanted);
		      return nameWeWanted;
		      
		      //operate on existingCustomer
		  } else 
		     
			  return nope;
		  
		  
	//	  jva_clas datas = optional.get();    
	           
	}

	public jva_clas getByname(String pass) {
		
		jva_clas s = repo.findAll(pass);
			  System.out.println("This is password  "+s.getPassword());
		/*	
		  jva_clas existingCustomer=null;
		  
		  String nope = null;
		if(optional.isPresent()) {
		 existingCustomer = optional.get();
		      String nameWeWanted = existingCustomer.getPassword();
		   //  System.out.printf("This is from the db data ",nameWeWanted);
		      return nameWeWanted;
		      
		      //operate on existingCustomer
		  } else 
		     
			  return nope;
		 */
		return s;
	}

	//this is for role taking purpose
	
	

	public String getByRole(String Role) {
		
		  String Roles = repo.findAllRoles(Role);
		  
			  //System.out.println("This is rolesss"+Roles);
	
		return Roles;
	}
	
	

	public String getByName(String name) {
		
		  String names = repo.findAllname(name);
		  
			  //System.out.println("This is rolesss"+Roles);
	
		return names;
	}
	
	
	//This is for getting the emp id
	
	public int getempId(String name) {
		
		  int names = repo.findAllids(name);
		  
			//  System.out.println("This is rolesss"+names);
	
		return names;
	}
	
	
	
	//This is for deleting the employee
	
	public void deleteById(int id) {
		
		  repo.deleteById(id);
	}

	
//This is for deleting the projects
	public void deleteprojects(int id) {

		projectrepoes.deleteById(id);
	}

	
	public int getById(String email) {
		// TODO Auto-generated method stub
	 int id=repoes.findsAll(email);
	return id ;
	}

	public jva_clas getEmployeeById(int id) {

		
			Optional<jva_clas> option=repo.findById(id);
			
			jva_clas pojo=option.get();

			return pojo;
	}
	
	
	

	//This is for updating the leave status
	
	public leaveDates getleavedetails(int id) 
	{
		//System.out.println(id);
		Optional<leaveDates> option=Leaverepo.findByIds(id);
		
		leaveDates leaveDate=option.get();
		
		return leaveDate;
		
}
	
	//this is to update  the salary status
	public Salary getsalarydetails(int id) {
	Optional<Salary> option=salaryRepoes.findByIds(id);
		
	Salary Salary=option.get();
		
		return Salary;
	}

	 
	
	
	
	
	//This is to display the details to the employee

	public List<leaveDates> getleavedetailsemp(int id) 
	{
		//System.out.println(id);
		List<leaveDates> option=Leaverepo.findByepid(id);
		
		List<leaveDates> leaveDate=option;
		
		return leaveDate;
		
}
	


	
	 public void saveEmployee(jva_clas employee) {
		 
	        this.repo.save(employee);
	    }

	public Querymails getquerydetails(int id) {

		
		//System.out.println(id);
				Optional<Querymails> option=queries.findByqueryid(id);
				
				Querymails Querymails=option.get();
				
				return Querymails;
	}

	public List<Querymails> getquerydetailsemp(int id) {
		
	List<Querymails> option=queries.findByepid(id);
		
		List<Querymails> queries=option;
		
		return queries;
	}
	
	

//	public List<currentProjects> getprojectdetailsemp(int id) {
//		
//		//System.out.println(id);
//	List<currentProjects> optiondata= projectrepoes.findByempids(id);
//
//		List<currentProjects> projects=optiondata;
//		
//		return projects;
//	}

	public String getByNameid(int idds) {
		
		  String names = repo.findAllnameid(idds);
		  return names;
	}

	
	public void deleteleave(int id) {
		// TODO Auto-generated method stub
		Leaverepo.deleteById(id);
		
	}

	public List<currentProjects> getprojects(int id) {
		
		List<currentProjects> optiondata= projectrepoes.oldprojects(id);

		List<currentProjects> projects=optiondata;
		
		return projects;
	}

//	public String getByposition(String email) {
//
//		  String names = repo.findposition(email);
//		  return names;
//		
//	}



}

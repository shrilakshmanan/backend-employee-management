package com.example.demo.service_cls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.LeaveReposit;
import com.example.demo.DAO.Repo_cls;
import com.example.demo.DAO.projectRepo;
import com.example.demo.DAO.queries_saved;
import com.example.demo.DAO.salaryRepo;
import com.example.demo.DAO.takingdataleavereposit;
import com.example.demo.MODEL.Querymails;
import com.example.demo.MODEL.Salary;
import com.example.demo.MODEL.currentProjects;
import com.example.demo.MODEL.jva_clas;
import com.example.demo.MODEL.leaveDates;

@Service
@Component
public class serv_cls {

	@Autowired
	Repo_cls repo;

	@Autowired
	LeaveReposit Leaverepo;

	@Autowired
	projectRepo projectrepoes;
	
	
	@Autowired
	queries_saved queries;

	
	@Autowired
	salaryRepo salaryRepoes;
	
	
	
	public String getByIdd(String id) {

		String mail = repo.findmail(id);

		System.out.println(mail);

		return mail;

		/*
		 * Optional < jva_clas > optional = repo.findById(id);
		 * 
		 * jva_clas employeepassword=null;
		 * 
		 * jva_clas nope = null; if(optional.isPresent()) { employeepassword =
		 * optional.get(); String nameWeWanted = employeepassword.getPassword(); //
		 * System.out.println(nameWeWanted); return employeepassword;
		 * 
		 * //operate on existingCustomer } else
		 * 
		 * return nope;
		 * 
		 */

		// jva_clas datas = optional.get();

	}

	public jva_clas findAll(String id) {

		jva_clas passwd = repo.findAll(id);

		// System.out.println(passwd);

		return passwd;
	}

	
	
	
	
	public String findAllpwd(String id) {

		String passwd = repo.findAllpwd(id);

		// System.out.println(passwd);

		return passwd;
	}

	
	
	// THIS IS FOR DISPLAYIN ALL THE USER DATA

	public List<jva_clas> getAlluser() {

		return repo.findAll();

	}

//This is for displaying all project to Admin and manager

	public List<currentProjects> getAllprojects() {

		return projectrepoes.findAll();

	}


	public List<leaveDates> getAllLeave() {

		return Leaverepo.findAll();

	}
	
	public List<Querymails> getallQuerymails() {

		return queries.findAll();

	}
	

	public jva_clas getById_det(int id) {
		// TODO Auto-generated method stub
		Optional<jva_clas> optional = repo.findById(id);
		jva_clas existingCustomer = null;

		jva_clas nope = null;
		if (optional.isPresent()) {
			existingCustomer = optional.get();
			String nameWeWanted = existingCustomer.getPassword();

			// This is for password purpose here
			// System.out.println("This is the "+nameWeWanted);
			return existingCustomer;

			// operate on existingCustomer
		} else

			return nope;
	}
	public List<Salary> getAllusersalary() {

		return salaryRepoes.findAll();

	}

	public List<currentProjects> getmanagersemp(int id) {
	
		return projectrepoes.findAllEmp(id);
	}

	
	
	
	/*
	public leaveDates getById_lev(int id) {
		
		List<leaveDates> authors = takingdataleavereposit.getAuthorsByFirstName(5);
		return authors;
	}
/*
		Optional<leaveDates> optional = Leaverepo.findById(id);
		leaveDates existingCustomer = null;

		leaveDates nope = null;
		if (optional.isPresent()) {
			existingCustomer = optional.get();
			String nameWeWanted = existingCustomer.getLeavestartdate();

		//	System.out.println("This is for password purpose here");
			System.out.println("This is the "+nameWeWanted);
			return existingCustomer;

			// operate on existingCustomer
		} else

			return nope;
	}
*/

}

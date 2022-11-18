package com.example.demo.MODEL;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;	

@Entity
@Table(name = "addprojects")
public class currentProjects {

	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int projectid;
	@Column(name = "project_name")
	private String projectname;
	@Column(name = "project_start_date")
	private String startdate;
	@Column(name = "project_end_date")
	private String enddate;
	@Column(name = "projectdescription")
	private String projectdescription;
	public String getProjectdescription() {
		return projectdescription;
	}

	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}

	@Column(name = "employeeid")
	private String Employeeid;
	@Column(name = "managerid")
	
	private int managerid;
	public String getEmployeeid() {
		return Employeeid;
	}

	public void setEmployeeid(String employeeid) {
		Employeeid = employeeid;
	}

	@Column(name = "Status")
	private String Status;
	
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "managerid", referencedColumnName = "Employeeid",insertable =false, updatable =false)
    private jva_clas jva_clas1;
	

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public jva_clas getJva_clas1() {
		return jva_clas1;
	}

	public void setJva_clas1(jva_clas jva_clas1) {
		this.jva_clas1 = jva_clas1;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	



	
}

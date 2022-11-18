package com.example.demo.MODEL;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;	

@Entity
@Table(name = "oldprojects")
public class oldprojects {


	@Id
	private int projectid;
	@Column(name = "project_name")
	private String projectname;
	@Column(name = "project_start_date")
	private String startdate;
	@Column(name = "project_end_date")
	private String enddate;
	@Column(name = "employeeid")
	private int Employeeid;
	@Column(name = "managerid")
	private int managerid;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "employeeid", referencedColumnName = "Employeeid",insertable =false, updatable =false)
    private jva_clas jva_clas;
	
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

	public int getEmployeeid() {
		return Employeeid;
	}

	public void setEmployeeid(int employeeid) {
		Employeeid = employeeid;
	}

	public jva_clas getJva_clas() {
		return jva_clas;
	}

	public void setJva_clas(jva_clas jva_clas) {
		this.jva_clas = jva_clas;
	}


	
}

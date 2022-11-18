package com.example.demo.MODEL;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//This is the employee class

@Entity

@Table(name = "Signin")
public class jva_clas {

	@Id
	private int Employeeid;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "Emailid")
	private String Emailid;
	@Column(name = "jobdesc")
	private int jobdesc;
	@Column(name = "LeaveTotalDays")
	private int LeaveTotalDays;
	
	public int getCasualleave() {
		return casualleave;
	}


	public void setCasualleave(int casualleave) {
		this.casualleave = casualleave;
	}


	public int getSickleave() {
		return sickleave;
	}


	public void setSickleave(int sickleave) {
		this.sickleave = sickleave;
	}


	public int getPaidleave() {
		return paidleave;
	}


	public void setPaidleave(int paidleave) {
		this.paidleave = paidleave;
	}

	@Column(name = "casualleave")
	private int casualleave;
	@Column(name = "sickleave")
	private int sickleave;
	@Column(name = "wfh")
	private int workfromhome;
	@Column(name = "paidleave")
	private int paidleave;
	
	public int getWorkfromhome() {
		return workfromhome;
	}


	public void setWorkfromhome(int workfromhome) {
		this.workfromhome = workfromhome;
	}

	@Column(name = "employeestatus")
	private String employeestatus;

	public String getEmployeestatus() {
		return employeestatus;
	}


	public void setEmployeestatus(String employeestatus) {
		this.employeestatus = employeestatus;
	}


	public int getLeaveTotalDays() {
		return LeaveTotalDays;
	}


	public void setLeaveTotalDays(int leaveTotalDays) {
		LeaveTotalDays = leaveTotalDays;
	}

//	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH })
//    @JoinColumn(name = "ManagerIncharge", referencedColumnName = "Employeeid",insertable =false, updatable =false)
//	jva_clas java_cls;
	//@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH })
	
	@Column(name = "ManagerIncharge")
	private String ManagerIncharge;
	


	public String getManagerIncharge() {
		return ManagerIncharge;
	}


	public void setManagerIncharge(String managerIncharge) {
		ManagerIncharge = managerIncharge;
	}


	public int getJobdesc() {
		return jobdesc;
	}

	public void setJobdesc(int jobdesc) {
		this.jobdesc = jobdesc;
	}

	@Column(name = "personelmail")
	private String personelmail;

	@Column(name = "dateofjoining")
	private String dateofjoining;
	
	@Column(name = "dateofleaving")
	private String dateofleaving;
	
	public String getDateofleaving() {
		return dateofleaving;
	}


	public void setDateofleaving(String dateofleaving) {
		this.dateofleaving = dateofleaving;
	}


	public String getDateofjoining() {
		return dateofjoining;
	}


	public void setDateofjoining(String dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	@Column(name = "roles")
	private String Roles;
		
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "jobdesc", referencedColumnName = "salaryid",insertable =false, updatable =false)
    private Salary salary;

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public String getRoles() {
		return Roles;
	}

	public void setRoles(String roles) {
		Roles = roles;
	}

	public String getPersonelmail() {
		return personelmail;
	}

	public void setPersonelmail(String personelmail) {
		this.personelmail = personelmail;
	}

public int getEmployeeid() {
		return Employeeid;
	}

	public void setEmployeeid(int employeeid) {
		Employeeid = employeeid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return Emailid;
	}

	public void setEmailid(String emailid) {
		Emailid = emailid;
	}
//
//	public jva_clas getJava_cls() {
//		return java_cls;
//	}
//
//	public void setJava_cls(jva_clas java_cls) {
//		this.java_cls = java_cls;
//	}
//	
	


}

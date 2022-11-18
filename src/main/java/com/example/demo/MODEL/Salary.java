package com.example.demo.MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
	
	@Entity
	@Table(name = "salary")
	public class Salary {
		
		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		private int salaryid;
		@Column(name = "position")
		private String position ;
		
		
		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		@Column(name = "department")
		private String department;
		

		@Column(name = "salary")
		private int salary;
		
		
		public int getSalaryid() {
			return salaryid;
		}

		public void setSalaryid(int salaryid) {
			this.salaryid = salaryid;
		}

		public String getPosition() {
			return position;
		}

		public void setPosition(String position) {
			this.position = position;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

	
		}
		
	
	
	
		
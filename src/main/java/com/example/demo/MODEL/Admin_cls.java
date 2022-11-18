package com.example.demo.MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "adminsignin")
public class Admin_cls {
	
//This is the admin class
	
		@Id
		private int Adminid;
		@Column(name = "username")
		private String username;
		@Column(name = "password")
		private String password;
		@Column(name = "Emailid")
		private String Emailid;
		
		public int getAdminid() {
			return Adminid;
		}
		public void setAdminid(int adminid) {
			Adminid = adminid;
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
			
}

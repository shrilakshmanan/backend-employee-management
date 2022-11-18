package com.example.demo.MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaveTypes")
public class leaveTypes {

	
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getCasualleave() {
		return casualleave;
	}
	public void setCasualleave(int casualleave) {
		this.casualleave = casualleave;
	}
	public int getPaidleave() {
		return paidleave;
	}
	public void setPaidleave(int paidleave) {
		this.paidleave = paidleave;
	}
	public int getSickleave() {
		return sickleave;
	}
	public void setSickleave(int sickleave) {
		this.sickleave = sickleave;
	}
	@Id
	private int typeid;
	@Column(name = "casualleave")
	private int casualleave;
	@Column(name = "leaveenddate")
	private int paidleave;
	@Column(name = "sickleave")
	private int sickleave;
	
	
}



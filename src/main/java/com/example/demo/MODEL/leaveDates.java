package com.example.demo.MODEL;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "leavedates")

public class leaveDates {
	@Id
	private int Leaveid;
	@Column(name = "leavestartdate")
	private String Leavestartdate;
	@Column(name = "leaveenddate")
	private String leaveenddate;
	@Column(name = "category")
	private String category;
	@Column(name = "Reason")
	private String Reason;
	@Column(name = "kindof")
	private String kindof;
	
@Column(name="ids")

private String ids;
	public String getKindof() {
	return kindof;
}

public void setKindof(String kindof) {
	this.kindof = kindof;
}

	public String getIds() {
	return ids;
}

public void setIds(String ids) {
	this.ids = ids;
}


	@Column(name = "TotalDays")
	private int TotalDays;
		


	public int getTotalDays() {
		return TotalDays;
	}

	public void setTotalDays(int totalDays) {
		TotalDays = totalDays;
	}


	@OneToOne(cascade = CascadeType.DETACH)

	@JoinColumn(name = "ids", referencedColumnName = "Employeeid", insertable = false, updatable = false)
	private jva_clas jva_clas;

	
	@Column(name = "status")
	private String status;

	public String getStatus() {
		return status;
	}

	public jva_clas getJva_clas() {
		return jva_clas;
	}

	public void setJva_clas(jva_clas jva_clas) {
		this.jva_clas = jva_clas;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getCategory() {
		return category;
	}

	public int getLeaveid() {
		return Leaveid;
	}

	public void setLeaveid(int leaveid) {
		Leaveid = leaveid;
	}

	public String getLeavestartdate() {
		return Leavestartdate;
	}

	public void setLeavestartdate(String leavestartdate) {
		Leavestartdate = leavestartdate;
	}

	public String getLeaveenddate() {
		return leaveenddate;
	}

	public void setLeaveenddate(String leaveenddate) {
		this.leaveenddate = leaveenddate;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}

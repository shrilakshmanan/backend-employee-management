package com.example.demo.MODEL;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "querymail")
public class Querymails {

	@Id
	private int queryid;
	@Column(name = "queries")
	private String queries;
	
	public String getQueries() {
		return queries;
	}

	public void setQueries(String queries) {
		this.queries = queries;
	}

	@Column(name = "ids")
	
	private int ids;
	
	@Column(name = "category")
	private String category;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "response")
	private String response;
	
	@Column(name = "querydate")
	private String querydate;
	
	public String getQuerydate() {
		return querydate;
	}

	public void setQuerydate(String querydate) {
		this.querydate = querydate;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Column(name = "status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIds() {
		return ids;
	}

	public void setIds(int ids) {
		this.ids = ids;
	}

	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ids", referencedColumnName = "Employeeid",insertable =false, updatable =false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private  jva_clas jva_clas;

	public int getQueryid() {
		return queryid;
	}

	public void setQueryid(int queryid) {
		this.queryid = queryid;
	}



	public jva_clas getJva_clas() {
		return jva_clas;
	}

	public void setJva_clas(jva_clas jva_clas) {
		this.jva_clas = jva_clas;
	}


}
	
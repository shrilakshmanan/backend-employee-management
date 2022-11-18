package com.example.demo.MODEL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class pojo_cls {

	@Id
	private int id;
	private String Description;
	private String Target_Date;
	
	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getTarget_Date() {
		return Target_Date;
	}

	public void setTarget_Date(String target_Date) {
		Target_Date = target_Date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}

package it.helloWorld.enterprise.data.dto;



import it.helloWorld.enterprise.data.annotation.TransferDomain;

import java.io.Serializable;

@TransferDomain(className="it.helloWorld.enterprise.data.dao.Employee")
public class EmployeeTo implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String surname;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	

}

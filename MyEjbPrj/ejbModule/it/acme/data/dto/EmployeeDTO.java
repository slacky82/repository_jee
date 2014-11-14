package it.acme.data.dto;

import java.io.Serializable;
import javax.persistence.*;




public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int id;

	private String name;

	private String surname;

	public EmployeeDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
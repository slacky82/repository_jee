package it.acme.model.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="hibernateModel")
@SessionScoped
public class HibernateModelMB implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String surname;
	
	public HibernateModelMB(){
		
	}
	
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

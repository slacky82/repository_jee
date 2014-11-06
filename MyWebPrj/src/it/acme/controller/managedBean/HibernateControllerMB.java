package it.acme.controller.managedBean;

import it.acme.data.dto.EmployeeDTO;
import it.acme.ejb.stateless.FilterStrategyFacadeRemote;
import it.acme.exception.BusinessException;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sun.prism.impl.BaseMesh.FaceMembers;

@ManagedBean(name="hibernateController")
@SessionScoped
public class HibernateControllerMB implements Serializable {	
	
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String surname;
	
	@EJB
	FilterStrategyFacadeRemote ejbRef;
	
	/*
	@ManagedProperty(value="#{hibernateModel}")
	private HibernateModelMB model;	
	*/
	
	public HibernateControllerMB(){
		
	}	
	
	@PostConstruct
	public void postConstruct(){
		System.out.println("#hibernateController: @PostConstruct CALLED!");		
	}
	
	public void insert(ActionEvent event) {		
		try{			
			EmployeeDTO dtoObj = new EmployeeDTO();
			dtoObj.setId(id);
			dtoObj.setName(name);
			dtoObj.setSurname(surname);
			ejbRef.insertEmployee(dtoObj);
			createMessage("Dato inserito con successo","Employee: "+name+" "+surname);
		}
		catch(BusinessException be){
			createMessage("ERRORE: "+be.getMessage(),null);	
			be.printStackTrace();
		}
	}
	
	private void createMessage( String message, String detail){
		FacesContext fContext = FacesContext.getCurrentInstance();
		FacesMessage fMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
		fContext.addMessage(null, fMessage);		
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
	
	/*
	public void setModel(HibernateModelMB model) {
		this.model = model;
	}
	 */

	
	
	

}

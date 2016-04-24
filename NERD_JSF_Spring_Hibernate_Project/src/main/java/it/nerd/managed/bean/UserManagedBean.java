package it.nerd.managed.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.dao.DataAccessException;

import it.nerd.model.User;
import it.nerd.spring.service.IUserService;

/**
 * 
 * User Managed Bean
 * 
 * @author onlinetechvision.com
 * @since 17 Aug 2015
 * @version 1.0.0
 *
 */
@ManagedBean(name="userMB")
//@RequestScoped
public class UserManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";
	
	private Integer id;
	private String name;
	private String surname;
	
	//Spring User Service is injected...
	@ManagedProperty(value="#{UserService}")
	IUserService userService;
	
	public void getUserById() throws InterruptedException {
		Thread.sleep(1000);
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			User user = getUserService().getUserById(id);
			String myMessage = user.getName() + " " + user.getSurname();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Name found", myMessage) );
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Second Message", "Warning Message")); 
		}catch (DataAccessException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "load operation", e.getMessage()) );
			e.printStackTrace();
		}	    
	}
	
	public void saveUser() throws InterruptedException {	
		FacesContext context = FacesContext.getCurrentInstance();    
		User user = new User();
		Integer myId = getId();
		user.setId(myId);
		user.setName(getName());
		user.setSurname(getSurname());
		try{
			getUserService().addUser(user);		
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "save operation", "Success") );
		}catch (DataAccessException e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "save operation", e.getMessage()) );
				e.printStackTrace();
		}		
	}
	
	
	//getter setters
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
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
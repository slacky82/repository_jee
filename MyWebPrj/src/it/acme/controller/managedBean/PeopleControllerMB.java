package it.acme.controller.managedBean;

import it.acme.data.dto.PersonDTO;
import it.acme.ejb.stateless.PeopleRepositoryBeanRemote;
import it.acme.model.managedBean.PeopleModelMB;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name="peopleController")
@RequestScoped
public class PeopleControllerMB implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@EJB
	PeopleRepositoryBeanRemote peopleEjb;
	
	@ManagedProperty(value="#{peopleModel}")
	private PeopleModelMB model;	
	
	@PostConstruct
	public void postConstruct(){		
		init();
	}
	
	private void init(){	
		System.out.println("#peopleController: @PostConstruct CALLED!");
		//List<PersonDTO> people;		
		//people=peopleEjb.findPeople(null);
		//model.setLiked("all");
		//model.setPeople(people);
		
	}
	
	 public void likeChange(ValueChangeEvent event) {
		 System.out.println("#peopleController: valueChangeListener CALLED! ");
	        Object value = event.getNewValue();
	        if (value != null) {
	        	if ("TRUE".equalsIgnoreCase(value.toString())){
	        		model.setPeople(peopleEjb.findPeople(true));
	        	}
	        	if("FALSE".equalsIgnoreCase(value.toString())){
	        		model.setPeople(peopleEjb.findPeople(false));
	        	}
	        	if("ALL".equalsIgnoreCase(value.toString())){
	        		model.setPeople(peopleEjb.findPeople(null));
	        	}
	        	
	        }        
	    }
	
	

	public PeopleModelMB getModel() {
		return model;
	}

	public void setModel(PeopleModelMB model) {
		this.model = model;
	}
	
	

}

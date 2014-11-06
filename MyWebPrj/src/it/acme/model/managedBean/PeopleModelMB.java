package it.acme.model.managedBean;

import it.acme.data.dto.PersonDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name="peopleModel")
@SessionScoped
public class PeopleModelMB implements Serializable {	
	private static final long serialVersionUID = 1L;
	private List<PersonDTO> people;    
    private String liked;
    
    private List<SelectItem> likedSelectItems;   
    private Map<String, List<SelectItem>> likedSelectItem;

    
    
    @PostConstruct
    private void init(){
    	System.out.println("#peopleModel: @PostConstruct CALLED!!!! ");
    	buildSelectItem();    		
    }
    
    private void buildSelectItem(){
    	likedSelectItems = new ArrayList<SelectItem>();
    	likedSelectItems.add(new SelectItem("true","only liked"));
    	likedSelectItems.add(new SelectItem("false", "only not liked"));
    	likedSelectItems.add(new SelectItem("all" ,"doesn't care"));     	
    }
    
    public List<PersonDTO> getPeople() {
            return people;
    }

    public void setPeople(List<PersonDTO> people) {
            this.people = people;
    }

    public String getLiked() {
            return liked;
    }

    public void setLiked(String liked) {
            this.liked = liked;
    }

	public List<SelectItem> getLikedSelectItems() {
		return likedSelectItems;
	}

	public void setLikedSelectItems(List<SelectItem> likedSelectItems) {
		this.likedSelectItems = likedSelectItems;
	}

	public Map<String, List<SelectItem>> getLikedSelectItem() {
		return likedSelectItem;
	}

	public void setLikedSelectItem(Map<String, List<SelectItem>> likedSelectItem) {
		this.likedSelectItem = likedSelectItem;
	}
    
    
    

}

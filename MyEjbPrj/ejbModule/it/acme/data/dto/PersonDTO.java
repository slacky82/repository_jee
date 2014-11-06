package it.acme.data.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
    private Boolean like;
    
    public PersonDTO(String name,Boolean like){
    	this.name=name;
    	this.like=like;
    }
   
    public Boolean getLike() {
            return like;
    }
    public void setLike(Boolean like) {
            this.like = like;
    }
    public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }

}

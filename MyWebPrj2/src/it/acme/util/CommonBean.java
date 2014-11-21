package it.acme.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class CommonBean implements Serializable {	
	

	private static final long serialVersionUID = 1L;

	protected void createFacesMessage(String message, boolean errorType){
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	FacesMessage facesMessage = new FacesMessage("Message sent: " + message);    	
    	if(errorType){
    		facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
    	}
    	else{
    		 facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
    	}    	
        facesContext.addMessage(null, facesMessage);
    }  

}

package it.acme.controller.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import java.security.Principal;


@ManagedBean(name="user")
@SessionScoped
public class UserMB implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Principal userPrincipal;
	private String authType;
	private String remoteUser;
	
	@PostConstruct
	private void init(){
		System.out.println("#user: @PostConstruct CALLING!! ");
		ExternalContext exContent=FacesContext.getCurrentInstance().getExternalContext();		
		userPrincipal = exContent.getUserPrincipal();
		authType = exContent.getAuthType();
		remoteUser = exContent.getRemoteUser();		
	}


	public Principal getUserPrincipal() {
		return userPrincipal;
	}


	public void setUserPrincipal(Principal userPrincipal) {
		this.userPrincipal = userPrincipal;
	}


	public String getAuthType() {
		return authType;
	}


	public void setAuthType(String authType) {
		this.authType = authType;
	}


	public String getRemoteUser() {
		return remoteUser;
	}


	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}
	
	
	


}

package it.acme.data.dto;

import java.io.Serializable;

public class UserInfoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean loggedIn;
	
	
	
	public UserInfoDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

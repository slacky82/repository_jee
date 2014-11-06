package it.acme.data.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class MessageDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Timestamp date;
	private String message;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}

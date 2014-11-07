package it.acme.exception;

import javax.ejb.ApplicationException;
import javax.ejb.EJBException;

@ApplicationException(rollback = true)
public class BusinessException extends Exception  {
	private static final long serialVersionUID = 1L;
	
	public BusinessException(Exception re){
		super(re);
	}
	public BusinessException(Exception re, String message){
		super(message,re);
	}
	public BusinessException(){
		super();
	}
	

}

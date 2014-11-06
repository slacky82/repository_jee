package it.acme.exception;

import javax.ejb.ApplicationException;
import javax.ejb.EJBException;

@ApplicationException(rollback = true)
public class BusinessException extends EJBException  {
	private static final long serialVersionUID = 1L;
	
	public BusinessException(Exception re){
		super(re);
	}
	public BusinessException(Exception re, String message){
		super(message,re);
	}
	//test GIT
	

}

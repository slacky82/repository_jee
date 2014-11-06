package it.helloWorld.enterprise.data.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class LogInterceptorTo implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timestamp invocationTime;
	private String methodName;
	
	public Timestamp getInvocationTime() {
		return invocationTime;
	}
	public void setInvocationTime(Timestamp invocationTime) {
		this.invocationTime = invocationTime;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	
	
	

}

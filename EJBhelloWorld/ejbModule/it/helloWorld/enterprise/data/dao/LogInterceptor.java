package it.helloWorld.enterprise.data.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the log_interceptor database table.
 * 
 */
@Entity
@Table(name="log_interceptor")
@NamedQuery(name="LogInterceptor.findAll", query="SELECT l FROM LogInterceptor l")
public class LogInterceptor implements Serializable {
	private static final long serialVersionUID = 1L;	

	@Id
	@Column(name="invocation_time")
	private Timestamp invocationTime;

	@Column(name="method_name")
	private String methodName;

	public LogInterceptor() {
	}

	
	public Timestamp getInvocationTime() {
		return this.invocationTime;
	}

	public void setInvocationTime(Timestamp invocationTime) {
		this.invocationTime = invocationTime;
	}

	public String getMethodName() {
		return this.methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

}
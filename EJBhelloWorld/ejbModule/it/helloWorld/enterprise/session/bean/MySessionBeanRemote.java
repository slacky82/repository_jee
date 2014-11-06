package it.helloWorld.enterprise.session.bean;

import it.helloWorld.enterprise.data.dto.EmployeeTo;
import it.helloWorld.enterprise.exception.EnterpriseException;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface MySessionBeanRemote {
	public String testMyEjb();
	public List<EmployeeTo> findAllEmployee() throws EnterpriseException ;
	public <T> void deleteEntity(T objInput, Object id) throws EnterpriseException ;
	public String testReferenceAnotherEjb();
	public void addEmployee()throws EnterpriseException ;

}

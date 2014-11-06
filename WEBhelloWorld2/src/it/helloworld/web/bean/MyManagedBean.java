package it.helloworld.web.bean;

import it.helloWorld.enterprise.data.dto.EmployeeTo;
import it.helloWorld.enterprise.exception.EnterpriseException;
import it.helloWorld.enterprise.session.bean.MySatelessSessionBeanRemote;
import it.helloWorld.enterprise.session.bean.MySessionBeanRemote;
import it.helloWorld.enterprise.session.bean.MyStatefullSessionBeanRemote;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;


@ManagedBean(name= "myManagedBean")                  
@SessionScoped
public class MyManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EJB
	MySessionBeanRemote ejbFacade;	
	@EJB
	MyStatefullSessionBeanRemote foo1;	
	@EJB
	MyStatefullSessionBeanRemote foo2;	
	@EJB
	MySatelessSessionBeanRemote foo3;	
	@EJB
	MySatelessSessionBeanRemote foo4;
	
	private  List<EmployeeTo> listEmployee;
	
	public MyManagedBean(){}
	
	/*
	@PostConstruct
	public void init()
	{		
		//JavascriptContext.applicationFocus(FacesContext.getCurrentInstance(), "form:form_page_content");
		
		try {
			listEmployee=ejbFacade.findAllEmployee();
			System.out.println("####---MyManagedBean initialized");
		} catch (EnterpriseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/

	public  String deleteEmployee(String id){
		//EmployeeTo employee = (EmployeeTo)event.getComponent().getAttributes().get("employee");		
		try {
			ejbFacade.deleteEntity(EmployeeTo.class,id);
			listEmployee=ejbFacade.findAllEmployee();
		} catch (EnterpriseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "done";		
	}
	
	
	
	public void refreshEmployeeTable(ActionEvent event){
		try {
			listEmployee=ejbFacade.findAllEmployee();
			System.err.println("###---CALLING-REFRESH");
		} catch (EnterpriseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	public void addEmployee(ActionEvent event){
		try {
			ejbFacade.addEmployee();
		} catch (EnterpriseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	

	/**
	 * TEST PER LO STATO DI UN EJB STATELESS/STATEFULL
	 * @param event
	 */
	public void testStatoEjb(ActionEvent event){		
		System.out.println("CALL STATEFULL AND STATELESS!!");
		
		foo1.setValue(1);
		//foo2.setValue(1);
		System.err.println("foo1 value" + foo1.getValue());
		System.err.println("foo2 value" + foo2.getValue());
		
		foo3.setValue(100);
		System.err.println("foo3 value" + foo3.getValue());
		System.err.println("foo4 value" + foo4.getValue());
		
		//System.out.println("CALL TEST REFERENCE EJB");
		//System.out.println(ejbFacade.testReferenceAnotherEjb());
		
		 
		
	}
	
	
	//getter/mutator
	public List<EmployeeTo> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<EmployeeTo> listEmployee) {
		this.listEmployee = listEmployee;
	}
	
	
	
	
	
}


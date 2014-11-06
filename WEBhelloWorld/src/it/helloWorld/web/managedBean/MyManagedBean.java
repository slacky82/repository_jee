package it.helloWorld.web.managedBean;



import java.io.Serializable;
import java.util.List;

import it.helloWorld.enterprise.data.dto.EmployeeTo;
import it.helloWorld.enterprise.exception.EnterpriseException;
import it.helloWorld.enterprise.session.bean.MySessionBeanRemote;







import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name="myManagedBean")
@SessionScoped
public class MyManagedBean implements Serializable {
	
	private  List<EmployeeTo> listEmployee;
	
	@EJB
	MySessionBeanRemote ejbFacade;
	
	@PostConstruct
	public void init()
	{
		try {
			listEmployee=ejbFacade.findAllEmployee();
		} catch (EnterpriseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
		} catch (EnterpriseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	
	public void testMyManagedBean(ActionEvent event){
		System.err.println(ejbFacade.testMyEjb());		
		
	}

	public List<EmployeeTo> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<EmployeeTo> listEmployee) {
		this.listEmployee = listEmployee;
	}
	
	
	
	
}

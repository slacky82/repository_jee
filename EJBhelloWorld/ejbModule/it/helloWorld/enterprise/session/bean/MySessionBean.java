package it.helloWorld.enterprise.session.bean;



import java.util.List;

import it.helloWorld.enterprise.data.controller.ControllerNerdBean;
import it.helloWorld.enterprise.data.dto.EmployeeTo;
import it.helloWorld.enterprise.exception.EnterpriseException;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MySessionBean
 */
@Remote
@Stateless(mappedName = "myEjb")
public class MySessionBean implements MySessionBeanRemote {

	@EJB
	ControllerNerdBean controllerEjb;
	
	//@EJB
	//MySatelessSessionBean ejb2;
	
	@Resource 
	private SessionContext sessionContext;
   
    public MySessionBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String testReferenceAnotherEjb(){
    	MySatelessSessionBeanLocal myBean =  sessionContext.getBusinessObject(MySatelessSessionBeanLocal.class); 
        return myBean.test();
    	//return ejb2.test();
    }
    
    public List<EmployeeTo> findAllEmployee () throws EnterpriseException{
    	return controllerEjb.findAllEmployee() ;
    }
    
    @Override
	public <T> void deleteEntity(T objInput, Object id) throws EnterpriseException{		
			controllerEjb.deleteEntity(objInput, id);		
	}
    
    @Override
	public void addEmployee() throws EnterpriseException {
    	controllerEjb.insertObj();
		
	}
    
    

	@Override
	public String testMyEjb() {
		EmployeeTo obj= new EmployeeTo();
		obj.setId(null);
		obj.setName("name");
		obj.setSurname("surname");			
		//controllerEjb.findAllEmployee();		
		try {
			
			System.err.println("resList size:"+controllerEjb.findByEntity(obj).size());
			System.err.println("findByEntity DONE!");
			Thread.sleep(1000);
			controllerEjb.deleteEntity(obj, new Integer(11));
			System.err.println("deleteEntity DONE");
			//System.err.println("resList size:"+controllerEjb.findByEntity(obj).size());
						
			
		} catch (EnterpriseException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		
		return "MyEJB say HELLO!!!!";
	}

	


	

}

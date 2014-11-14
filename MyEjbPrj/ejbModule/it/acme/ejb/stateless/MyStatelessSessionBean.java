package it.acme.ejb.stateless;

import it.acme.interceptors.AInt;
import it.acme.util.MyData;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;

/**
 * Session Bean implementation class MyStatelessSessionBean
 */
@Stateless(mappedName = "StatelessEJB")
//@Interceptors(AInt.class)
public class MyStatelessSessionBean implements MyStatelessSessionBeanRemote, MyStatelessSessionBeanLocal {
	
	private String propertyA;
	

    /**
     * Default constructor. 
     */
    public MyStatelessSessionBean() {
        
    }
    
    @PostConstruct
    public void testPostConstruct(){
    	System.out.println("#StatelessEJB: @PostConstruct CALLED!!!");
    }
    
      
    /*@AroundInvoke
    public Object around(InvocationContext invCtx) throws Exception{
    	System.out.println("#StatelessEJB: method called: " + invCtx.getMethod().getName());
		return invCtx.proceed();		
	}
	*/
	
    @Override	
	public String sayHello() {				
		return "EJBStateless say: HELLO!!!";
	}
   
    @Interceptors(AInt.class)
    @Override
	public String sayGoodBye() {			
		return "EJBStateless say: GOODBYE!!!";
	}
    
    @Override
	public void foo(MyData data) {
		data.a=2;		
	}
    

	@Override
	public String getFielEjb() {
		return propertyA;
	}

	@Override
	public void setFieldEjb(String fieldValue) {
		this.propertyA=fieldValue;		
	}

	
	
	
	
	
	

}

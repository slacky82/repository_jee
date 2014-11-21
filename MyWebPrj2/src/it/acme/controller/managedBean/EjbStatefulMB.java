package it.acme.controller.managedBean;

import it.acme.ejb.stateful.MySatefulSessionBeanRemote;

import java.io.Serializable;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@ManagedBean(name="ejbStateful")
@SessionScoped
public class EjbStatefulMB implements Serializable {
	
	private int value;
	private int value2;


	
	private static final long serialVersionUID = 1L;
	MySatefulSessionBeanRemote foo1;
	MySatefulSessionBeanRemote foo2;
	
	
	
	public void actionListener(ActionEvent event){	
		this.foo1=getEjbRemoteLookup();
		this.foo2=getEjbRemoteLookup();	
		this.foo1.setValue(1);
		value=foo1.getValue();
		value2=foo2.getValue();		
	}
	
	
	 
	public void removeInstanceEjb(ActionEvent event){
		
	}
	
	private MySatefulSessionBeanRemote getEjbRemoteLookup(){
		MySatefulSessionBeanRemote ejbRefJNDI = null;
		Context context = null;
		Properties properties = new Properties();
		//properties.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		properties.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.impl.SerialInitContextFactory");
		properties.put(Context.SECURITY_PRINCIPAL,"weblogic");
		properties.put(Context.SECURITY_CREDENTIALS,"weblogic1");
		properties.put(Context.PROVIDER_URL,"t3://localhost:7001");		
		try {
			context = new InitialContext(properties);			
			ejbRefJNDI=(MySatefulSessionBeanRemote) context.lookup("statefulEJB#it.acme.ejb.stateful.MySatefulSessionBeanRemote");						
		} catch (NamingException e) {			
			e.printStackTrace();
		}
		return ejbRefJNDI;	
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}
	
	

}

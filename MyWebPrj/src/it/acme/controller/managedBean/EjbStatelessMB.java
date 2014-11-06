package it.acme.controller.managedBean;

import it.acme.ejb.stateless.MyStatelessSessionBeanRemote;
import it.acme.util.MyData;

import java.io.Serializable;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.xml.fastinfoset.util.StringArray;

@ManagedBean(name="ejbStateless")
@SessionScoped
public class EjbStatelessMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String resultCallEjb;

	@EJB
	MyStatelessSessionBeanRemote ejbRef;
	
	MyStatelessSessionBeanRemote ejbRefJNDI;
	
	@PostConstruct
	private void init(){
		System.out.println("#ejbStatelessMB: @PostConstruct CALLED!!!");
		this.ejbRefJNDI=getEjbRemoteLookup();
		this.resultCallEjb=ejbRefJNDI.sayHello();
		
	}
	
	
	public void callEjb(ActionEvent event){
		createMessage( ejbRefJNDI.sayGoodBye(),null);		
	}
	
	public void callEjbQuestion10(ActionEvent event){
		MyData data = new MyData();
		data.a=1;
		ejbRefJNDI.foo(data);	
		createMessage(String.valueOf(data.a),null);		
	}
	
	private void createMessage( String message, String detail){
		FacesContext fContext = FacesContext.getCurrentInstance();
		FacesMessage fMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
		fContext.addMessage(null, fMessage);		
	}

	
	
	private MyStatelessSessionBeanRemote getEjbRemoteLookup(){
		MyStatelessSessionBeanRemote ejbRefJNDI = null;
		Context context = null;
		Properties properties = new Properties();
		//properties.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		properties.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.impl.SerialInitContextFactory");
		properties.put(Context.SECURITY_PRINCIPAL,"weblogic");
		properties.put(Context.SECURITY_CREDENTIALS,"weblogic1");
		properties.put(Context.PROVIDER_URL,"t3://localhost:7001");		
		try {
			context = new InitialContext(properties);			
			ejbRefJNDI=(MyStatelessSessionBeanRemote) context.lookup("StatelessEJB#it.acme.ejb.stateless.MyStatelessSessionBeanRemote");						
		} catch (NamingException e) {			
			e.printStackTrace();
		}
		return ejbRefJNDI;	
	}

	public String getResultCallEjb() {
		return resultCallEjb;
	}

	public void setResultCallEjb(String resultCallEjb) {
		this.resultCallEjb = resultCallEjb;
	}
	
	

}

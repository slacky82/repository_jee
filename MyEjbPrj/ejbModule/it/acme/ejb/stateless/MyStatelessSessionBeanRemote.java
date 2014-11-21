package it.acme.ejb.stateless;

import it.acme.util.MyData;

import javax.ejb.Remote;

@Remote
public interface MyStatelessSessionBeanRemote {
	
	public String sayHello();
	public String sayGoodBye();
	public String getFielEjb();
	public void setFieldEjb(String fieldValue);
	public void foo(MyData data);	
}

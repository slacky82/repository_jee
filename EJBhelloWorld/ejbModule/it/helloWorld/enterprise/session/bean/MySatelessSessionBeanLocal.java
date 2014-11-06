package it.helloWorld.enterprise.session.bean;

import javax.ejb.Local;

@Local
public interface MySatelessSessionBeanLocal {
	
	public void setValue (int i);
	public int getValue ();
	public String test();


}

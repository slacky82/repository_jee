package it.helloWorld.enterprise.session.bean;

import javax.ejb.Remote;

@Remote
public interface MySatelessSessionBeanRemote {
	
	public void setValue (int i);
	public int getValue ();
	public String test();

}

package it.helloWorld.enterprise.session.bean;

import javax.ejb.Remote;

@Remote
public interface MyStatefullSessionBeanRemote {	
	public void setValue (int i);
	public int getValue ();
}

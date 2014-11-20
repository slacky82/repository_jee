package it.acme.ejb.stateful;

import javax.ejb.Remote;

@Remote
public interface MySatefulSessionBeanRemote {
	
	public int getValue();
	public void setValue(int value);
	public void removeEjb();
	

}

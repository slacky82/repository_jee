package it.helloWorld.enterprise.session.bean;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class MyStatefullSessionBean
 */
@Stateful(mappedName = "myStatefullEjb")
@Remote(MyStatefullSessionBeanRemote.class)
public class MyStatefullSessionBean implements MyStatefullSessionBeanRemote {
	
	@Resource private SessionContext sessionContext; 
	
	private int value;

    /**
     * Default constructor. 
     */
    public MyStatefullSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void setValue(int i) {
		value = i;
		
	}
	@Override
	public int getValue() {
		return value;
	}

}

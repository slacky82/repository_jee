package it.helloWorld.enterprise.session.bean;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MySatelessSessionBean
 */
@Stateless(name="mySatelessSession")
@Remote(MySatelessSessionBeanRemote.class)
@Local(MySatelessSessionBeanLocal.class)
public class MySatelessSessionBean implements MySatelessSessionBeanRemote, MySatelessSessionBeanLocal  {
	
	@Resource
	private SessionContext sessionContext;
	
	private int value;

    /**
     * Default constructor. 
     */
    public MySatelessSessionBean() {
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

	@Override
	public String test() {
		return "mySatelessSession say HELLOWORLD!!!";
		
	}

	

}

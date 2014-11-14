package it.acme.ejb.stateful;

import javax.ejb.Stateful;

/**
 * Session Bean implementation class MySatefulSessionBean
 */
@Stateful(mappedName = "statefulEJB")
public class MySatefulSessionBean implements MySatefulSessionBeanRemote, MySatefulSessionBeanLocal {
	
	private int value;

    /**
     * Default constructor. 
     */
    public MySatefulSessionBean() {
        // TODO Auto-generated constructor stub
    }

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}  
    
    
    
    
    
}

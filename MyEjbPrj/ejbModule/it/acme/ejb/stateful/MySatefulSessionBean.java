package it.acme.ejb.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class MySatefulSessionBean
 */
@Stateful(mappedName = "statefulEJB")
public class MySatefulSessionBean implements MySatefulSessionBeanRemote, MySatefulSessionBeanLocal {

	private int value;

	public MySatefulSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("#statefulEJB: @PostConstruct instance "
				+ this.hashCode() + " created");
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("#statefulEJB: @preDestroy CALLED!! instance "
				+ this.hashCode() + " deleted");
	}
	
	@Remove
	public String removeEjb() {
		System.out.println("#statefulEJB: @Remove");
		return "#statefulEJB: says GOODBY";
	}
	
	@Override
	public String callEjbStateful() {
		return "#statefulEJB: says HELLO";		
	}
	
	

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	

	

}

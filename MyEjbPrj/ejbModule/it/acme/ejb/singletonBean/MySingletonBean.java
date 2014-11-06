package it.acme.ejb.singletonBean;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class MySingleton
 */
@Singleton(mappedName = "singletonEJB")
public class MySingletonBean implements MySingletonRemote, MySingletonLocal {

    public static class Coordinate {
    	int x;
    	int y;
    }
	
    private Coordinate c = new Coordinate();
	
    public MySingletonBean() {

    } 
    
    public Coordinate getCoordinate(){
    	System.out.println("#singletonEJB: X="+c.x+" "+"Y="+ c.y);    	
    	return c;
    }
    public void setCoordinate(int newX, int newY){
    	c.x=newX;
    	c.y=newY;
    }
    
    @PostConstruct
    private void testconstruct(){
    	System.out.println("#singletonEJB: @PostConstruct CALLED!");
    }

	@Override
	public String sayHello() {
		System.out.println("#singletonEJB: sayHello() method called!");
		return "singletonEJB say Hello";
	}

}

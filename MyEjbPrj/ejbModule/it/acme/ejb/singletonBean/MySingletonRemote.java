package it.acme.ejb.singletonBean;

import it.acme.ejb.singletonBean.MySingletonBean.Coordinate;

import javax.ejb.Remote;

@Remote
public interface MySingletonRemote {

	public String sayHello();
	public Coordinate getCoordinate();
    public void setCoordinate(int newX, int newY);
}

package it.acme.controller.managedBean;

import it.acme.ejb.singletonBean.MySingletonRemote;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;


@ManagedBean(name="ejbSingleton")
@SessionScoped
public class EjbSingletonMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	MySingletonRemote ejbRef;
	
	public void writeCoordinate(ActionEvent event){	
		while(true){
			ejbRef.setCoordinate(0, 0);
			ejbRef.setCoordinate(1, 1);
		}
		
	}
	
	public void readCoordinate(ActionEvent event) {
		while (true) {
			ejbRef.getCoordinate();
		}
	}
	

}

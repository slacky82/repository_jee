package it.nerd.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
	

import org.primefaces.event.TabChangeEvent;

@ManagedBean(name="fooMB")
@SessionScoped
public class ManagedBeanFoo {
	
	private String fooProperty = "test";

	public void setFooProperty(String fooProperty) {
		this.fooProperty = fooProperty;
	}

	public String getFooProperty() {
		return fooProperty;
	}
	
	public void onChange(TabChangeEvent event) {
		System.out.println("Tab Changed :: You've Requested Seeing :: "+ event.getTab().getTitle());
	}
	
	

}

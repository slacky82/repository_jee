package it.helloWorld.web.jsf.managedbean;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="navigation")
@SessionScoped
public class NavigationManagedBean implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private String currentPage;
	private String currentTitle;
	
	private static ResourceBundle rb;
	static {
		rb = ResourceBundle.getBundle("Pages");
	}
	
	

}

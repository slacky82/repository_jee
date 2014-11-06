package it.acme.controller.managedBean;



import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name="navigationController")
@SessionScoped
public class NavigationControllerMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;		
	
	private String currentPage;
	
	@PostConstruct
	private void init(){
		System.out.println("#navigationControllerMB: @PostConstruct CALLED!!!");		
	}

	public void executeNavigation(ActionEvent event){
		System.out.println("#navigationControllerMB: executeNavigation(ActionEvent event) CALLED! ");
		String page=(String)event.getComponent().getAttributes().get("page");
		setCurrent(page);
	}
	
	private void setCurrent(String page){
		switch (page) {
		case "ejb_sateless":
			setCurrentPage("./main/stateless_ejb/stateless_ejb.xhtml");
			break;
		case "ejb_stateful":
			setCurrentPage("./main/stateful_ejb/stateful_ejb.xhtml");
			break;
		case "people":
			setCurrentPage("./main/people/people.xhtml");
			break;
		case "ejb_singleton":
			setCurrentPage("./main/singleton_ejb/singleton_ejb.xhtml");
			break;
		case "ejb_hibernate":
			setCurrentPage("./main/hibernate/hibernate_ejb.xhtml");
			break;
		case"jms_send_messsage":
			setCurrentPage("./main/jms/jms.xhtml");	
			break;
		default:
			setCurrentPage("./main/home/home.xhtml");	
			break;
		}		
	}

	//getter mutator
	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	

	
	
	
	
	
}

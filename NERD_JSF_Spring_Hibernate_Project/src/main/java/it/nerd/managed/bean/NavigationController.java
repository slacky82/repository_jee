package it.nerd.managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController")
@RequestScoped
public class NavigationController implements Serializable {
	
	@ManagedProperty(value="#{param.pageId}")
	private String pageId;
	
	private static final long serialVersionUID = 1L;
	
	//process
	public String processPage1(){
		return "page";
	}

	public String processPage2(){
		return "page";
	}
	
	//generic
	public String showPage() {
		if (pageId == null) {
			return "home";
		}
		
		if (pageId.equals("3")) {
			return "page3";
		} else if (pageId.equals("4")) {
			return "page4";
		} else if (pageId.equals("5")) {
			return "page5";
		} else {
			return "home";
		}
	}	
	
	
	
	//getter setter
	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

}

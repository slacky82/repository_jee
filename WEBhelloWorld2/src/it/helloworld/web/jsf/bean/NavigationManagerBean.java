package it.helloworld.web.jsf.bean;

import java.io.Serializable;

import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


@ManagedBean(name= "navigation")
@SessionScoped
public class NavigationManagerBean implements Serializable {

	/*
	@ManagedProperty(value="#{myManagedBean}")
	private MyManagedBean employeeManagedBean;
	*/
	private static final long serialVersionUID = 1L;
	private String currentPage;
	private String currentTitle;
	
	
	/**
	 * serve per ottenere dinamicamente il managedBean associato alla pagina
	 * @param beanName
	 * @return
	 */
	public Object getManagedBean(String beanName) {
	    FacesContext fc = FacesContext.getCurrentInstance();
	    Object bean;
	    
	    try {
	        ELContext elContext = fc.getELContext();
	        bean = elContext.getELResolver().getValue(elContext, null, beanName);
	    } catch (RuntimeException e) {
	        throw new FacesException(e.getMessage(), e);
	    }

	    if (bean == null) {
	        throw new FacesException("Managed bean with name '" + beanName
	            + "' was not found. Check your faces-config.xml or @ManagedBean annotation.");
	    }
	    return bean;
	}	
	
	
	private void setCurrent(String pathPage){		
		this.currentPage=pathPage;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	
	
	public void executeNavigation(ActionEvent evt){
		String pagePath = (String) evt.getComponent().getAttributes().get("pagePath");
		if (pagePath.equalsIgnoreCase("/main/gestione/employee/mainEmployee.xhtml")){
			//MyManagedBean mb=(MyManagedBean) getManagedBean("myManagedBean");	
			//employeeManagedBean.refreshEmployeeTable(evt);
		}
		
		setCurrent(pagePath);
		//setCurrent("main/gestione/employee/mainEmployee.xhtml");  
	}

/*
	public MyManagedBean getEmployeeManagedBean() {
		return employeeManagedBean;
	}


	public void setEmployeeManagedBean(MyManagedBean employeeManagedBean) {
		this.employeeManagedBean = employeeManagedBean;
	}
	*/
	
	
	

}

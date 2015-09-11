/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.nerdexception.managedbeans;

import it.nerdexception.beans.NewSessionBean;
import it.nerdexception.beans.facade.EmployeeFacade;
import it.nerdexception.entities.Employee;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author slacky
 */
@ManagedBean(name = "employee")
@SessionScoped
public class EmployeeManagedBean implements Serializable{
    
    @EJB
    private EmployeeFacade employeeFacade;

    @EJB
    private NewSessionBean newSessionBean;  
    
    private Integer id;
    private String name;
    private String surname;
    
    private List<Employee> items = null;
    private Employee selected;
    
        

    /**
     * Creates a new instance of UserManagedBean
     */
    public EmployeeManagedBean() {
    }
    
    @PostConstruct
    private void init(){
        System.out.println("#employeeMB: @PostConstruct CALLED!!!");            
    }
        
    public void getUserById(){
       FacesContext context = FacesContext.getCurrentInstance(); 
       try{
            Employee empl = employeeFacade.find(getId());
            if(empl != null){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Name: " + empl.getName(), "") );
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Surname: " + empl.getSurname(), "") );
            }else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
                    "Load operation",  "Employee not found") );
            }
       }catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "load operation error", e.toString()) );
        }         
    }
    
    public void saveEmploye() throws InterruptedException {             
        FacesContext context = FacesContext.getCurrentInstance();    
	try{
            employeeFacade.saveEmployee(selected);
            findAll();            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "save operation", "OK") );          
	}catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "save operation error", e.toString()) );                    
	}		
    }
    
    public void update(){
        if(selected != null){
            FacesContext context = FacesContext.getCurrentInstance();
            try{
            employeeFacade.edit(selected);
            findAll();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "employee as been updates", "success") ); 
        }catch (Exception e) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "remove operation error", e.toString()) );
            e.printStackTrace();
        }
        }       
    }
    
    public Employee prepareCreate() {
        System.out.println("prepareCreate called");
        selected = new Employee();
        return selected;
    }
    
    public void destroy() {
        System.out.println("destroy call");
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            employeeFacade.remove(selected);
            findAll();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "employee as been deleted", "success") ); 
        }catch (Exception e) {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
            "remove operation error", e.toString()) );
            e.printStackTrace();
        }
    }
    
    public void resetEmployee(){
        System.out.println("reset call");
        setName("");
        setSurname("");
    }

    public void findAll(){
        try{
            items = employeeFacade.findAll();
        }catch (Exception e) {
        
        }       
    }
    
    public void onChange(TabChangeEvent event) {
        System.out.println("bundle:"+ResourceBundle.getBundle("/label").getString("accordionPanel.firstTabTitle"));
        System.out.println("Tab Changed :: You've Requested Seeing :: "
                + event.getTab().getTitle()+"id: "+ event.getTab().getId() );
        if(event.getTab().getId().equals("employee_tab_03")){
            findAll();
        }
    }

    public Integer dummyMethod(ActionEvent event){
        System.out.println("dummyMethod is CALLED!!!");
        return 100;
    }
    
    
    //getters setters

    public List<Employee> getItems() {
        return items;
    }

    public void setItems(List<Employee> items) {
        this.items = items;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Employee getSelected() {
        return selected;
    }

    public void setSelected(Employee selected) {
        this.selected = selected;
    }

}

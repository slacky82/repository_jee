/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.nerdexception.beans.facade;

import it.nerdexception.entities.Employee;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author slacky
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@LocalBean
public class EmployeeFacade extends AbstractFacade<Employee> {
    
    @PersistenceContext(unitName = "UserPersistenceUnit")
    protected EntityManager em;
    
    public EmployeeFacade() {
        super(Employee.class);
    }
    
    @Override    
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void saveEmployee(Employee employee){
        em.persist(employee);
        //em.flush();      
    }
    
    
   
    
    public String testCall(){
        return "EmployeeFacade ejb say HELLO!!";
    }
    
}

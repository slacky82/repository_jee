package it.helloWorld.enterprise.data.controller;

import javax.management.RuntimeErrorException;
import javax.persistence.Entity;















import it.helloWorld.enterprise.data.annotation.TransferDomain;
import it.helloWorld.enterprise.data.dao.Employee;
import it.helloWorld.enterprise.data.dao.LogInterceptor;
import it.helloWorld.enterprise.data.dto.EmployeeTo;
import it.helloWorld.enterprise.exception.EnterpriseException;
import it.helloWorld.enterprise.mappings.util.BeanDeepDescriber;
import it.helloWorld.enterprise.mappings.util.DozerImpl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.internal.EntityManagerImpl;

/**
 * Session Bean implementation class ControllerNerdBean
 */
@Stateless
@LocalBean
public class ControllerNerdBean {
	
	@PersistenceContext(unitName = "NerdDbPU")
    private EntityManager em;
	
    public ControllerNerdBean() {        
    }
    
    /**
     * 
     * @param obj
     * @return
     * @throws EnterpriseException 
     */
    public Object test(Object obj) throws EnterpriseException{   	
    	Object objConverted = null;    	 
		if(!obj.getClass().isAnnotationPresent(Entity.class)){
			objConverted = convertTransferObjInEntity(obj);
		}
		return objConverted;
    }
    
    /**
     * esegue una find creando dinamicamente i criteria di hibernate
     * partendo dall'obj passato  
     * @param entity
     * @return
     * @throws EnterpriseException
     */
    public <T> List<T> findByEntity(T entity) throws EnterpriseException{
    	Object entityFilter=entity;
    	/*Check if is an Entity or TO*/
    	if (!entity.getClass().isAnnotationPresent(Entity.class))
    		entityFilter = convertTransferObjInEntity(entity);
    	Session hSession = ( (EntityManagerImpl) em.getDelegate() ).getSession();
    	Criteria criteria = hSession.createCriteria(entityFilter.getClass());
    	Map<String, Object> map = BeanDeepDescriber.describe(entityFilter);//<--------------
    	for (Entry<String, Object> entry : map.entrySet()) {
			if(entry.getValue() != null)
				criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
		}    	
		if(!entity.getClass().isAnnotationPresent(Entity.class)){
			return (List<T>) DozerImpl.mapList(criteria.list(), entity.getClass());		
		}
		return criteria.list();	
    } 

    /**
     * 
     * @param objInput
     * @throws EnterpriseException
     */
	public <T> void deleteEntity(T objInput, Object id)
			throws EnterpriseException {
		try {
			Session hSession = ((EntityManagerImpl) em.getDelegate()).getSession();
			if (!objInput.getClass().isAnnotationPresent(Entity.class)) {
				TransferDomain myAnn = objInput.getClass().getAnnotation(TransferDomain.class);
				Object res = hSession.load(Class.forName(myAnn.className()),(Serializable) id);
				hSession.delete(res);
			} else {
				Object res = hSession.load(objInput.getClass(),
						(Serializable) id);
				hSession.delete(res);
			}

		} catch (javax.persistence.EntityNotFoundException nFe) {
			throw new EnterpriseException(nFe);
		} catch (Exception e) {
			throw new EnterpriseException(e);
		}
	}
    
    
	
	/**
     * 
     * @return
     */
    public List<EmployeeTo> findAllEmployee (){   
    	List<EmployeeTo> resDTO = new ArrayList<EmployeeTo>();
        try {
        	Session hSession = ( (EntityManagerImpl) em.getDelegate() ).getSession();       	
        	List<Employee> resDAO;        	
            Query query = hSession.createQuery("from Employee");
            resDAO = query.list();
            return  DozerImpl.mapList(resDAO, EmployeeTo.class);
            /*
            for (Employee objSource : resDAO) {
            	resDTO.add(DozerImpl.getDozerBeanMapper().map(objSource, EmployeeTo.class));
            } 
            */                      
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;        
    }
    
   /**
    * 
    * @param inputObj
    * @return
 * @throws EnterpriseException 
    */
    //todo implementare il thrownew myException
	private Object convertTransferObjInEntity(Object inputObj) throws EnterpriseException {
		Object resObj = null;
		try {			
			if (!inputObj.getClass().isAnnotationPresent(TransferDomain.class)){				
				throw new EnterpriseException(inputObj.getClass()
						+ " non ha un TransferDomain associato");
			}
			else{
				TransferDomain myAnn = inputObj.getClass().getAnnotation(TransferDomain.class); 
				resObj= DozerImpl.getDozerBeanMapper().map(inputObj,Class.forName(myAnn.className()));
			}
		} catch (Exception e) {
			throw new EnterpriseException(e);
		}
		return resObj;				
	}
	
	public void insertObj() {
		try{
		Employee empl = new Employee();
		empl.setId(333);
		empl.setName("kkkkk");
		empl.setSurname("AAAA");
		Session hSession = ( (EntityManagerImpl) em.getDelegate() ).getSession();  
		hSession.persist(empl);	
		throw new RuntimeException();	
	}catch (Exception eX){
		
	}
	}
	

	
	@AroundInvoke
	public Object testInterceptor(InvocationContext inv) throws Exception {
		long time = System.currentTimeMillis();
		try {	
			/*
			LogInterceptor objDAO = new LogInterceptor();
			objDAO.setMethodName(inv.getMethod().toString());
			objDAO.setInvocationTime(new Timestamp(time));
			Session hSession = ((EntityManagerImpl) em.getDelegate()).getSession();
			hSession.saveOrUpdate(objDAO	);
			return inv.proceed();
			*/
			return inv.proceed();
		} finally {
			long diffTime = System.currentTimeMillis() - time;
			System.err.println("##INTERCEPTOR: " + inv.getMethod() + " took"
					+ diffTime + " milliseconds.");
		}
	}
    
}

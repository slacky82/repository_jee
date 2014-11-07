package it.acme.ejb.stateless;

import it.acme.data.dao.Employee;
import it.acme.data.dao.Message;
import it.acme.data.dto.EmployeeDTO;
import it.acme.exception.BusinessException;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.jpa.internal.EntityManagerImpl;

/**
 * Session Bean implementation class FilterStrategyFacade
 */
@Stateless(name = "filterStrategyFacade", mappedName = "filterStrategy")
public class FilterStrategyFacadeBean implements FilterStrategyFacadeRemote,
		FilterStrategyFacadeLocal {

	@Resource
	private EJBContext context;

	@PersistenceContext(unitName = "MyEjbPrj" /** , type =PersistenceContextType.TRANSACTION**/)
	private EntityManager entityManager;
	private Session hSession;

	public FilterStrategyFacadeBean() {
	}

	@PostConstruct
	private void init() {
		System.out.println("#filterStrategyFacade: @PostConstruct CALLED!! ");		
		// hSession = ( (EntityManagerImpl) entityManager.getDelegate()
		// ).getSession();
	}

	@Override
	public boolean insertEmployee(EmployeeDTO objDTO) throws BusinessException {
		try {
			System.out.println("#filterStrategyFacade: insertEmployee CALLED!! ");
			hSession = ((EntityManagerImpl) entityManager.getDelegate()).getSession();
			Employee objDAO = new Employee();
			objDAO.setId(objDTO.getId());
			objDAO.setName(objDTO.getName());
			objDAO.setSurname(objDTO.getSurname());
			hSession.persist(objDAO);
			System.out.println("#filterStrategyFacade: CallerPrincipalName "+ context.getCallerPrincipal().getName());
			throw new BusinessException();			
			//return true;
		}catch (Exception e) {				
			System.out.println("#filterStrategyFacade: catching ");
			throw new BusinessException(e, "Errore nel metodo  it.acme.ejb.stateless.FilterStrategyFacadeBean #insertEmployee ");			
			 //context.setRollbackOnly();			
		}	
	}

	@Override
	public boolean insertMessage(String message) throws BusinessException {
		try {
			System.out.println("#filterStrategyFacade: insertEmployee CALLED!! ");
			hSession = ((EntityManagerImpl) entityManager.getDelegate()).getSession();
			Message objDAO = new Message();			
			objDAO.setDate(new Timestamp( new Date().getTime()));
			objDAO.setMessage(message);
			hSession.persist(objDAO);
			System.out.println("#filterStrategyFacade: CallerPrincipalName "+ context.getCallerPrincipal().getName());
			// throw new NullPointerException();			
			return true;
		}catch (RuntimeException e) {			
			throw new BusinessException(e, "Errore nel metodo  it.acme.ejb.stateless.FilterStrategyFacadeBean #insertMessage ");			
		}
	}
	
	

}

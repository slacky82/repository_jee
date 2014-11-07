package org.data.filterstrategy.service.locator;

import it.cassaddpp.eas.exception.ServiceException;
import it.cassaddpp.eas.service.locator.ArcaServiceLocator;
import it.cassaddpp.eas.util.AbstractContextFactory;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.data.filterstrategy.service.data.session.FilterStrategyService;
import org.data.filterstrategy.util.FilterStrategyProperties;
import org.logger.Log;
import org.utility.DataUtility;
import org.utility.RuntimeUtility;

/**
 * @author Gerina Fabrizio fabrizio.gerina@capgemini.com
 *
 */
public class FilterStrategyServiceLocator extends ArcaServiceLocator {

	private FilterStrategyService fStgrServices;
	private FilterStrategyProperties properties;

	/**
	 * 
	 * @param acf
	 */
	public FilterStrategyServiceLocator(AbstractContextFactory acf, FilterStrategyProperties properties) {
		super(acf, properties.getServiceType());
		this.properties=properties;
		init();
	}

	@Override
	protected void init() {
		
	}

	@Override
	public boolean isServiceAvailable() {
		return !DataUtility.isEmpty(fStgrServices);
	}

	public FilterStrategyService getFilterStrategyService(Class<? extends FilterStrategyService> filterStrategyImpl) throws ServiceException {
		return this.getFilterStrategyService(filterStrategyImpl, null);
	}

	public FilterStrategyService getFilterStrategyService(Class<? extends FilterStrategyService> filterStrategyImpl, String ejbName) throws ServiceException {
		try {
			if (isServiceDIRECT()) {
				Class<?> beanImpl = Class.forName(filterStrategyImpl.getName()+"Bean");
				fStgrServices = (FilterStrategyService) RuntimeUtility.create(beanImpl, new Class[] { String.class },
						new Object[] { properties.getJpaServerType() });
			} else {
				fStgrServices = lookupFilterStrategyServiceRemote(filterStrategyImpl, ejbName);
			}
			return fStgrServices;
		} catch (Exception e) {
			Log.error(this, e.getMessage());
			throw new ServiceException(e);

		}		
	}
	
	public Object getRemoteService(String ejbName, Class<?> service) throws ServiceException {
		try {
			Context ctx = new InitialContext(acf.getEnvironment());
			Object serviceBean =  ctx.lookup(ejbName+"#"+service.getName());
			return serviceBean;			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Impossibile contattare il servizio FilterStrategyService (FilterStrategyServiceEjb): " + e.getMessage());
		}		
	}
	
	public Object getRemoteService(String ejbName) throws ServiceException {
		try {
			Context ctx = new InitialContext(acf.getEnvironment());
			Object serviceBean =  ctx.lookup(ejbName);
			return serviceBean;			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Impossibile contattare il servizio FilterStrategyService (FilterStrategyServiceEjb): " + e.getMessage());
		}		
	}	
	
	/**
	 *
	 * @return
	 * @throws ServiceException
	 *             FilterStrategyServiceEjb è il nome con cui viene mappato l'EJB nel
	 *             componente cmp.sispar-services (con l'uso della notation)
	 */
	private FilterStrategyService lookupFilterStrategyServiceRemote(Class<?> filterStrategyImpl, String ejbName) throws ServiceException {
		try {
			Context ctx = new InitialContext(acf.getEnvironment());
			FilterStrategyService service =  (FilterStrategyService) ctx.lookup(ejbName+"#"+filterStrategyImpl.getName());
			return service;			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Impossibile contattare il servizio FilterStrategyService (FilterStrategyServiceEjb): " + e.getMessage());
		}
	}

}

/**
 * 
 */
package org.data.filterstrategy.service.data.session;

import it.cassaddpp.eas.exception.ServiceException;

import java.util.List;

import javax.ejb.Local;

import org.data.filterstrategy.util.filter.FilterStrategy;

/**
 * @author Fabrizio Gerina fabrizio.gerina@capgemini.com
 * 
 */
@Local
public interface FilterStrategyServiceLocal extends FilterStrategyService {
	public <T> List<T> findByEntity(T entity) throws ServiceException;	
	public <T> List<T> findByEntity(FilterStrategy<T> filter) throws ServiceException;
}

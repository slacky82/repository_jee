package org.data.filterstrategy.service.data.session;

import it.cassaddpp.eas.exception.ServiceException;

import java.util.List;

import org.data.filterstrategy.util.filter.FilterStrategy;

/**
 * Interfacce servizi di accesso ai dati. Gli oggetti in input/output sono tipi dato primitivi o transfer objects. Interfaccia
 * servizio per insert/update dati da InputTO NB: la logica di update delle strutture dati corrispondenti agli oggetti di dominio
 * e' contenuta nell'implementazione del servizio
 *
 * @author Gerina Fabrizio fabrizio.gerina@capgemini.com
 *
 */
public interface FilterStrategyService {
	
	public <T> List<T> findByEntity(T entity) throws ServiceException;
	
	public <T> List<T> findByEntity(FilterStrategy<T> filter) throws ServiceException;
	
	public <T> T insertEntity(T entity) throws ServiceException;
	
	public <T> T deleteEntity(T entity) throws ServiceException;
	
	public <T> T updateEntity(T entity) throws ServiceException;
	
	public void clear() throws ServiceException;
	
}

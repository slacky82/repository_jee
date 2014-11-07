package org.service.ejb.data.session;


import it.cassaddpp.eas.exception.ServiceException;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.Entity;

import org.apache.commons.beanutils.PropertyUtils;
import org.data.filterstrategy.service.data.session.FilterStrategyService;
import org.data.filterstrategy.service.data.session.FilterStrategyServiceLocal;
import org.data.filterstrategy.util.TransferDomain;
import org.data.filterstrategy.util.filter.FilterStrategy;
import org.data.filterstrategy.util.filter.Strategy;
import org.ejb.eas.service.ArcaService;
import org.ejb.mapping.DozerMapper;
import org.ejb.service.util.BeanDeepDescriber;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


/**
 * @author Gerina Fabrizio fabrizio.gerina@capgemini.com
 * 
 */
@Stateless(name = "FilterStrategyService", mappedName = "FilterStrategyServiceEjb")
@Remote(value = FilterStrategyService.class)
@Local(value = FilterStrategyServiceLocal.class)

public abstract class FilterStrategyServiceBean extends ArcaService implements FilterStrategyService {

	public FilterStrategyServiceBean() {
		super();		
	}

	public FilterStrategyServiceBean(String jpaServerType) {
		super(jpaServerType);
	}

	protected abstract String getDozerMappingFile();
	
	@SuppressWarnings("unchecked")
	public <T> T insertEntity(T entity) throws ServiceException {
		
		try{
			Object entityFilter = convertEntity(entity);		
			begin();			
			getEntityManagerImpl().persist(entityFilter);			
			commitImp();			
			return (T) convertEntity(entityFilter, entity.getClass());
		} catch(Throwable th){
			throw new ServiceException("Errore nel metodo 'insertEntity' "+th.getMessage(), th);
		} finally{
			close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T deleteEntity(T entity) throws ServiceException {
		try{
			
			Object entityFilter = convertEntity(entity);		
			begin();
			Session session = (Session)getEntityManagerImpl().getDelegate();
			String pkName = session.getSessionFactory().getClassMetadata(entityFilter.getClass()).getIdentifierPropertyName();
			Serializable pk = (Serializable) PropertyUtils.getProperty(entityFilter, pkName);
			entityFilter = session.get(entityFilter.getClass(), pk);
			getEntityManagerImpl().remove(entityFilter);		
			commitImp();			
			return (T) convertEntity(entityFilter, entity.getClass());
		} catch(Throwable th){
			throw new ServiceException("Errore nel metodo 'deleteEntity' "+th.getMessage(), th);
		} finally{
			close();
		}		
	}
	
	public void clear() throws ServiceException {
		Session session = (Session)getEntityManagerImpl().getDelegate();
		session.clear();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T updateEntity(T entity) throws ServiceException {
		try{
			Object entityFilter = convertEntity(entity);		
			begin();
			Session session = (Session)getEntityManagerImpl().getDelegate();
			String pkName = session.getSessionFactory().getClassMetadata(entityFilter.getClass()).getIdentifierPropertyName();
			Serializable pk = (Serializable) PropertyUtils.getProperty(entityFilter, pkName);
			entityFilter = session.get(entityFilter.getClass(), pk);
			getEntityManagerImpl().merge(entityFilter);			
			commitImp();			
			return (T) convertEntity(entityFilter, entity.getClass());
		} catch(Throwable th){
			throw new ServiceException("Errore nel metodo 'updateEntity' "+th.getMessage(), th);
		} finally{
			close();
		}		
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> findByEntity(T entity) throws ServiceException{
		Object entityFilter = entity;
		/*Check if is an Entity or TO*/
		Annotation entityAnnotation = entity.getClass().getAnnotation(Entity.class);
		boolean isEntity = (entityAnnotation == null) ? false : true;
		if(!isEntity){
			entityFilter = convertEntity(entity);
		}
		Session session = (Session)getEntityManagerImpl().getDelegate();
		Criteria criteria = session.createCriteria(entityFilter.getClass());
		
		Map<String, Object> map = BeanDeepDescriber.describe(entityFilter);
		for (Entry<String, Object> entry : map.entrySet()) {
			if(entry.getValue() != null)
				criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
		}
		if(!isEntity){
			return (List<T>) DozerMapper.mapList(criteria.list(), entity.getClass(), getDozerMappingFile());
		}
		return criteria.list();	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> List<T> findByEntity(FilterStrategy<T> filter) throws ServiceException{
		Object entityFilter = filter.getEntity();
		/*Check if is an Entity or TO*/
		Annotation entityAnnotation = entityFilter.getClass().getAnnotation(Entity.class);
		boolean isEntity = (entityAnnotation == null) ? false : true;
		if(!isEntity){
			entityFilter = convertEntity(entityFilter);
		}
		Session session = (Session)getEntityManagerImpl().getDelegate();
		Criteria criteria = session.createCriteria(entityFilter.getClass());
		List<Object[]> list = filter.getStrategy();
		boolean rowCount = false;
		boolean max = false;
		String prop;
		for(Object []objs : list){
			Strategy strategy = (Strategy) objs[0];
			switch(strategy){
				case EQ:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.add(Restrictions.eq(prop, objs[2]));
					break;
				case NOT_EQ:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.add(Restrictions.ne(prop, objs[2]));
					break;
				case BETWEEN:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.add(Restrictions.between(prop, objs[2], objs[3]));
					break;
				case IN:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.add(Restrictions.in(prop, (Object[]) objs[2]));
					break;
				case IS_NOT_NULL:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.add(Restrictions.isNotNull(prop));
					break;
				case IS_NULL:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.add(Restrictions.isNull(prop));
					break;
				case LIKE:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.add(Restrictions.like(prop, objs[2]));
					break;
				case ILIKE:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.add(Restrictions.ilike(prop, objs[2]));
					break;
				case MAX_RESULTS:
					criteria.setMaxResults((Integer) objs[1]);
					break;
				case MAX:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.setProjection(Projections.max(prop));
					max=true;
					break;
				case ROW_COUNT:
					criteria.setProjection(Projections.rowCount());
					rowCount = true;
					break;	
				case ORDER_BY:
					Boolean asc = (Boolean) objs[1];
					String property = (String) objs[2];
					prop = (isEntity) ? property : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), property);
					criteria.addOrder((asc) ? Order.asc(prop) : Order.desc(prop));
					break;					
				case FIRST_RESULT:
					criteria.setFirstResult((Integer) objs[1]);
					break;
				case GREATER_THAN:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.add(Restrictions.gt(prop, objs[2]));
					break;
				case LESS_THAN:
					prop = (isEntity) ? objs[1].toString() : DozerMapper.getMappedProperty(entityFilter.getClass(), filter.getEntity().getClass(), objs[1].toString());
					criteria.add(Restrictions.lt(prop, objs[2]));
					break;
				default:
					throw new ServiceException("Strategia "+strategy + " non implementata!");
			}
		}
		if(!isEntity && !rowCount && !max){
			return (List<T>) DozerMapper.mapList(criteria.list(), filter.getEntity().getClass(), getDozerMappingFile());
		} else if(rowCount || max){
			List rowCountList = new ArrayList();
			rowCountList.add(criteria.uniqueResult());
			return rowCountList;
		}
		return criteria.list();	
	}
	 
	private Object convertEntity(Object entity) throws ServiceException{
		TransferDomain td = entity.getClass().getAnnotation(TransferDomain.class);
		if(td == null)
			throw new ServiceException(entity.getClass()+" non ha un TransferDomain associato");
		try {
			entity = DozerMapper.getMapper(getDozerMappingFile()).map(entity, Class.forName(td.className()));
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return entity;
	}
	
	private Object convertEntity(Object entity, Class<?> destination) throws ServiceException{
		try {
			entity = DozerMapper.getMapper(getDozerMappingFile()).map(entity, destination);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return entity;
	}	
	
}

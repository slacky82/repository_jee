package org.ejb.eas.service;

import it.cassaddpp.eas.consts.EasConsts;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class ArcaService {

	// ATTENZIONE MODIFICARE SE NON LOCAL
	private boolean isJpaServerTypeLOCAL = false;
	
	private EntityTransaction tx;

	@Resource
	private SessionContext ctx;

	public ArcaService() {
		isJpaServerTypeLOCAL = false;
	}

	public ArcaService(String jpaServerType) {
		this.isJpaServerTypeLOCAL = EasConsts.CONTENT_SERVER_TYPE_LOCAL.equalsIgnoreCase(jpaServerType);
	}

	public abstract String getUnitName();

	protected abstract EntityManager getEntityManager();

	protected abstract void setEntityManager(EntityManager em);

	protected SessionContext getCtx() {
		return ctx;
	}

	protected EntityManager getEntityManagerImpl() {
		if (isJpaServerTypeLOCAL) {
			if (getEntityManager() == null || (getEntityManager() != null && !getEntityManager().isOpen())) {
				setEntityManager(Persistence.createEntityManagerFactory(getUnitName()).createEntityManager());
			}
		}

		return getEntityManager();
	}

	protected void close() {
		if (isJpaServerTypeLOCAL) {
			getEntityManagerImpl().close();
		}
	}

	protected void begin() {
		if (isJpaServerTypeLOCAL) {
			tx = getEntityManagerImpl().getTransaction();
			tx.begin();
		}
	}

	protected void persist(Object obj) {
		getEntityManagerImpl().persist(obj);
		if (isJpaServerTypeLOCAL) {
			tx.commit();
		}
	}

	protected Object merge(Object obj) {
		Object o = getEntityManagerImpl().merge(obj);
		if (isJpaServerTypeLOCAL) {
			tx.commit();
			getEntityManagerImpl().refresh(o);
		}
		return o;
	}

	protected void commitImp() {
		if (isJpaServerTypeLOCAL) {
			tx.commit();
		}
	}

	protected void remove(Object obj) {
		getEntityManagerImpl().remove(obj);
		if (isJpaServerTypeLOCAL) {
			tx.commit();
		}
	}
	
	
	
	

}

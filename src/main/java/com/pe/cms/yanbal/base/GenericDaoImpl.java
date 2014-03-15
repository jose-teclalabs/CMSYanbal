package com.pe.cms.yanbal.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDaoImpl<E> implements GenericDao<E> {

	private final Log log = LogFactory.getLog(getClass());

	@PersistenceContext
	protected EntityManager entityManager;
 
	protected E instance;
	private Class<E> entityClass;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) throws Exception {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void persist(E e) throws Exception {
		try {
			getEntityManager().persist(e);
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	@Transactional
	public void remove(Object id) throws Exception {
		try {
			getEntityManager().remove((E) getEntityManager().find(getEntityClass(), id));
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public E findById(Object id) throws Exception {
		try {		
			return (E) getEntityManager().find(getEntityClass(), id);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	@Transactional
	public void merge(E e) throws Exception {	
		getEntityManager().merge(e);
	}

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() throws Exception {
		if (entityClass == null) {
			Type type = getClass().getGenericSuperclass();
			if (type instanceof ParameterizedType) {
				ParameterizedType paramType = (ParameterizedType) type;
				if (paramType.getActualTypeArguments().length == 2) {
					if (paramType.getActualTypeArguments()[1] instanceof TypeVariable) {
						throw new IllegalArgumentException("Could not guess entity class by reflection");
					} else {
						entityClass = (Class<E>) paramType.getActualTypeArguments()[1];
					}
				} else {
					entityClass = (Class<E>) paramType.getActualTypeArguments()[0];
				}
			}
		}
		return entityClass;
	}
}

package com.nbh.domain.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nbh.domain.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	protected Class<T> entityType;
	
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Class<T> getEntityType() {
		if (entityType == null) {
			Type genType = getClass().getGenericSuperclass();  
	        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
	        entityType = (Class<T>) params[0];
		}
		return entityType;
	}
	
	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Session openSession() {
		return sessionFactory.openSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) {
		return (T) openSession().get(getEntityType(), id);
	}

	@Override
	public Serializable save(T entity) {
		return openSession().save(entity);
	}

	@Override
	public void update(T entity) {
		openSession().update(entity);
	}

	@Override
	public void merge(T entity) {
		openSession().merge(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		delete(findById(id));
	}

	@Override
	public void delete(T entity) {
		openSession().delete(entity);
	}

	@Override
	public boolean exists(Serializable id) {
		return null != findById(id);
	}	

}

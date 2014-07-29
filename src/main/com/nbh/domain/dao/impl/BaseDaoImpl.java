package com.nbh.domain.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nbh.domain.dao.BaseDao;

@Transactional
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
	
	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) {
		return (T) getSession().get(getEntityType(), id);
	}

	@Override
	public Serializable save(T entity) {
		return getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSession().merge(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		delete(findById(id));
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public boolean exists(Serializable id) {
		return null != findById(id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Criteria criteria = getSession().createCriteria(getEntityType());
		return (List<T>) criteria.list();
	}

}

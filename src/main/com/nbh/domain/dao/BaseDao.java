package com.nbh.domain.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	
	Class<T> getEntityType();
	
	SessionFactory getSessionFactory();

	void setSessionFactory(SessionFactory sessionFactory);
	
	Session openSession();
	
	T findById(Serializable id);
	
	Serializable save(T entity);
	
	void update(T entity);
	
	void merge(T entity);
	
	void delete(Serializable id);
	
	void delete(T entity);
	
	boolean exists(Serializable id);
	
	long count(Criteria criteria);
	
	List<T> findAll(Criteria criteria);
	
	List<T> findAll(DetachedCriteria  detachedCriteria);
}

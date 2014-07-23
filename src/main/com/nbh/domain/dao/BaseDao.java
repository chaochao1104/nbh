package com.nbh.domain.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface BaseDao<T> {
	
	Class<T> getEntityType();
	
	SessionFactory getSessionFactory();

	void setSessionFactory(SessionFactory sessionFactory);
	
	Session openSession();
	
	T findById(Serializable id);
	
	Serializable save(T entity);
	
	void update(T entity);
	
	void merge(T entity);
	
	void deleteById(Serializable id);
	
	void delete(T entity);
	
	boolean exists(Serializable id);
	
}

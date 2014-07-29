package com.nbh.domain.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface BaseDao<T> {
	
	Class<T> getEntityType(); 
	
	void setSessionFactory(SessionFactory sessionFactory);
	
	Session getSession();
	
	T findById(Serializable id);
	
	Serializable save(T entity);
	
	void update(T entity);
	
	void deleteById(Serializable id);
	
	void delete(T entity);
	
	boolean exists(Serializable id);

	List<T> findAll();
}


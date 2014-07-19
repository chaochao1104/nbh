package com.nbh.domain.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nbh.domain.entity.demo.Person;

public class PersonDao {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session openSession() {
		return sessionFactory.openSession();
	}
	
	public List<Person> findAllPoeple() {
		List<Person> people = openSession().createQuery("from Person").list();
		return people;
	}
}

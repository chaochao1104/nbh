package com.nbh.domain.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.nbh.domain.entity.demo.Person;

public class PDao {
	
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
	
	public Person findById(long id) {
		Session session = openSession();
		DetachedCriteria dq = DetachedCriteria.forClass(Person.class, "p")
				.add(Property.forName("oid").eq(id));
	
		Criteria criteria = dq.getExecutableCriteria(session);
		
		Person p = (Person) criteria.uniqueResult();
		return p;
	}
}

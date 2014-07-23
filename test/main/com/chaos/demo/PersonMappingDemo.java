package com.chaos.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nbh.domain.entity.demo.Person;
import com.nbh.domain.utils.HibernateUtil;

public class PersonMappingDemo {
	
	public static final void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Person p = new Person();
		p.setBirthDate(new Date());
		p.setIsMale(false);
		p.setDescription("testing...");
		p.setWeight(72222.0d);
		
		session.save(p);
		transaction.commit();
		
		p = (Person) session.get(Person.class, 1L);
		
		System.out.println(p.getId());
		
		session.close();
	}
}

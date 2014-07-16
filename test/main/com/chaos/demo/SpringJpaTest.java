package com.chaos.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nbh.domain.entity.demo.Person;

public class SpringJpaTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context-nbh.xml"); 
		SessionFactory factory = null;
		Session session=null;
		try {
			factory = (SessionFactory)context.getBean("sessionFactory");  
			session = factory.openSession();  
			Person p = (Person) session.get(Person.class, 1);  
			System.out.println(p.getIsMale());  
		} catch (BeansException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		} catch (HibernateException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}finally{  
			if(session!=null)session.close();  
			if(factory!=null)factory.close();  
		}  
	}  
}



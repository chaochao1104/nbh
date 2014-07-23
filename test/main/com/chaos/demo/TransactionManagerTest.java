package com.chaos.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nbh.domain.dao.PDao;
import com.nbh.domain.dao.PersonDao;
import com.nbh.domain.entity.demo.Person;

public class TransactionManagerTest {

	private PersonDao personDao;
	
	@Autowired
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public void testPersonDao() {
		Person p = personDao.findById(1L);
		System.out.println(p.getBirthDate());
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context-nbh.xml");
		PDao dao = (PDao) context.getBean("pDao");
		List<Person> list = dao.findAllPoeple();
		for (Person p : list) {
			System.out.println(p.getWeight());
		}
		
		//TransactionManagerTest t = new TransactionManagerTest();
		//t.testPersonDao();
		PersonDao personDao = (PersonDao) context.getBean("personDao");
		Person person = personDao.findById(1L);
		System.out.println(person.getId());
		
	}

}

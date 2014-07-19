package com.chaos.demo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nbh.domain.dao.PersonDao;
import com.nbh.domain.entity.demo.Person;

public class TransactionManagerTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-context-nbh.xml");
		PersonDao dao = (PersonDao) context.getBean("personDao");
		List<Person> list = dao.findAllPoeple();
		for (Person p : list) {
			System.out.println(p.getWeight());
		}
	}

}

package com.nbh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.nbh.domain.dao.PDao;
import com.nbh.domain.entity.demo.Person;
import com.nbh.service.PersonService;

public class PersonServiceImpl implements PersonService {
	
	private PDao personDao;
			
	public Person getPerson(String id) { 
		   System.out.println("person id = " + id);
		   Person p = personDao.findById(Long.valueOf(id));
		   return p;
	}

	public PDao getPersonDao() {
		return personDao;
	}
	
	@Autowired
	public void setPersonDao(PDao personDao) {
		this.personDao = personDao;
	}

}

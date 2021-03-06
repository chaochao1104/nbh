package com.nbh.domain.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nbh.domain.dao.PersonDao;
import com.nbh.domain.entity.demo.Person;

@Repository("personDao")
@Transactional
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao { 
	
}

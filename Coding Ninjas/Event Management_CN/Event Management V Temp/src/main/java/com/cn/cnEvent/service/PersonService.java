package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.PersonDAL;
import com.cn.cnEvent.entity.Person;

@Service
public class PersonService {
	
	
	@Autowired 
	PersonDAL personDal;
	
	@Transactional
	public Person getPersonById(Long id) {
		Person person = personDal.getPersonById(id);
		
		return person;
	}
	
	
	@Transactional
	public List<Person> getAllPerson(){
		List<Person> allPerson = personDal.getAllPerson();
		
		return allPerson;
	}


	public String save(Person person) {
		// TODO Auto-generated method stub
		return personDal.save(person);
	}
}

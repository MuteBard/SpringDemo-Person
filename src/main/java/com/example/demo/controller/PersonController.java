package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.PersonDaoImpl.PersonDao;
import com.example.demo.model.Person;



@RestController
public class PersonController {

	@Autowired
	PersonDao pDao;
	
	@RequestMapping("/person1")
	public Person getPerson() {
		return pDao.getAllUsers().get(0);
	}
	
	@RequestMapping("/person2")
	public Person getPerson2() {
		return pDao.getAllUsers().get(1);
	}


}

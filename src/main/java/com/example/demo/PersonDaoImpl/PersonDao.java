package com.example.demo.PersonDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;



@Repository
public class PersonDao {
	
	@Autowired
	private DataSource ds;
	private JdbcTemplate template;
	
	@PostConstruct
	public void initDataSource() {
		System.out.println("POST CONSTRUCT");
		template = new JdbcTemplate(ds);
		ArrayList<Person> list = (ArrayList) this.getAllUsers();

	}

	public List<Person> getAllUsers() {
		System.out.println(template.query("SELECT * FROM person", new BeanPropertyRowMapper<Person>(Person.class)));
		return template.query("SELECT * FROM person", new BeanPropertyRowMapper<Person>(Person.class));
	}

}
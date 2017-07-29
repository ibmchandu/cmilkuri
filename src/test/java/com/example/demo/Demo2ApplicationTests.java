package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.example")
@EnableMongoRepositories(basePackages="com.example.repository")
public class Demo2ApplicationTests {
@Autowired
CustomerRepository cd;
	@Test
	public void contextLoads() {
		List<Customer> c=cd.findAll();
		System.out.println(c);
	}

	@Test
	public void insertValues() {
		Customer customer= new Customer();
		customer.setId("201");
		customer.setName("JAVA");
		List<Customer> c=cd.findAll();
		System.out.println("Before Values"+c);
		cd.save(customer);
		List<Customer> m=cd.findAll();
		System.out.println("Hello"+m);
		
		System.out.println("After insert values"+cd);
	}
}

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService cs;
	@RequestMapping(value="/api/details", method=RequestMethod.GET)
	public List<Customer> getDetails(){
		return cs.getDeatls();
		
	}

}

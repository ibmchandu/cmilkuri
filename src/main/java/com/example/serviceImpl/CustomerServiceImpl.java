package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
@Service
public class CustomerServiceImpl  implements CustomerService{
	@Autowired
	CustomerRepository cs;

	@Override
	public List<Customer> getDeatls() {
		// TODO Auto-generated method stub
		return cs.findAll();
	}

}

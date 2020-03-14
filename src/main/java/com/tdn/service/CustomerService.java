package com.tdn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdn.model.Customer;
import com.tdn.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerRepository customer;
	
	public void saveCustomer(Customer customers) {
		customer.save(customers);
	}
	public List<Customer> listAll() {
        return customer.findAll();
    }

}

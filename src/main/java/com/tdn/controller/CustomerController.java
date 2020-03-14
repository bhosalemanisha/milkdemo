package com.tdn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tdn.model.Customer;
import com.tdn.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	CustomerService customerservice;
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerservice.saveCustomer(customer);
	     
	    return "redirect:/";
	}
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Customer> listCustomers = customerservice.listAll();
	    model.addAttribute("listCustomers", listCustomers);
	     
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewCustomerPage(Model model) {
	    Customer customer = new Customer();
	    model.addAttribute("customer", customer);
	     
	    return "add-customer";
	}
}



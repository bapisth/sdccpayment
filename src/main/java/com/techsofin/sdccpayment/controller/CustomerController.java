package com.techsofin.sdccpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository costumerRepository;
	
	@GetMapping(vlaue = "/listCustomer")
	
	
	

}

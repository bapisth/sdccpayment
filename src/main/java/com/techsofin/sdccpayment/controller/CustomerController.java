package com.techsofin.sdccpayment.controller;

import java.awt.print.Pageable;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.techsofin.sdccpayment.entity.Customer;
import com.techsofin.sdccpayment.repository.CustomerRepository;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private CustomerRepository costumerRepository;
	
	/*@GetMapping(value = "/listCustomer")
	public ModelMap list(@PageableDefault(size = 5) Pageable pageable, @RequestParam
			(name = "value", required = false) String value, Model model) {
        if (value != null) {
           
            return new ModelMap().addAttribute("customers", CustomerRepository.findByNameContainingIgnoreCase(value, pageable));
        } else {
            return new ModelMap().addAttribute("customers", CustomerRepository.findAll(pageable));
        }
    }*/

    @GetMapping("/formCustomer")
    public ModelMap showCustomer(@RequestParam(value = "id", required = false) Customer customer) {
        if (customer == null) {
            customer = new Customer();
        }
        return new ModelMap("customer", customer);
    }

    @PostMapping(value = "/formCustomer")
    public String submit(@Valid @ModelAttribute Customer customer, BindingResult errors, SessionStatus status, Model model) {

        // if the form has any errors
        if (errors.hasErrors()) {
            return "customer/createCustomer";
        }

       

    
        return "redirect:/customer/listCustomer";
    }

    @GetMapping("/deleteCustomer")
    public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) Customer customer ) {
        return new ModelMap("customer", customer);
    }
}




   /* @PostMapping("/deleteCustomer")
    public Object delete(@ModelAttribute Customer customer , SessionStatus status) {
        try{
           CustomerRepository.delete(ustomer);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", customer.getCustomerName())
                    .addObject("entityName", "Customer")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink","/customer/listCustomer");
        }
        status.setComplete();
        return "redirect:/customer/listCustomer";
    }
}
	*/
	
	



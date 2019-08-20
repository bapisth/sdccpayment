package com.techsofin.sdccpayment.controller;

import com.techsofin.sdccpayment.entity.Collection;
import com.techsofin.sdccpayment.entity.User;
import com.techsofin.sdccpayment.repository.CollectionRepository;
import com.techsofin.sdccpayment.repository.CustomerRepository;
import com.techsofin.sdccpayment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("nav_active", "home");
        return "home";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout-success")
    public String logoutSuccess() {
        return "logout-success";
    }
}

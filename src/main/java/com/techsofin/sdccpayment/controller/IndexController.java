package com.techsofin.sdccpayment.controller;

import com.techsofin.sdccpayment.entity.Collection;
import com.techsofin.sdccpayment.entity.User;
import com.techsofin.sdccpayment.repository.CollectionRepository;
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

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("companyName", "Techsofin");
        //fetch all the collections and want to show it in page

        List<User> byNameLikeAndUsernameEquals = userRepository.findByNameLikeAndUsernameEquals("%Admin%", "admin");

        System.out.println(byNameLikeAndUsernameEquals);

        List<User> byNameLikeAndUsernameLike = userRepository.findByNameLikeAndUsernameLike("%Admin%", "%ad%");
        System.out.println(byNameLikeAndUsernameLike);

        //Dummy Collection Object
        Collection collection = new Collection();
        collection.setAmount(13.20);
        collection.setColectionDate(new Date());

        //Using this I am saving the data to the database
        collectionRepository.save(collection);

        //fetch all the data from collection table
        List<Collection> collections = collectionRepository.findAll();
        System.out.println(collections);
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

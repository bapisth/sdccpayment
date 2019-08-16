package com.techsofin.sdccpayment.controller;

import com.techsofin.sdccpayment.entity.User;
import com.techsofin.sdccpayment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/list")
    public ModelMap list(@PageableDefault(size = 5) Pageable pageable, @RequestParam(name = "value", required = false) String value, Model model) {
        if (value != null) {
            model.addAttribute("key", value);
            return new ModelMap().addAttribute("users", userRepository.findByNameContainingIgnoreCase(value, pageable));
        } else {
            return new ModelMap().addAttribute("users", userRepository.findAll(pageable));
        }
    }

    @GetMapping("/form")
    public ModelMap showUser(@RequestParam(value = "id", required = false) User user) {
        if (user == null) {
            user = new User();
        }
        return new ModelMap("user", user);
    }

    @PostMapping(value = "/form")
    public String submit(@Valid @ModelAttribute User user, BindingResult errors, SessionStatus status, Model model) {

        // if the form has any errors
        if (errors.hasErrors()) {
            return "user/create";
        }

        String encodePassword = "";
        if (Objects.nonNull(user)) {
            String password = user.getPassword();
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            encodePassword = bCryptPasswordEncoder.encode(password);
        }

        user.setPassword(encodePassword);
        user.setDeleted(false);
        userRepository.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete")
    public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) User user ) {
        return new ModelMap("user", user);
    }




    @PostMapping("/delete")
    public Object delete(@ModelAttribute User user , SessionStatus status) {
        try{
            userRepository.delete(user);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
            return new ModelAndView("error/errorHapus")
                    .addObject("entityId", user.getName())
                    .addObject("entityName", "User")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink","/user/list");
        }
        status.setComplete();
        return "redirect:/user/list";
    }
}

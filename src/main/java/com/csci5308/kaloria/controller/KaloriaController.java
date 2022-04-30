package com.csci5308.kaloria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csci5308.kaloria.admin.AdminPersistence;

@Controller
public class KaloriaController {
    AdminPersistence ap = new AdminPersistence();

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String home() {
        return "Admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return "index";
    }

    @RequestMapping("/signup")
    public String register() {
        return "Signup";
    }

    @RequestMapping("/appointments")
    public String bookAppointment(){return "book-dietician-appointment";}

}

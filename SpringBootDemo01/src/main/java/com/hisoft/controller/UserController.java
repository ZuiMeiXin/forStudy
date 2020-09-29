package com.hisoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("username","小呆呆");
        return "index";
    }

}

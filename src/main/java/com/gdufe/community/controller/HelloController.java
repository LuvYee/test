package com.gdufe.community.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false) String name , Model model ){
        model.addAttribute("name",name);
        return("hello");
    }
}

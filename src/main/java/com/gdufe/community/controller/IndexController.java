package com.gdufe.community.controller;

import com.gdufe.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return("index");
    }
}

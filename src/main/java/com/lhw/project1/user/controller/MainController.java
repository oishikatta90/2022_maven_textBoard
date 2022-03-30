package com.lhw.project1.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/project1/home/main")
    public String showMain() {
        return "project1/home/main";
    }
}

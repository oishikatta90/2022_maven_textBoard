package com.lhw.project1.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class UserController {

    @RequestMapping("/users")
    @ResponseBody
    public String users() {
        return "안녕!";
    }
}

package com.wang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "oauth/login";
    }
    @RequestMapping("/")
    public String index() {
        return "layout/index";
    }
}
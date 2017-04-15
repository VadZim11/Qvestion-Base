package com.springProject.controller;

import com.springProject.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    Message message;


    @RequestMapping("/")
     public String hello(Model model) {
        model.addAttribute("hello", "basic spring");
        return "hello";
     }

    @RequestMapping("/hello")
     public String next(Model model){
        model.addAttribute("row",  message.getHello());
        return "next";
        }
}

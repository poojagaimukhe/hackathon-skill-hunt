package com.hackathon.skillhunt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class userController {

    @GetMapping("/welcome")
    public String welcomeToUser() {
        //return bookService.findAll();
        return "welcome user";
    }
}

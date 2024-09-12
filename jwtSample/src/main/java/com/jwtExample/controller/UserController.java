package com.jwtExample.controller;

import com.jwtExample.entities.User;
import com.jwtExample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<User> regitserUser(@RequestBody User user){
        User user1 = userService.registerUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public String loginUserr(@RequestBody User user){

        return userService.validateUser(user);
    }
    @GetMapping("/Hello")
    public String hello()
    {
        return "Hello";
    }

}

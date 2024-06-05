package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.User;
import com.codinftitans.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("users")
    public List<User> findAll(){
       return userService.findAll();
    }
    @PostMapping("user/new")
    public User newUser(User user){
     return    userService.newUser(user);
    }

}

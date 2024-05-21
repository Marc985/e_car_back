package com.codinftitans.backend.controller;

import com.codinftitans.backend.model.User;
import com.codinftitans.backend.repository.UserRepository;
import com.codinftitans.backend.service.AdminService;
import com.codinftitans.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    AdminService adminService;
    @PostMapping("user/new")
    public User newUser(User user){
     return    adminService.newUser(user);
    }
}

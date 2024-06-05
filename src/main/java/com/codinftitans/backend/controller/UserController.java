package com.codinftitans.backend.controller;

import com.codinftitans.backend.dto.response.UserResponseDTO;
import com.codinftitans.backend.model.User;
import com.codinftitans.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO> >findAll(){
        List<UserResponseDTO> users=userService.findAll();
        long count=users.size();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("X-Total-Count",String.valueOf(count));
        return new ResponseEntity<>(users,httpHeaders, HttpStatus.OK);
    }
    @PostMapping("user/new")
    public User newUser(User user){
     return    userService.newUser(user);
    }

}

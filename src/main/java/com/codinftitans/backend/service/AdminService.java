package com.codinftitans.backend.service;

import com.codinftitans.backend.model.User;
import com.codinftitans.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserRepository userRepository;
    public User newUser(User user){
        //String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword("{noop}"+user.getPassword());
        return userRepository.save(user);

    }
}

package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.response.UserResponseDTO;
import com.codinftitans.backend.model.User;
import com.codinftitans.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;
    public String delteUser(String username){
        userRepository.deleteById(username);
        return "deleted sucessfully";
    }

    public User newUser(User user){
        //String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword("{noop}"+user.getPassword());
        return userRepository.save(user);

    }
    public List<UserResponseDTO> findAll(){
        return  userRepository.findAll().stream().map(
                user -> modelMapper.map(user,UserResponseDTO.class)
        ).toList();
    }
}

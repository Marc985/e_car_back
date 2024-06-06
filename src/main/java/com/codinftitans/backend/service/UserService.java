package com.codinftitans.backend.service;

import com.codinftitans.backend.dto.request.UserRequestDTO;
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
    public String deleteUser(UUID id){
        userRepository.deleteById(id);
        return "deleted sucessfully";
    }

    public User newUser(UserRequestDTO user){
        //String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword("{noop}"+user.getPassword());
        User userToSave=modelMapper.map(user,User.class);

        return userRepository.save(userToSave);

    }
    public List<UserResponseDTO> findAll(){
        return  userRepository.findAll().stream().map(
                user -> modelMapper.map(user,UserResponseDTO.class)
        ).toList();
    }
}

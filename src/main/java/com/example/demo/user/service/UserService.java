package com.example.demo.user.service;

import com.example.demo.group.repository.GroupRepository;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User userObj){
        userRepository.save(userObj);
    }

    public List<User> getUserDetails(Long userId){
        if (null != userId){
            return userRepository.findAllByUserId(userId);
        } else{
            return userRepository.findAll();
        }
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}
